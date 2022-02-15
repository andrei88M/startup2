package org.example.project.dao;

import org.example.project.entity.Account;
import org.example.project.entity.Salary;
import org.example.project.error.ExceptionDAO;

import java.util.List;

public interface MySqlDaoSalary  {
    void save(Salary salary) throws ExceptionDAO;
    Salary get(Integer id) throws ExceptionDAO;
    void update(Salary salary) throws ExceptionDAO;
    void delete(Salary salary) throws ExceptionDAO;
    List<Salary> getByMonth(String month) throws ExceptionDAO;
}
