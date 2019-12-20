package integration;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import root.config.*;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, FooServiceImp.class})
public class SimpleIntegrationTest {

	@Autowired ApplicationContext applicationContext;
	@Autowired FooService fooService;


	@Test
	public void autowiredTest() {
		assertNotNull(applicationContext);
		assertNotNull(fooService);
	}
}
