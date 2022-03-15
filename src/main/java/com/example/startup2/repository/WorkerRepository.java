package com.example.startup2.repository;

import com.example.startup2.model.Worker;
import org.springframework.data.repository.CrudRepository;

public interface WorkerRepository extends CrudRepository<Worker, Integer> {
}
