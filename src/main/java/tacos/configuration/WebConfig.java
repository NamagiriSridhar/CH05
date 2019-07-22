package tacos.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	  @Override
	  public void addViewControllers(ViewControllerRegistry registry) 
	  {
		  registry.addViewController("/").setViewName("home"); //for tests to run
		  registry.addViewController("/abc").setViewName("home"); // for tests to run // comment third row
		   // registry.addViewController("/").setViewName("login"); //If we dont want to see log out button when we load the appln

		  registry.addViewController("/login");//it can figure out view name from the path
		  //login controller get mapping works not post mapping - no error but it never goes to that code!!!
	  }
}