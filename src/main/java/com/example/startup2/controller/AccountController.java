package com.example.startup2.controller;

import com.example.startup2.model.Account;
import com.example.startup2.model.Worker;
import com.example.startup2.repository.AccountRepository;
import com.example.startup2.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.Optional;

@Controller
public class AccountController {
    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/registration")
    public String reg() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam("name") String name,
                               @RequestParam("surname") String surname,
                               @RequestParam("personnelNumber") Integer personnelNumber,
                               @RequestParam("password") String password,
                               @RequestParam("password2") String password2) {
        if (!password.equals(password2)) {
            return "registration";
        }
        Optional<Worker> worker = workerRepository.findById(personnelNumber);
        if (worker.isEmpty()) {
            return "registration";
        }
        if (!worker.get().getName().equals(name) &&
                !worker.get().getSurname().equals(surname) &&
                !worker.get().getPersonnelNumber().equals(personnelNumber)) {
            return "registration";
        }
        Account account = Account.builder()
                .worker(worker.get())
                .password(password)
                .build();
        accountRepository.save(account);
        return "redirect:/authorization";
    }

    @GetMapping("/authorization")
    public String auth() {
        return "authorization";
    }

    @PostMapping("/authorization")
    public String authorization(@RequestParam("id") Integer id,
                                @RequestParam("password") String password,
                                HttpServletRequest request) {
        Optional<Worker> worker = workerRepository.findById(id);
        if (worker.isEmpty() ||
                worker.get().getAccount() == null ||
                !worker.get().getAccount().getPassword().equals(password)) {
            return "/authorization";
        }
        String role = worker.get().getRole();

        request.getSession().setAttribute("id", id);
        request.getSession().setAttribute("password", password);
        request.getSession().setAttribute("role", role);
        switch (role) {
            case "worker":
                return "redirect:/worker";
            case "dispatcher":
                return "redirect:/dispatcher";
            case "hrd":
                return "redirect:/hrd";
            case "accountant":
                return "redirect:/accountant";
        }
        return "redirect:/";
    }
}
