package org.example.project.dao;

import org.example.project.entity.Account;
import org.example.project.entity.Route;
import org.example.project.error.ExceptionDAO;
import org.example.project.util.JPA;

import javax.persistence.EntityManager;
import java.util.List;

public class MySqlDaoAccountIpl implements MySqlDaoAccount {
    @Override
    public boolean save(Account account) {
        boolean aBoolean = false;
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        Account account1 = manager.find(Account.class, account.getId());
        if (account1 == null){
            manager.persist(account);
            aBoolean = true;
            manager.getTransaction().commit();
        }else {
            aBoolean = false;
            manager.getTransaction().rollback();
        }
        manager.close();

        return aBoolean;
    }

    @Override
    public Account get(Integer id) {
        Account account;
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        account = manager.find(Account.class, id);
        manager.getTransaction().commit();
        manager.close();

        return account;
    }

    @Override
    public Account getByLogin(String login) {
        Account account = null;
        String SQL = "SELECT * FROM account WHERE login = \'" + login + "\'";
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        List<Account> list = manager.createNativeQuery(SQL, Account.class).getResultList();
        if (list.size() == 0) {
            manager.getTransaction().rollback();
        } else {
            account = (Account) manager.createNativeQuery(SQL, Account.class).getSingleResult();
            manager.getTransaction().commit();
        }
        manager.close();

        return account;
    }

    @Override
    public void update(Account account) {
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(account);
        manager.getTransaction().commit();
        manager.close();

    }

    @Override
    public void delete(Account account) {
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        Account account1 = manager.find(Account.class, account.getId());
        manager.remove(account1);
        manager.getTransaction().commit();
        manager.close();

    }
}
