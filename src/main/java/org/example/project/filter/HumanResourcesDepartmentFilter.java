package org.example.project.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HumanResourcesDepartmentFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String role = (String) session.getAttribute("role");
        if (role == null || !role.equals("hrd")){
            req.getRequestDispatcher("/authentication").forward(req,resp);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
