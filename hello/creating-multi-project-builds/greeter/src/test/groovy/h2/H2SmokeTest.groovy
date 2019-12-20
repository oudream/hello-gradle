package h2

import org.apache.commons.io.FileUtils
import spock.lang.Specification
import tools.PropertyReader

import java.sql.*

class H2SmokeTest extends Specification {

	def 'H2 DB init smoke test'() {
		when: 'init DB method invoked'
			final actual = h2Init()

		then: 'output is correct'
			actual == 'id 1 name hello\nid 2 name world\n'
	}


	def cleanup() {
		FileUtils.cleanDirectory new File(pathToDB)
	}


	final static pathToDB = PropertyReader.read('/properties/test-db.properties', 'path') as String


	def h2Init() {
		ResultSet rs
		Connection conn
		Statement stmt

		def result = ''

		try {
			conn = DriverManager.getConnection "jdbc:h2:$pathToDB/${UUID.randomUUID()}", '', ''

			stmt = conn.createStatement()

			stmt.execute "create table user(id int primary key, name varchar(100))"
			stmt.execute "insert into user values(1, 'hello')"
			stmt.execute "insert into user values(2, 'world')"

			rs = stmt.executeQuery 'select * from user'

			while (rs.next())
				result += 'id ' + rs.getInt('id') + ' name ' + rs.getString('name') + '\n'
		}
		catch (Exception e) {
			e.printStackTrace()
		}
		finally {
			conn?.close()
			stmt?.close()
			rs?.close()
		}

		result
	}
}
