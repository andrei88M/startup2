package org.example.project.dao.decorator;

import org.example.project.dao.MySqlDaoRoute;
import org.example.project.entity.Route;
import org.example.project.error.ExceptionDAO;

public class MySqlDaoRouteDecorator implements MySqlDaoRoute {
    private MySqlDaoRoute mySqlDaoRoute;

    public MySqlDaoRouteDecorator(MySqlDaoRoute mySqlDaoRoute) {
        this.mySqlDaoRoute = mySqlDaoRoute;
    }

    @Override
    public boolean save(Route route) throws ExceptionDAO {
        boolean aBoolean;
        try {
            aBoolean = mySqlDaoRoute.save(route);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }
        return aBoolean;
    }

    @Override
    public Route get(Integer integer) throws ExceptionDAO {
        Route route;
        try {
            route = mySqlDaoRoute.get(integer);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }

        return route;
    }

    @Override
    public void update(Route route) throws ExceptionDAO {
        try {
            mySqlDaoRoute.update(route);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }

    }

    @Override
    public void delete(Route route) throws ExceptionDAO {
        try {
            mySqlDaoRoute.delete(route);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }

    }

    @Override
    public Route getByNumberAndTypeNumber(int number, int typeNumber) throws ExceptionDAO {
        Route route;
        try {
            route = mySqlDaoRoute.getByNumberAndTypeNumber(number, typeNumber);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }

        return route;
    }

    @Override
    public void deleteByNumberAndTypeNumber(int number, int typeNumber) throws ExceptionDAO {
        try {
            mySqlDaoRoute.deleteByNumberAndTypeNumber(number, typeNumber);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }
    }
}
