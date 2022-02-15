package org.example.project.dao;

import org.example.project.entity.Schedule;
import org.example.project.entity.WorkTime;
import org.example.project.util.JPA;

import javax.persistence.EntityManager;
import java.util.List;

public class MySqlDaoWorkTimeImp implements MySqlDaoWorkTime {
    @Override
    public boolean save(WorkTime workTime) {
        boolean aBoolean = false;
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        if (manager.contains(workTime)) {
            manager.persist(workTime);
            aBoolean = true;
        }
        manager.getTransaction().commit();
        manager.close();
        return aBoolean;
    }

    @Override
    public WorkTime get(Integer id) {
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        WorkTime workTime = manager.find(WorkTime.class, id);
        manager.getTransaction().commit();
        manager.close();
        return workTime;
    }

    @Override
    public List<WorkTime> getTimes(String day, String month) {
        List<WorkTime> list;
        String SQL = "SELECT * FROM worktime " +
                "WHERE month = \'" + month + "\' " +
                "AND day = \'" + day + "\'";

        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        list = manager.createNativeQuery(SQL, WorkTime.class).getResultList();
        manager.getTransaction().commit();
        manager.close();
        return list;
    }

    @Override
    public void update(WorkTime workTime) {
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(workTime);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void delete(WorkTime workTime) {

    }
}
