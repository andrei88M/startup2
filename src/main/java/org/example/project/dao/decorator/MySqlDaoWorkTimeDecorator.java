package org.example.project.dao.decorator;

import org.example.project.dao.MySqlDaoWorkTime;
import org.example.project.entity.WorkTime;
import org.example.project.error.ExceptionDAO;

import java.util.List;

public class MySqlDaoWorkTimeDecorator implements MySqlDaoWorkTime {
    private MySqlDaoWorkTime mySqlDaoWorkTime;

    public MySqlDaoWorkTimeDecorator(MySqlDaoWorkTime mySqlDaoWorkTime) {
        this.mySqlDaoWorkTime = mySqlDaoWorkTime;
    }

    @Override
    public boolean save(WorkTime workTime) throws ExceptionDAO {
        boolean aBoolean;
        try {
            aBoolean = mySqlDaoWorkTime.save(workTime);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }
        return aBoolean;
    }

    @Override
    public WorkTime get(Integer integer) throws ExceptionDAO {
        WorkTime workTime;
        try {
            workTime = mySqlDaoWorkTime.get(integer);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }

        return workTime;
    }

    @Override
    public void update(WorkTime workTime) throws ExceptionDAO {
        try {
            mySqlDaoWorkTime.update(workTime);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }

    }

    @Override
    public void delete(WorkTime workTime) throws ExceptionDAO {
        try {
            mySqlDaoWorkTime.delete(workTime);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }

    }

    @Override
    public List<WorkTime> getTimes(String day, String month) throws ExceptionDAO {
        List<WorkTime> list;
        try {
            list = mySqlDaoWorkTime.getTimes(day, month);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }
        return list;
    }
}
