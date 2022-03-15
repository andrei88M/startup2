package com.example.startup2.repository;

import com.example.startup2.model.Schedule;
import com.example.startup2.model.Worker;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {

    Set<Schedule> findSchedulesByWorker(Worker worker);
}
