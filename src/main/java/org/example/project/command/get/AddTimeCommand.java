package org.example.project.command.get;

import org.example.project.command.ICommand;
import org.example.project.dao.MySqlDaoWorkTime;
import org.example.project.dao.MySqlDaoWorkTimeImp;
import org.example.project.entity.WorkTime;
import org.example.project.entity.Worker;
import org.example.project.error.ExceptionDAO;
import org.example.project.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddTimeCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String personalNumber = req.getParameter("number");
        String time = req.getParameter("time");
        String month = req.getParameter("month");
        String day = req.getParameter("day");

        WorkTime workTime = new WorkTime();
        workTime.setTime(Double.parseDouble(time));
        workTime.setMonth(month);
        workTime.setDay(Integer.parseInt(day));

        Service service = Service.getInstance();
        Worker worker = null;
        try {
            worker = service.getDaoWorker().get(Integer.parseInt(personalNumber));
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }

        workTime.setWorker(worker);

        try {
            service.getDaoWorkTime().update(workTime);
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }
        String uri = "/dispatcher/addTime";
        return uri;
    }
}
