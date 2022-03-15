package com.example.startup2.controller;

import com.example.startup2.model.Salary;
import com.example.startup2.model.Schedule;
import com.example.startup2.model.Worker;
import com.example.startup2.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping("")
    public String worker() {
        return "worker";
    }

    @GetMapping("/seeSchedule")
    public String seeSchedule(HttpServletRequest request, Model model) {
        int personnelNumber = (int) request.getSession().getAttribute("id");
        Optional<Worker> worker = workerRepository.findById(personnelNumber);
        Set<Schedule> scheduleSet = worker.get().getScheduleSet();
        model.addAttribute("set", scheduleSet);
        return "seeSchedule";
    }

    @GetMapping("/seeSalary")
    public String seeSalary(HttpServletRequest request, Model model){
        int personnelNumber = (int) request.getSession().getAttribute("id");
        Optional<Worker> worker = workerRepository.findById(personnelNumber);
        Set<Salary> salarySet = worker.get().getSalarySet();
        model.addAttribute("set", salarySet);
        return "seeSalary";
    }
}
