package org.sid;

import java.util.stream.Stream;

import org.sid.dao.ITaskRepository;
import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.sid.entities.Task;
import org.sid.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JwtSecurityApplication implements CommandLineRunner {
	
	@Autowired
	public ITaskRepository taskRepo;
	@Autowired
	public IAccountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(JwtSecurityApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPE(){
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void run(String... arg0) throws Exception {

		accountService.saveUser(new AppUser(null, "admin", "123", null));
		accountService.saveUser(new AppUser(null, "user", "123", null));
		accountService.saveRole(new AppRole(null, "ADMIN"));
		accountService.saveRole(new AppRole(null, "USER"));

		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("user", "User");

		
		Stream.of("T1","T2","T3").forEach(t->{
			taskRepo.save(new Task(null, t));
		});
		
		taskRepo.findAll().forEach( task ->{
			System.out.println(task.getTaskName());
		});
	}
}
