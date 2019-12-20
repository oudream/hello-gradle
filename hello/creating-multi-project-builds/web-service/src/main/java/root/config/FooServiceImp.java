package root.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FooServiceImp implements FooService {

	public void doWork() {
		log.info("doing important work in injected service...");
	}


	private static final Logger log = LoggerFactory.getLogger(FooServiceImp.class);
}
