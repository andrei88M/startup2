package org.example.project.command.get;

import org.example.project.command.ICommand;
import org.example.project.dao.MySqlDaoRoute;
import org.example.project.dao.MySqlDaoRouteImp;
import org.example.project.entity.Route;
import org.example.project.error.ExceptionDAO;
import org.example.project.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteRouteCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String number = req.getParameter("number");
        String typeNumber = req.getParameter("typeNumber");

        Route route = new Route();
        route.setNumber(Integer.parseInt(number));
        route.setTypeNumber(Integer.parseInt(typeNumber));

        Service service = Service.getInstance();
        try {
            service.getDaoRoute().deleteByNumberAndTypeNumber(Integer.parseInt(number), Integer.parseInt(typeNumber));
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }

        String uri = "/dispatcher/deleteRoute";
        return uri;
    }
}
