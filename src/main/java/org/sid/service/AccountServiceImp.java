package org.sid.service;

import javax.transaction.Transactional;

import org.sid.dao.IAppRoleRepository;
import org.sid.dao.IAppUserRepository;
import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountServiceImp implements IAccountService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public IAppUserRepository userRepo;
	
	@Autowired
	public IAppRoleRepository roleRepo;
	
	@Override
	public AppUser saveUser(AppUser user) {
		String hashPW = bCryptPasswordEncoder.encode(user.getPassWord());
		user.setPassWord(hashPW);
		return userRepo.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String userName, String roleName) {
		AppRole role = roleRepo.findByRoleName(roleName);
		AppUser user = userRepo.findByUserName(userName);
		user.getRoles().add(role);
	}

	@Override
	public AppUser findUserByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}

}
