package com.example.startup2.controller;

import com.example.startup2.model.Role;
import com.example.startup2.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.SecondaryTable;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@Controller
public class FilterController {

    @Autowired
    private WorkerRepository workerRepository;

    @PostMapping("/filter")
    private String filter(@RequestParam("id") String username) {
       Set<Role> roles = workerRepository.findWorkerByUsername(username).get().getRoles();
        for (Role role : roles) {
            if (role.equals(Role.DRIVER)){
                return "redirect:/driver";
            }else if (role.equals(Role.HRD)){
                return "redirect:/hrd";
            }else if (role.equals(Role.ACCOUNTANT)){
                return "redirect:/accountant";
            }else if (role.equals(Role.DISPATCHER)){
                return "redirect:/dispatcher";
            }
        }
        return "redirect:/home";
    }
}
