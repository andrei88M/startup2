package com.example.startup2.repository;

import com.example.startup2.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WorkerRepository extends CrudRepository<Worker, Long> {

    // Worker findByUsername(String username);
    Worker findByPersonnelNumber(String personnelNumber);



    Optional<Worker> findWorkerByUsername(String username);
}
