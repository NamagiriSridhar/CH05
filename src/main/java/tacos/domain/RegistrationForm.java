package tacos.domain;

import javax.persistence.OneToOne;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class RegistrationForm 
{	
	  private String username;
	  private String password;
	  private String fullname;
	  private String street;
	  private String city;
	  private String state;
	  private String zip;
	  private String phone;
	  
	  @OneToOne
	  private User user;
/*	  
	  public RegistrationForm( String username,String password,String fullname,String street,
			   String city,String state,String zip,String phone
			  )
	  {
		  this.username = username;
		  this.password = password;
		  this.fullname = fullname;
		  this.street = street;
		  this.city=city;
		  this.state=state;
		  this.zip=zip;
		  this.phone =phone;
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+username+" "+ id+ " "+password);

		  user = new User(
			       id, username, "");
			System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"+user.getUsername()+" "+ user.getId()+ " "+user.getPassword());

	  }
	 public User getUser(PasswordEncoder passwordEncoder) 
	 {	 
		user.setPassword(passwordEncoder.encode(password));
		System.out.println("ccccccccccccccccccccccccccccccccccccccccccc"+user.getUsername()+" "+ user.getId()+ " "+user.getPassword());

	    return user;
	 }
	  */
	  public User toUser(PasswordEncoder passwordEncoder)
	  {
		    return new User(
		        username, passwordEncoder.encode(password), 
		        fullname, street, city, state, zip, phone);
	  }
}