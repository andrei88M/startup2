package org.example.project.dao.decorator;

import org.example.project.dao.MySqlDaoSalary;
import org.example.project.entity.Salary;
import org.example.project.error.ExceptionDAO;

import java.util.List;

public class MySqlDaoSalaryDecorator implements MySqlDaoSalary {
    private MySqlDaoSalary mySqlDaoSalary;

    public MySqlDaoSalaryDecorator(MySqlDaoSalary mySqlDaoSalary) {

        this.mySqlDaoSalary = mySqlDaoSalary;
    }

    @Override
    public void save(Salary salary) throws ExceptionDAO {
        try {
             mySqlDaoSalary.save(salary);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }
    }

    @Override
    public Salary get(Integer integer) throws ExceptionDAO {
        Salary salary;
        try {
            salary = mySqlDaoSalary.get(integer);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }

        return salary;
    }

    @Override
    public void update(Salary salary) throws ExceptionDAO {
        try {
            mySqlDaoSalary.update(salary);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }

    }

    @Override
    public void delete(Salary salary) throws ExceptionDAO {
        try {
            mySqlDaoSalary.delete(salary);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }

    }

    @Override
    public List<Salary> getByMonth(String month) throws ExceptionDAO {
        List<Salary> list;
        try {
            list = mySqlDaoSalary.getByMonth(month);
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }

        return list;
    }
}
