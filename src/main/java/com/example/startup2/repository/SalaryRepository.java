package com.example.startup2.repository;

import com.example.startup2.model.Salary;
import org.springframework.data.repository.CrudRepository;

public interface SalaryRepository extends CrudRepository<Salary, Long> {
}
