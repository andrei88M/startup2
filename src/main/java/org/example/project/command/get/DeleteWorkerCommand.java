package org.example.project.command.get;

import org.example.project.command.ICommand;
import org.example.project.dao.MySqlDaoWorker;
import org.example.project.dao.MySqlDaoWorkerImp;
import org.example.project.error.ExceptionDAO;
import org.example.project.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteWorkerCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String personalNumber = req.getParameter("personnelNumber");
        Service service = Service.getInstance();
        try {
            service.getDaoWorker().delete(Integer.parseInt(personalNumber));
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }

        String uri = "/hrd/deleteWorker";
        return uri;
    }
}
