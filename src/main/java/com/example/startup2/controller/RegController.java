package com.example.startup2.controller;

import com.example.startup2.model.Role;
import com.example.startup2.model.Worker;
import com.example.startup2.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
public class RegController {
    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping("/reg")
    private String reg2() {
        return "/reg";
    }

    @PostMapping("/reg")
    private String reg(@RequestParam("username") String username,
                       @RequestParam("password") String password,
                       @RequestParam("password2") String password2,
                       @RequestParam("personnelNumber") String personnelNumber,
                       @RequestParam("name") String name,
                       @RequestParam("surname") String surname) {
        Worker worker = workerRepository.findByPersonnelNumber(personnelNumber);


       // Worker worker = workerOptional.get();
        if (password.equals(password2)) {
            if (name.equals(worker.getName())
                    && surname.equals(worker.getSurname())
                    && personnelNumber.equals(worker.getPersonnelNumber())
                    && !worker.isActive()) {
                worker.setUsername(username);
                worker.setPassword(password);
                worker.setActive(true);

                workerRepository.save(worker);
                return "redirect:/login";
            }
        }
        return "/home";

    }
}
