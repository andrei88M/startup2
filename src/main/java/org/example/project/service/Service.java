package org.example.project.service;

import org.example.project.dao.*;
import org.example.project.dao.decorator.*;

public class Service {
    private static Service instance;
    private final MySqlDaoWorker daoWorker;
    private final MySqlDaoWorkTime daoWorkTime;
    private final MySqlDaoSchedule daoSchedule;
    private final MySqlDaoSalary daoSalary;
    private final MySqlDaoMessage daoMessage;
    private final MySqlDaoRoute daoRoute;
    private final MySqlDaoAccount daoAccount;

    {
        daoWorker = new MySqlDaoWorkerDecorator(new MySqlDaoWorkerImp());
        daoWorkTime = new MySqlDaoWorkTimeDecorator(new MySqlDaoWorkTimeImp());
        daoSchedule = new MySqlDaoScheduleDecorator(new MySqlDaoScheduleImp());
        daoSalary = new MySqlDaoSalaryDecorator(new MySqlDaoSalaryImp());
        daoMessage = new MySqlDaoMessageDecorator(new MySqlDaoMessageImp());
        daoRoute = new MySqlDaoRouteDecorator(new MySqlDaoRouteImp());
        daoAccount = new MySqlDaoAccountDecorator(new MySqlDaoAccountIpl());
    }

    private Service() {
    }

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    public MySqlDaoRoute getDaoRoute(){
        return daoRoute;
    }

    public MySqlDaoAccount getDaoAccount(){
        return daoAccount;
    }

    public MySqlDaoMessage getDaoMessage(){
        return daoMessage;
    }

    public MySqlDaoSchedule getDaoSchedule(){
        return daoSchedule;
    }

    public MySqlDaoWorker getDaoWorker(){
        return daoWorker;
    }

    public MySqlDaoWorkTime getDaoWorkTime(){
        return daoWorkTime;
    }

    public MySqlDaoSalary getDaoSalary(){
        return daoSalary;
    }

}
