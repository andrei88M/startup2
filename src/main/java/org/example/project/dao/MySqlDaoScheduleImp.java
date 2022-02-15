package org.example.project.dao;

import org.example.project.entity.Route;
import org.example.project.entity.Schedule;
import org.example.project.util.JPA;

import javax.persistence.EntityManager;
import java.util.List;

public class MySqlDaoScheduleImp implements MySqlDaoSchedule {
    @Override
    public boolean save(Schedule schedule) {
        boolean aBoolean = false;
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(schedule);
        manager.getTransaction().commit();
        manager.close();
        return aBoolean;
    }

    @Override
    public Schedule get(Integer id) {
        Schedule schedule;
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        schedule = manager.find(Schedule.class, id);
        manager.getTransaction().commit();
        return schedule;
    }

    @Override
    public List<Schedule> getAll(String month, String year) {
        List<Schedule> list;
        EntityManager manager = JPA.getEntityManager();
        final String SQL = "SELECT * FROM schedule " +
                "WHERE month = \'" + month + "\' " +
                "AND year = \'" + year + "\'";
        manager.getTransaction().begin();
        list = manager.createNativeQuery(SQL, Schedule.class).getResultList();
        manager.getTransaction().commit();
        manager.close();
        return list;
    }

    @Override
    public void update(Schedule schedule) {
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(schedule);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(Schedule schedule) {
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        Schedule schedule1 = manager.find(Schedule.class, schedule.getId());
        manager.remove(schedule1);
        manager.getTransaction().commit();
        manager.close();
    }
}
