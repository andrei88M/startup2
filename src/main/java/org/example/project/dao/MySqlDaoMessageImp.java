package org.example.project.dao;

import org.example.project.entity.Account;
import org.example.project.entity.Message;
import org.example.project.error.ExceptionDAO;
import org.example.project.util.JPA;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class MySqlDaoMessageImp implements MySqlDaoMessage {
    @Override
    public void write(String text, Account sender, Account recipient) {

        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        Message message = new Message();
        message.setText(text);
        message.setDateTime(LocalDateTime.now());
        message.setSenderMessage(sender);
        message.setRecipientMessages(recipient);
        manager.merge(message);
        manager.getTransaction().commit();
        manager.close();

    }

    @Override
    public List<Message> read(int from, int to) {
        List<Message> list;

        String sql = "SELECT * FROM message WHERE recipientMessages_worker_personnelNumber = \'" + to + "\'" +
                "AND senderMessage_worker_personnelNumber = \'" + from + "\'";
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        list = manager.createNativeQuery(sql, Message.class).getResultList();
        manager.getTransaction().commit();
        manager.close();

        return list;
    }
}
