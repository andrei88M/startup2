package org.example.project.dao;

import org.example.project.entity.Worker;
import org.example.project.error.ExceptionDAO;
import org.example.project.util.JPA;

import javax.persistence.EntityManager;

public class MySqlDaoWorkerImp implements MySqlDaoWorker {
    @Override
    public boolean save(Worker worker) {
        boolean aBoolean = false;

        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        String SQL = "SELECT * FROM worker " +
                "WHERE personnelNumber = \'" + worker.getPersonnelNumber() + "\'";
        if (manager.find(Worker.class, worker.getPersonnelNumber()) == null) {
            manager.persist(worker);
            aBoolean = true;
        }
        manager.getTransaction().commit();
        manager.close();
        return aBoolean;
    }

    @Override
    public Worker get(Integer personalNumber) throws ExceptionDAO {
        Worker worker;

        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        worker = manager.find(Worker.class, personalNumber);
        manager.getTransaction().commit();
        manager.close();

        return worker;
    }

    @Override
    public void update(Worker worker) throws ExceptionDAO {

        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(worker);
        manager.getTransaction().commit();
        manager.close();

    }

    @Override
    public void delete(Worker worker) throws ExceptionDAO {

        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        Worker worker1 = manager.find(Worker.class, worker.getPersonnelNumber());
        manager.remove(worker1);
        manager.getTransaction().commit();
        manager.close();

    }

    @Override
    public void delete(int personalNumber) throws ExceptionDAO {

        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        Worker worker1 = manager.find(Worker.class, personalNumber);
        manager.remove(worker1);
        manager.getTransaction().commit();
        manager.close();

    }
}
