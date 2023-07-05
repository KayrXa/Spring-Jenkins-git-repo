package com.SportyShoes.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SportyShoes.web.entity.Shoes;
import com.SportyShoes.web.repo.ShoesRepo;


@Service
public class ShoesService {
	
	@Autowired
	private ShoesRepo shoesRepo;
	
	public List<Shoes> getAllShoes() {
		List<Shoes> shoes = new ArrayList<>();
		this.shoesRepo.findAll().forEach(shoe -> {
			Shoes s = new Shoes();
			s.setSid(shoe.getSid());
			s.setName(shoe.getName());
			s.setPrice(shoe.getPrice());
			s.setSizeEU(shoe.getSizeEU());
			s.setGenre(shoe.getGenre());
			s.setType(shoe.getType());
			
			
			shoes.add(s);
		});
		return shoes;
	}

	public Shoes insertShoes(Shoes s) throws Exception {
		return this.shoesRepo.save(s);
	}
	
	public Shoes updateShoes(Shoes s) throws Exception {
		return this.shoesRepo.save(s);
	}
	
	public void deleteShoesById(String sid) throws Exception {
		this.shoesRepo.deleteById(sid);
	}
	
	public Shoes getShoesById(String sid) {
		return this.shoesRepo.findById(sid).orElseThrow(()-> new EntityNotFoundException(sid+ " does not exist"));
	}
	
	public List<Shoes> getShoesByStatus(String status){
		return this.shoesRepo.findByStatus(status);
	}

}