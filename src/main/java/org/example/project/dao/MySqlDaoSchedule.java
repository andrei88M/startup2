package org.example.project.dao;

import org.example.project.entity.Account;
import org.example.project.entity.Schedule;
import org.example.project.error.ExceptionDAO;

import java.util.List;

public interface MySqlDaoSchedule  {
    boolean save(Schedule schedule) throws ExceptionDAO;
    Schedule get(Integer id) throws ExceptionDAO;
    void update(Schedule schedule) throws ExceptionDAO;
    void delete(Schedule schedule) throws ExceptionDAO;
    List<Schedule> getAll(String month, String year) throws ExceptionDAO;

}
