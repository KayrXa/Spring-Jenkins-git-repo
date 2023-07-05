package com.SportyShoes.web.service;


import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SportyShoes.web.entity.AdminLog;
import com.SportyShoes.web.repo.AdminRepo;



@Service
public class AdminLogService {
	
	@Autowired
	private AdminRepo adminRepo;
	
	public AdminLog getAdminLoginByUsername(String username) {
		return adminRepo.findById(username)
				.orElseThrow(()-> new EntityNotFoundException(username+" not found"));
	}
	
	public AdminLog updateAdminLogin(AdminLog adminLog) {
		return this.adminRepo.save(adminLog);
	}
	
	public String changePassword(String old, String new1, String new2) {
		String oldDB = getAdminLoginByUsername("admin").getPassword();
		if(old.isBlank() || new1.isBlank() || new2.isBlank())
			return "No box should stay empty.";
		if(!new1.equals(new2))
			return "New passwords are not the same.";
		if(!old.equals(oldDB))
			return "Old password is incorrect.";
		else {
			updateAdminLogin(new AdminLog("admin", new1));
			return "Password changed successfully.";
		}
	}
}
