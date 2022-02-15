package org.example.project.command.get;

import org.example.project.command.ICommand;
import org.example.project.entity.Schedule;
import org.example.project.error.ExceptionDAO;
import org.example.project.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SeeScheduleCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String month = req.getParameter("month");
        String year = req.getParameter("year");

        Service service = Service.getInstance();
        List<Schedule> list = null;
        try {
            list = service.getDaoSchedule().getAll(month,year);
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }
        req.setAttribute("schedule", list);
        return "/worker/mySchedule";
    }
}
