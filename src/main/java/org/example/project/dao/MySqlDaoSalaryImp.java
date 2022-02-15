package org.example.project.dao;

import org.example.project.entity.Salary;
import org.example.project.entity.Schedule;
import org.example.project.error.ExceptionDAO;
import org.example.project.util.JPA;

import javax.persistence.EntityManager;
import java.util.List;

public class MySqlDaoSalaryImp implements MySqlDaoSalary {
    @Override
    public void save(Salary salary) {

        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(salary);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public Salary get(Integer integer) {
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        Salary salary = manager.find(Salary.class, integer);
        manager.getTransaction().commit();
        manager.close();
        return salary;
    }

    @Override
    public List<Salary> getByMonth(String month) {
        List<Salary> list;
        EntityManager manager = JPA.getEntityManager();
        final String SQL = "SELECT * FROM salary " +
                "WHERE month = \'" + month + "\'";
        manager.getTransaction().begin();
        list = manager.createNativeQuery(SQL, Salary.class).getResultList();
        manager.getTransaction().commit();
        manager.close();
        return list;
    }

    @Override
    public void update(Salary salary) {
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(salary);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void delete(Salary salary) {
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        Salary salary1 = manager.find(Salary.class, salary.getId());
        manager.remove(salary1);
        manager.getTransaction().commit();
        manager.close();
    }
}
