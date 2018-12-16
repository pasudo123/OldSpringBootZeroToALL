package com.doubler.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/add") // :: shortCut, RequestMapping(RequestMethod.GET)
	@ResponseBody
	public String addNewUser(@RequestParam String name, @RequestParam String email) {
		
		/**
		 * http://localhost:8080/user/add?name=First&email=someemail@someemailprovider.com
		 */
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		userRepository.save(user);
		
		return "Saved";
	}
	
	@GetMapping(value = "/all")
	@ResponseBody
	public Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}
}
