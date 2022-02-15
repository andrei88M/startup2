package org.example.project.dao.decorator;

import org.example.project.dao.MySqlDaoMessage;
import org.example.project.entity.Account;
import org.example.project.entity.Message;
import org.example.project.error.ExceptionDAO;

import java.util.List;

public class MySqlDaoMessageDecorator implements MySqlDaoMessage {
    private MySqlDaoMessage mySqlDaoMessage;

    public MySqlDaoMessageDecorator(MySqlDaoMessage mySqlDaoMessage) {
        this.mySqlDaoMessage = mySqlDaoMessage;
    }

    @Override
    public void write(String text, Account sender, Account recipient) throws ExceptionDAO {
        try {
            mySqlDaoMessage.write(text, sender, recipient);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }

    }

    @Override
    public List<Message> read(int from, int to) throws ExceptionDAO {
        List<Message> list;
        try {
            list = mySqlDaoMessage.read(from, to);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }

        return list;
    }
}
