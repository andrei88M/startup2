package org.example.project.command.post;

import org.example.project.command.ICommand;
import org.example.project.entity.Salary;
import org.example.project.error.ExceptionDAO;
import org.example.project.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SeeMoneyCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String month = req.getParameter("month");
        Service service = Service.getInstance();
        List<Salary> list = null;
        try {
            list = service.getDaoSalary().getByMonth(month);
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }
        req.setAttribute("money", list);
        return "/worker/see";
    }
}
