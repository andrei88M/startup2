package org.example.project.command.post;

import org.example.project.command.ICommand;
import org.example.project.dao.MySqlDaoSalary;
import org.example.project.dao.MySqlDaoSalaryImp;
import org.example.project.dao.MySqlDaoWorker;
import org.example.project.dao.MySqlDaoWorkerImp;
import org.example.project.entity.Salary;
import org.example.project.entity.Worker;
import org.example.project.error.ExceptionDAO;
import org.example.project.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SalaryCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String personelNumber = req.getParameter("personalNumber");
        String times = req.getParameter("hour");
        String money = req.getParameter("money");

        Service service = Service.getInstance();
        Worker worker = null;
        try {
            worker = service.getDaoWorker().get(Integer.valueOf(personelNumber));
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }
        Salary salary = new Salary();
        salary.setAllTime(Double.parseDouble(times));
        salary.setMoney(Double.parseDouble(money));
        salary.setWorker(worker);
        try {
            service.getDaoSalary().save(salary);
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }

        String uri = "/accountant/salary";
        return uri;
    }
}
