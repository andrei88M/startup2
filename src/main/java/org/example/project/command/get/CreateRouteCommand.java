package org.example.project.command.get;

import org.example.project.command.ICommand;
import org.example.project.entity.Route;
import org.example.project.error.ExceptionDAO;
import org.example.project.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateRouteCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String number = req.getParameter("number");
        String typeNumber = req.getParameter("typeNumber");
        String startTime = req.getParameter("startTime");
        String finishTime = req.getParameter("finishTime");
        String replacementTime = req.getParameter("replacementTime");

        Route route = new Route();
        route.setNumber(Integer.parseInt(number));
        route.setTypeNumber(Integer.parseInt(typeNumber));
        route.setStartTime(startTime);
        route.setFinishTime(finishTime);
        route.setReplacementTime(replacementTime);

        Service service = Service.getInstance();
        boolean aBoolean;
        try {
            aBoolean = service.getDaoRoute().save(route);
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }
        if (!aBoolean){
            req.setAttribute("message", "route " + number + " " + typeNumber + " not saving");
        }else {
            req.setAttribute("message", "route " + number + " " + typeNumber + " saving");
        }
        String uri = "/dispatcher/createRoute";
        return uri;
    }
}
