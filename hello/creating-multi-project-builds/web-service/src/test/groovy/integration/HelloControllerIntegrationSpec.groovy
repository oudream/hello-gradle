package integration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import root.HelloController
import root.config.FooServiceImp
import spock.lang.Specification


@ContextConfiguration(classes = [HelloController, FooServiceImp])
class HelloControllerIntegrationSpec extends Specification {

	@Autowired HelloController controller
	MockMvc mvc


	def setup() {
		mvc = MockMvcBuilders.standaloneSetup(controller).build()
	}


	def 'HelloController spec'() {
		given: 'greeting'
			final greeting = "Greeting_${UUID.randomUUID()}"

		when: 'performing GET /hello?greeting'
			final builder = MockMvcRequestBuilders.get '/hello' param 'name', greeting
			final response = mvc.perform builder andReturn() response

		then: 'got some response'
			response != null

		and: 'content is correct'
			final content = response.contentAsString

			content != null
			content.contains greeting
	}
}
