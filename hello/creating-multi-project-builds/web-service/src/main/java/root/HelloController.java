package root;

import greeter.GreetingFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import root.config.FooService;


@RestController
public class HelloController {

	@GetMapping("/hello")
	public String greet(@RequestParam(defaultValue = "World", name = "name") String name) {
		service.doWork();
		return GreetingFormatter.greeting(name);
	}


	@Autowired
	public HelloController(FooService service) {this.service = service;}


	private final FooService service;
}
