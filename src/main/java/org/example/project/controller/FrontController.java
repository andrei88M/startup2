package org.example.project.controller;

import org.example.project.command.CommandFactory;
import org.example.project.command.ICommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class FrontController extends HttpServlet {
    private ICommand iCommand;
    private CommandFactory commandFactory;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        commandFactory = new CommandFactory();
        iCommand = commandFactory.get(command);
        String uri = iCommand.execute(req, resp);
        req.getRequestDispatcher(uri).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        commandFactory = new CommandFactory();
        iCommand = commandFactory.get(command);
        String uri = iCommand.execute(req, resp);
        resp.sendRedirect(getServletContext().getContextPath() + uri);
    }
}
