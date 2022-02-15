package org.example.project.dao;

import org.example.project.entity.Route;
import org.example.project.error.ExceptionDAO;
import org.example.project.util.JPA;

import javax.persistence.EntityManager;

public class MySqlDaoRouteImp implements MySqlDaoRoute {
    @Override
    public boolean save(Route route) {
        boolean aBoolean = false;
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();

        String SQL = "SELECT * FROM route " +
                "WHERE number = \'" + route.getNumber() + "\' " +
                "AND typeNumber =\'" + route.getTypeNumber() + "\'";
        int size = manager.createNativeQuery(SQL, Route.class).getResultList().size();
        if (size == 0) {
            aBoolean = true;
            manager.persist(route);
            manager.getTransaction().commit();
        } else {
            manager.getTransaction().rollback();
        }
        manager.close();
        return aBoolean;
    }

    @Override
    public Route get(Integer id) {
        Route route;
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        route = manager.find(Route.class, id);
        manager.getTransaction().commit();
        manager.close();
        return route;
    }

    @Override
    public Route getByNumberAndTypeNumber(int number, int typeNumber) {
        Route route = null;

        EntityManager manager = JPA.getEntityManager();
        final String SQL = "SELECT * FROM route " +
                "WHERE number = \'" + number + "\' " +
                "AND typeNumber = \'" + typeNumber + "\'";
        manager.getTransaction().begin();
        route = (Route) manager.createNativeQuery(SQL, Route.class).getSingleResult();
        manager.getTransaction().commit();
        manager.close();
        return route;
    }

    @Override
    public void update(Route route) {
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(route);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void delete(Route route) {
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        Route route1 = manager.find(Route.class, route.getId());
        manager.remove(route1);
        manager.getTransaction().commit();
        manager.close();

    }

    @Override
    public void deleteByNumberAndTypeNumber(int number, int typeNumber) {

        EntityManager manager = JPA.getEntityManager();
        final String SQL = "SELECT * FROM route " +
                "WHERE number = \'" + number + "\' " +
                "AND typeNumber = \'" + typeNumber + "\'";
        manager.getTransaction().begin();
        Route route1 = (Route) manager.createNativeQuery(SQL, Route.class).getSingleResult();
        manager.remove(route1);
        manager.getTransaction().commit();
        manager.close();
    }
}
