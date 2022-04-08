package com.example.startup2.controller;

import com.example.startup2.model.Salary;
import com.example.startup2.model.Worker;
import com.example.startup2.repository.SalaryRepository;
import com.example.startup2.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/accountant")
public class AccountantController {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private SalaryRepository salaryRepository;

    @GetMapping("")
    public String accountant() {
        return "accountant";
    }

    @GetMapping("/salary")
    public String salary() {
        return "/accountant/salary";
    }

    @PostMapping("/salary")
    public String addSalary(@RequestParam("allTime") Double allTime,
                            @RequestParam("money") Double money,
                            @RequestParam("month") String month,
                            @RequestParam("id") String personnelNumber) {
        Worker worker = workerRepository.findByPersonnelNumber(personnelNumber);
        Salary salary = Salary.builder()
                .allTime(allTime)
                .money(money)
                .month(month)
                .worker(worker)
                .build();
        salaryRepository.save(salary);
        return "redirect:/accountant/salary";
    }
}
