package tacos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.domain.RegistrationForm;
import tacos.domain.User;
import tacos.repository.UserRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController
{
	
	private UserRepository userRepo;
	  private PasswordEncoder passwordEncoder;
	
	@Autowired
	public RegistrationController(UserRepository userRepo,
			PasswordEncoder passwordEncoder)
	{
		this.userRepo=userRepo;
		this.passwordEncoder=passwordEncoder;
	}
	@GetMapping
	public String registerForm()
	{
		return "registration";
	}
	@PostMapping
	public String processRegistration(RegistrationForm form)
	{
		User user = form.toUser(passwordEncoder);

		//System.out.println("before************************************"+user.getUsername()+" "+ user.getId()+ " "+user.getPassword());
		userRepo.save(user);
	//	System.out.println("after ************************************"+user.getUsername()+" "+ user.getId()+ " "+user.getPassword());
		//ids only generated when saved to repo
		return "redirect:/login";
	}
}
