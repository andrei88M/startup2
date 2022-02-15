package org.example.project.dao;

import org.example.project.entity.Account;
import org.example.project.entity.Message;
import org.example.project.error.ExceptionDAO;

import java.util.List;

public interface MySqlDaoMessage {
    void write(String text, Account sender, Account recipient) throws ExceptionDAO;

    List<Message> read(int from, int to) throws ExceptionDAO;
}
