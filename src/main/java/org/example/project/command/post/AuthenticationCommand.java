package org.example.project.command.post;

import org.example.project.command.ICommand;
import org.example.project.entity.Account;
import org.example.project.error.ExceptionDAO;
import org.example.project.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String URI = "";
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Service service = Service.getInstance();
        Account account = null;
        try {
            account = service.getDaoAccount().getByLogin(login);
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }
        if (account != null && account.getLogin().equals(password)) {
            String role = account.getWorker().getRole();
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            session.setAttribute("password", password);
            session.setAttribute("role", role);
            session.setAttribute("id", account.getId());
            if (role.equals("worker")) {
                URI = "/worker";
            } else if (role.equals("hrd")) {
                URI = "/hrd";
            } else if (role.equals("dispatcher")) {
                URI = "/dispatcher";
            } else if (role.equals("accountant")) {
                URI = "/accountant";
            }
        } else {
            URI = "/authentication";
        }
        return URI;
    }
}
