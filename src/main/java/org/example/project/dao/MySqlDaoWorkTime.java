package org.example.project.dao;

import org.example.project.entity.Account;
import org.example.project.entity.WorkTime;
import org.example.project.error.ExceptionDAO;

import java.util.List;

public interface MySqlDaoWorkTime  {
    boolean save(WorkTime workTime) throws ExceptionDAO;
    WorkTime get(Integer id) throws ExceptionDAO;
    void update(WorkTime workTime) throws ExceptionDAO;
    void delete(WorkTime workTime) throws ExceptionDAO;
    List<WorkTime> getTimes(String day, String month) throws ExceptionDAO;
}
