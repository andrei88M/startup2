package com.example.startup2.repository;

import com.example.startup2.model.Salary;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SalaryRepository extends CrudRepository<Salary, Integer> {
}
