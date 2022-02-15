package org.example.project.command.get;

import org.example.project.command.ICommand;
import org.example.project.dao.MySqlDaoWorkTime;
import org.example.project.dao.MySqlDaoWorkTimeImp;
import org.example.project.entity.WorkTime;
import org.example.project.error.ExceptionDAO;
import org.example.project.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SeeWorkTimeCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String day = req.getParameter("day");
        String month = req.getParameter("month");

        Service service = Service.getInstance();
        List<WorkTime> list = null;
        try {
            list = service.getDaoWorkTime().getTimes(day, month);
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }
        req.setAttribute("list", list);
        return "/worker/see";
    }
}
