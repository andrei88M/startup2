package org.example.project.dao.decorator;

import org.example.project.dao.MySqlDaoAccount;
import org.example.project.entity.Account;
import org.example.project.error.ExceptionDAO;

public class MySqlDaoAccountDecorator implements MySqlDaoAccount {
    private MySqlDaoAccount mySqlDaoAccount;

    public MySqlDaoAccountDecorator(MySqlDaoAccount mySqlDaoAccount) {
        this.mySqlDaoAccount = mySqlDaoAccount;
    }


    @Override
    public boolean save(Account account) throws ExceptionDAO {
        boolean aBoolean;
        try {
            aBoolean = mySqlDaoAccount.save(account);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }
        return aBoolean;
    }

    @Override
    public Account get(Integer integer) throws ExceptionDAO {
        Account account;
        try {
            account = mySqlDaoAccount.get(integer);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }
        return account;
    }

    @Override
    public void update(Account account) throws ExceptionDAO {
        try {
            mySqlDaoAccount.update(account);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }
    }

    @Override
    public void delete(Account account) throws ExceptionDAO {
        try {
            mySqlDaoAccount.delete(account);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }
    }

    @Override
    public Account getByLogin(String login) throws ExceptionDAO {
        Account account;
        try {
            account = mySqlDaoAccount.getByLogin(login);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }
        return account;
    }

}
