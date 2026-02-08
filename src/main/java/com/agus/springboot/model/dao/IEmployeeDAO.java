package com.agus.springboot.model.dao;

import com.agus.springboot.model.entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeDAO extends CrudRepository<EmployeeEntity, Integer> {
}
