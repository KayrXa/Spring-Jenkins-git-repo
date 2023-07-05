package com.SportyShoes.web.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SportyShoes.web.entity.Shoes;

public interface ShoesRepo extends CrudRepository<Shoes, String>{
	
	public List<Shoes> findByStatus(String status);

}