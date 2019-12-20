package integration


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import root.config.*
import spock.lang.Specification


@ContextConfiguration(classes = [RootConfig, FooServiceImp])
class SimpleIntegrationSpec extends Specification {

	@Autowired ApplicationContext applicationContext
	@Autowired FooService fooService


	def 'autowired spec'() {
		expect:
			applicationContext != null
			fooService != null
	}
}
