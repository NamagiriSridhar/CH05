package tacos.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private UserDetailsService userDetailsService;	
	
	@Bean
	  public PasswordEncoder encoder() {
	    return new StandardPasswordEncoder("53cr3t");//have tried successfully with BCryptPasswordEncoder which is not deprecated
	  }
	  
	 @Override
	  protected void configure(AuthenticationManagerBuilder auth)
	      throws Exception {

	    auth
	      .userDetailsService(userDetailsService)
	      .passwordEncoder(encoder());
	    
	  }
	 @Override
	  protected void configure(HttpSecurity http) throws Exception {
//
//		 http.authorizeRequests().antMatchers("/console/**").permitAll().antMatchers("/login").permitAll()
//			.antMatchers("/register").permitAll().antMatchers("/styles.css")
//			.permitAll().antMatchers().hasAuthority("ROLE_USER").anyRequest().authenticated().and().csrf().disable()
//			.formLogin().loginPage("/login").failureUrl("/login?error=true").defaultSuccessUrl("/design")
//			.usernameParameter("username").passwordParameter("password").and().logout()
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").and()
//			.exceptionHandling();
//
//	http.headers().frameOptions().disable(); 
		 //below stopped working
	    http
	      .authorizeRequests()
	        .antMatchers("/design", "/orders")
	  
	          .access("hasRole('ROLE_USER')") //does not work as "USER"
	        //.hasAuthority("ROLE_USER") //works as USER or ROLE_USER Or  must match with User class. If above does not work try this
	        .antMatchers("/", "/**").access("permitAll")
	        
	      .and()
	        .formLogin()
	          .loginPage("/login")
	        //  .loginProcessingUrl("/login") redundant
	          .defaultSuccessUrl("/design")
	      .and()
	        .logout()
	        	//.logoutSuccessUrl("/")//i think not required
	      .and()
	        .csrf()
	          .ignoringAntMatchers("/console/**")
	      .and()  
	        .headers()
	          .frameOptions()
	            .sameOrigin()
	      ;
	  }
//	 @Override
//		public void configure(WebSecurity web) throws Exception {
//			web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
//		}
//


}
