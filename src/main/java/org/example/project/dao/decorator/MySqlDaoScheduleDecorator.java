package org.example.project.dao.decorator;

import org.example.project.dao.MySqlDaoSchedule;
import org.example.project.entity.Schedule;
import org.example.project.error.ExceptionDAO;

import java.util.List;

public class MySqlDaoScheduleDecorator implements MySqlDaoSchedule {
    private MySqlDaoSchedule mySqlDaoSchedule;

    public MySqlDaoScheduleDecorator(MySqlDaoSchedule mySqlDaoSchedule) {
        this.mySqlDaoSchedule = mySqlDaoSchedule;
    }

    @Override
    public boolean save(Schedule schedule) throws ExceptionDAO {
        boolean aBoolean;
        try {
            aBoolean = mySqlDaoSchedule.save(schedule);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }
        return aBoolean;
    }

    @Override
    public Schedule get(Integer integer) throws ExceptionDAO {
        Schedule schedule;
        try {
            schedule = mySqlDaoSchedule.get(integer);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }
        return schedule;
    }

    @Override
    public void update(Schedule schedule) throws ExceptionDAO {
        try {
            mySqlDaoSchedule.update(schedule);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }
    }

    @Override
    public void delete(Schedule schedule) throws ExceptionDAO {
        try {
            mySqlDaoSchedule.delete(schedule);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }
    }

    @Override
    public List<Schedule> getAll(String month, String year) throws ExceptionDAO {
        List<Schedule> list;
        try {
            list = mySqlDaoSchedule.getAll(month, year);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }

        return list;
    }
}
