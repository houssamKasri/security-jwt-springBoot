package org.sid.web;

import org.sid.entities.AppUser;
import org.sid.entities.UserForm;
import org.sid.service.AccountServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountRestController {
	@Autowired
	public AccountServiceImp accountService;
	
	@PostMapping(value = "/register")
	public AppUser saveUser(@RequestBody UserForm userForm){
		if(!userForm.getPassWord().equals(userForm.getConfirmedPassword()))
			throw new RuntimeException("you must to confirm your password!");
		AppUser user = accountService.findUserByUserName(userForm.getUserName());
		if(user!=null)
			throw new RuntimeException("user name already exist!");
		AppUser appUser = new AppUser();
		appUser.setUserName(userForm.getUserName());
		appUser.setPassWord(userForm.getPassWord());
		// 
		accountService.saveUser(appUser);
		accountService.addRoleToUser(appUser.getUserName(), "USER");
		return appUser;
	}
}
