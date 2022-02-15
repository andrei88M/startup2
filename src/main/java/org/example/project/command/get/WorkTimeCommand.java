package org.example.project.command.get;

import org.example.project.command.ICommand;
import org.example.project.dao.MySqlDaoWorker;
import org.example.project.dao.MySqlDaoWorkerImp;
import org.example.project.entity.WorkTime;
import org.example.project.entity.Worker;
import org.example.project.error.ExceptionDAO;
import org.example.project.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

public class WorkTimeCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String personnelNumber = req.getParameter("personalNumber");
        Service service = Service.getInstance();
        Worker worker = null;
        try {
            worker = service.getDaoWorker().get(Integer.valueOf(personnelNumber));
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }
        Set<WorkTime> set = worker.getWorkTimeSet();
        req.setAttribute("times", set);
        String uri = "/accountant/salary";
        return uri;
    }
}
