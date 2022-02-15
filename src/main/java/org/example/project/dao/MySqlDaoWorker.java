package org.example.project.dao;

import org.example.project.entity.Account;
import org.example.project.entity.Worker;
import org.example.project.error.ExceptionDAO;

public interface MySqlDaoWorker {
    boolean save(Worker worker) throws ExceptionDAO;
    Worker get(Integer id) throws ExceptionDAO;
    void update(Worker worker) throws ExceptionDAO;
    void delete(Worker worker) throws ExceptionDAO;
    void delete(int personalNumber) throws ExceptionDAO;
}
