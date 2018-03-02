package org.sid.service;

import org.sid.entities.AppRole;
import org.sid.entities.AppUser;

public interface IAccountService {
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser( String userName, String roleName);
	public AppUser findUserByUserName(String userName);
}
