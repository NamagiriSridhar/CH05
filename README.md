# CH05

spring.profiles.active=dev in appln.properties or yml didnt work for me

you have to create a run configuration named dev profile . select project and main class and add environment variable spring.profiles.active dev and run that .works beautifully.Thanks to this video
https://www.youtube.com/watch?v=Op4SRM3t0nw 


??Why do we need more than one active profile???

mvn package in git bash in project folder to generate jar file

Binding to target org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'taco.orders' to tacos.configuration.OrderProps failed:

    Property: taco.orders.pageSize
    Value: 2
    Origin: class path resource [application.yml]:3:15
    Reason: must be between 3 and 5


Action:

Update your application's configuration



after setting environment variable restart eclipse

even if the same variable was set in application.yml , system variable takes precedence. But if system variable were changed it didnt just work .

remember to restart computer or eclipse if code stops working instead of trying to fix it!!!!!

# show sql queries in console - love this
spring.jpa.show-sql = true


to make https work gotta restart eclipse after adding the changes
logging.file=C:/Users/namag/Desktop/todo.log worked
logging.path did not work


package todos.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeResource 
{
	@Value("${welcoming.message}")
	private String welcomeMessage;

	@GetMapping("/welcome")
	public String retrieveWelcomeMessage() {
		// Complex Method
		return welcomeMessage;
	}
}


welcoming:
  message: ${spring.application.name}
spring:
  application:
    name: hello


or 

welcoming.message=hello

