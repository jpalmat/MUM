package edu.mum.main;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");

		UserService userService = (UserService) ctx.getBean("userServiceImpl");
		
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setEmail("jdoe@mum.edu");
		user.setAdmin(true);
		user.setLastLogin(new Date());
		userService.save(user);
		System.out.println("==========> User Created Successfully");
		
		System.out.println("==========> Loading User");
		User loadedUser = userService.findByEmail("jdoe@mum.edu");
		System.out.println("==========>User Name :"+loadedUser.getFirstName()+" "+loadedUser.getLastName());
		
		System.out.println("==========> Merging user");
		user.setEmail("jdoe@mum.edu");
		userService.merge(user);
		System.out.println("==========> user email updated to jdoe .... Let's try update it one more time");
		user.setEmail("error@mum.edu");
		try {
			userService.merge(user);
		} catch (Exception e) {
			System.out.println("======>You are trying to update object unmanaged version");
		}
		
		
	}

}