package com.SportyShoes.web.repo;

import org.springframework.data.repository.CrudRepository;

import com.SportyShoes.web.entity.PurchasedShoes;

public interface PurchasedShoesRepo extends CrudRepository<PurchasedShoes, String> {

}
