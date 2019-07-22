package tacos.configuration;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Component
@ConfigurationProperties(prefix="taco.orders")
@Data
@Validated
public class OrderProps
{
	@Min(value=3,message="must be between 3 and 5")
	@Max(value=5,message="must be between 3 and 5")
	private int pageSize=20;

}
