package com.SportyShoes.web.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SportyShoes.web.dto.UserDTO;

public interface UserDTORepo extends CrudRepository<UserDTO, String>{
	
	public UserDTO findByEmail(String email);
	
	public List<UserDTO> findByLname(String lname);

}
