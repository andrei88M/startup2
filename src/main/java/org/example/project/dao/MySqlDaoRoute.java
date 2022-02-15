package org.example.project.dao;

import org.example.project.entity.Account;
import org.example.project.entity.Route;
import org.example.project.error.ExceptionDAO;

public interface MySqlDaoRoute {
    boolean save(Route route) throws ExceptionDAO;

    Route get(Integer id) throws ExceptionDAO;

    void update(Route route) throws ExceptionDAO;

    void delete(Route route) throws ExceptionDAO;

    Route getByNumberAndTypeNumber(int number, int typeNumber) throws ExceptionDAO;

    void deleteByNumberAndTypeNumber(int number, int typeNumber) throws ExceptionDAO;
}
