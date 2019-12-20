package integration;

import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import root.HelloController;
import root.config.FooServiceImp;

import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HelloController.class, FooServiceImp.class})
public class HelloControllerIntegrationTest {

	@Autowired HelloController controller;
	private MockMvc mvc;


	@Before public void beforeClass() {
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}


	@Test public void helloControllerTest() throws Exception {
		// given: greeting
		String greeting = "Greeting_" + UUID.randomUUID().toString();

		// when: performing GET /hello?greeting
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/hello").param("name", greeting);
		MockHttpServletResponse response = mvc.perform(builder).andReturn().getResponse();

		// then: got some response
		assertNotNull(response);

		// and: content is correct
		String content = response.getContentAsString();

		assertNotNull(content);
		assertThat(content, CoreMatchers.containsString(greeting));
	}
}
