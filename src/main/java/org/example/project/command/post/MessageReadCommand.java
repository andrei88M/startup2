package org.example.project.command.post;

import org.example.project.command.ICommand;
import org.example.project.dao.MySqlDaoAccount;
import org.example.project.dao.MySqlDaoAccountIpl;
import org.example.project.dao.MySqlDaoMessage;
import org.example.project.dao.MySqlDaoMessageImp;
import org.example.project.entity.Account;
import org.example.project.entity.Message;
import org.example.project.error.ExceptionDAO;
import org.example.project.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class MessageReadCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String from = req.getParameter("from");
        HttpSession session = req.getSession();
        int id = (int) session.getAttribute("id");
        Service service = Service.getInstance();
        List<Message> list = null;
        try {
            list = service.getDaoMessage().read(Integer.parseInt(from),id);
        } catch (ExceptionDAO e) {
            e.printStackTrace();
            return "/error";
        }
        req.setAttribute("messages", list);
        return "/message";
    }
}
