package com.example.startup2.repository;

import com.example.startup2.model.Route;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RouteRepository extends CrudRepository<Route, Integer> {

    Optional<Route> findRouteByNumberAndTypeNumber(int number, String typeNumber);
}
