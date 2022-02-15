package org.example.project.command.post;

import org.example.project.command.ICommand;
import org.example.project.entity.Worker;
import org.example.project.error.ExceptionDAO;
import org.example.project.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateWorkerCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String personNumb = req.getParameter("personnelNumber");
        String telephone = req.getParameter("telephone");
        String role = req.getParameter("role");

        Worker worker = new Worker();
        worker.setName(name);
        worker.setSurname(surname);
        worker.setPersonnelNumber(Integer.parseInt(personNumb));
        worker.setRole(role);
        worker.setTelephoneNumber(telephone);

        Service service = Service.getInstance();
        try {
            service.getDaoWorker().save(worker);
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }
        String uri = "/hrd/createWorker";
        return uri;
    }
}
