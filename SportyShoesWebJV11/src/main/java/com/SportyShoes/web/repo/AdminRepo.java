package com.SportyShoes.web.repo;

import org.springframework.data.repository.CrudRepository;


import com.SportyShoes.web.entity.AdminLog;

public interface AdminRepo extends CrudRepository<AdminLog, String>{

}