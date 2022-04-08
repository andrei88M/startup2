package com.example.startup2.controller;

import com.example.startup2.model.Salary;
import com.example.startup2.model.Schedule;
import com.example.startup2.model.Worker;
import com.example.startup2.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/driver")
@PreAuthorize("hasAuthority('DRIVER')")
public class DriverController {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping("")
    public String worker() {
        return "driver";
    }

    @GetMapping("/seeSchedule")
    public String seeSchedule() {
        return "/driver/seeSchedule";
    }

    @PostMapping("/seeSchedule")
    public String seeSchedule(@RequestParam("id") String id, Model model) {
        Optional<Worker> worker = workerRepository.findWorkerByUsername(id);
        Set<Schedule> scheduleSet = worker.get().getScheduleSet();
        model.addAttribute("set", scheduleSet);
        return "/driver/seeSchedule";
    }

    @GetMapping("/seeSalary")
    public String seeSalary() {
        return "/driver/seeSalary";
    }

    @PostMapping("/seeSalary")
    public String seeSalary(@RequestParam("id") String id, Model model) {
        Optional<Worker> worker = workerRepository.findWorkerByUsername(id);
        Set<Salary> salarySet = worker.get().getSalarySet();
        model.addAttribute("set", salarySet);
        return "/driver/seeSalary";
    }
}
