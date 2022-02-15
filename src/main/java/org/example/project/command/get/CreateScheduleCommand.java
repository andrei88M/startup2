package org.example.project.command.get;

import org.example.project.command.ICommand;
import org.example.project.dao.*;
import org.example.project.entity.Route;
import org.example.project.entity.Schedule;
import org.example.project.entity.Worker;
import org.example.project.error.ExceptionDAO;
import org.example.project.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateScheduleCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String day = req.getParameter("day");
        String month = req.getParameter("month");
        String year = req.getParameter("year");
        String personnelNumber = req.getParameter("personnelNumber");
        String route = req.getParameter("route");
        String type = req.getParameter("type");
        String replacement = req.getParameter("replacement");

        Service service = Service.getInstance();
        Worker worker = null;
        Route route1 = null;
        try {
            worker = service.getDaoWorker().get(Integer.valueOf(personnelNumber));
            route1 = service.getDaoRoute().getByNumberAndTypeNumber(Integer.parseInt(route), Integer.parseInt(type));
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }


        Schedule schedule = new Schedule();
        schedule.setDay(Integer.parseInt(day));
        schedule.setMonth(month);
        schedule.setYear(Integer.parseInt(year));
        schedule.setReplacement(Integer.parseInt(replacement));
        schedule.setWorker(worker);
        schedule.setRoute(route1);


        try {
            service.getDaoSchedule().update(schedule);
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }
        String uri = "/dispatcher/createSchedule";

        return uri;
    }
}
