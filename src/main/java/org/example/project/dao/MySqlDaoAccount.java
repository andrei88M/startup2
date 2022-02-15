package org.example.project.dao;

import org.example.project.entity.Account;
import org.example.project.error.ExceptionDAO;

public interface MySqlDaoAccount {
    boolean save(Account account) throws ExceptionDAO;
    Account get(Integer id) throws ExceptionDAO;
    Account getByLogin(String login) throws ExceptionDAO;
    void update(Account account) throws ExceptionDAO;
    void delete(Account account) throws ExceptionDAO;
}
