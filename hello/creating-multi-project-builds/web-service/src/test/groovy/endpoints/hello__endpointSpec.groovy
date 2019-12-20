package endpoints

import groovyx.net.http.*
import org.apache.commons.lang3.StringUtils
import spock.lang.*

class hello__endpointSpec extends Specification {

	@Unroll
	def '/hello endpoint test'() {
		given: 'rest client'
			final restClient = new RESTClient('http://localhost:8080/web-service/')

		when: 'calling endpoint'
			final response = restClient.get(path: 'hello', query: [name: name]) as HttpResponseDecorator
			final actual = (response.getData() as StringReader).text

		then: 'expecting correct result'
			StringUtils.containsIgnoreCase(actual, name)

		where:
			name << ['foo', 'bar', 'Banana']
	}
}
