package org.example.project.command.post;

import org.example.project.command.ICommand;
import org.example.project.dao.MySqlDaoAccount;
import org.example.project.dao.MySqlDaoAccountIpl;
import org.example.project.entity.Account;
import org.example.project.entity.Worker;
import org.example.project.error.ExceptionDAO;
import org.example.project.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String personnelNumber = req.getParameter("personnelNumber");
        String login = req.getParameter("login");
        String password = req.getParameter("password1");
        String password2 = req.getParameter("password2");

        Service service = Service.getInstance();
        Account account = null;
        try {
            account = service.getDaoAccount().getByLogin(login);
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }
        final String URI;
        if (name == null ||
                surname == null ||
                personnelNumber == null ||
                login == null ||
                password == null ||
                account != null ||
                !password.equals(password2)) {

            URI = "/registration";
        } else {
            Worker worker = null;
            try {
                worker = service.getDaoWorker().get(Integer.parseInt(personnelNumber));
            } catch (ExceptionDAO e) {
                e.printStackTrace();
                return "/error";
            }
            if (worker == null || !worker.getName().equals(name) || !worker.getSurname().equals(surname)) {
                URI = "/registration";
            } else {
                account = new Account();
                account.setLogin(login);
                account.setPassword(password);
                account.setWorker(worker);

                try {
                    service.getDaoAccount().update(account);
                } catch (ExceptionDAO e) {
                    e.printStackTrace();
                    return "/error";
                }

                URI = "/authentication";
            }
        }
        return URI;
    }
}
