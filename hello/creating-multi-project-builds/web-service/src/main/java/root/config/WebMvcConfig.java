package root.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "root")
public class WebMvcConfig implements WebMvcConfigurer {
}
