package com.agus.springboot.model.dao;

import com.agus.springboot.model.entities.DeptEntity;
import org.springframework.data.repository.CrudRepository;

public interface IDeptDAO extends CrudRepository<DeptEntity, Integer> {
}
