package org.example.project.command.post;

import org.example.project.command.ICommand;
import org.example.project.dao.MySqlDaoAccount;
import org.example.project.dao.MySqlDaoAccountIpl;
import org.example.project.dao.MySqlDaoMessage;
import org.example.project.dao.MySqlDaoMessageImp;
import org.example.project.entity.Account;
import org.example.project.error.ExceptionDAO;
import org.example.project.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MessageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String text = req.getParameter("text");
        String to = req.getParameter("to");
        Service service = Service.getInstance();
        Account account = null;
        try {
            account = service.getDaoAccount().get(Integer.valueOf(to));
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }
        HttpSession session = req.getSession();
        int id = (int) session.getAttribute("id");
        Account account1 = null;
        try {
            account1 = service.getDaoAccount().get(id);
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }
        try {
            service.getDaoMessage().write(text, account1, account);
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }
        return "/message";
    }
}
