package org.example.project.dao.decorator;

import org.example.project.dao.MySqlDaoWorker;
import org.example.project.entity.Worker;
import org.example.project.error.ExceptionDAO;

public class MySqlDaoWorkerDecorator implements MySqlDaoWorker {
    private MySqlDaoWorker mySqlDaoWorker;

    public MySqlDaoWorkerDecorator(MySqlDaoWorker mySqlDaoWorker) {
        this.mySqlDaoWorker = mySqlDaoWorker;
    }

    @Override
    public boolean save(Worker worker) throws ExceptionDAO {
        boolean aBoolean;
        try {
            aBoolean = mySqlDaoWorker.save(worker);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }
        return aBoolean;
    }

    @Override
    public Worker get(Integer integer) throws ExceptionDAO {
        Worker worker;
        try {
            worker = mySqlDaoWorker.get(integer);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }
        return worker;
    }

    @Override
    public void update(Worker worker) throws ExceptionDAO {
        try {
            mySqlDaoWorker.update(worker);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }

    }

    @Override
    public void delete(Worker worker) throws ExceptionDAO {
        try {
            mySqlDaoWorker.delete(worker);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }

    }

    @Override
    public void delete(int personalNumber) throws ExceptionDAO {
        try {
            mySqlDaoWorker.delete(personalNumber);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }

    }
}
