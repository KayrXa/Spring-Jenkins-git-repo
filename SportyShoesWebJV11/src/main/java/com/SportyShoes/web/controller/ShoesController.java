package com.SportyShoes.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.SportyShoes.web.entity.Shoes;
import com.SportyShoes.web.service.ShoesService;



@Controller
public class ShoesController {
	
	@Autowired
	private ShoesService shoesService;
	
	public ShoesController() {
		System.out.println("shoes controller constructor");
	}
	
	@GetMapping("/shoes")
	public String listShoes(Model model) {
		System.out.println("Shoes page");
		
		List<Shoes> shoesList = shoesService.getShoesByStatus("active");
		model.addAttribute("shoesList", shoesList);
		
		return "shoes";
	}
	
	@GetMapping("/addShoes")
	public String addShoesGet() {
		return "addShoes";
	}
	
	@PostMapping("/addShoes")
	public String addShoesPost(HttpServletRequest request) {
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String sizeEU = request.getParameter("sizeEU");
		String genre = request.getParameter("genre");
		String type = request.getParameter("type");
		
		
		
		
		
		if (name==null || name.isBlank() || price.isBlank() || sizeEU.isBlank()) {
			return "redirect:addShoes";
		}
		
		Shoes s = new Shoes(name, Integer.parseInt(price), Integer.parseInt(sizeEU), genre, type,  "active");
		try {
			shoesService.insertShoes(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:shoes";
	}
	
	@GetMapping("/deleteShoes")
	public String deleteShoesGet(HttpServletRequest request) {
		String sid = request.getParameter("sid");
		System.out.println("Sid: "+sid);
		
		Shoes s = shoesService.getShoesById(sid);
		s.setStatus("archived");
		try {
			shoesService.updateShoes(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:shoes";
	}
	
	@GetMapping("/editShoes")
	public String editShoesGet(HttpServletRequest request, Model model) {
		String sid = request.getParameter("sid");
		
		Shoes s = shoesService.getShoesById(sid);
		model.addAttribute("shoes", s);
		
		return "editShoes";
	}
	
	@PostMapping("/editShoes")
	public String editShoesPost(HttpServletRequest request) {
		String sid = request.getParameter("sid");
		int price = Integer.parseInt(request.getParameter("price"));
		int size = Integer.parseInt(request.getParameter("sizeEU"));
		String type = request.getParameter("type");
		String genre = request.getParameter("genre");
		
		Shoes s = shoesService.getShoesById(sid);
		s.setPrice(price);
		s.setType(type);
		s.setGenre(genre);
		s.setSizeEU(size);
		
		try {
			shoesService.updateShoes(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:shoes";
	}

}