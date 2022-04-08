package com.example.startup2.controller;

import com.example.startup2.model.Role;
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

@Controller
@RequestMapping("/hrd")
@PreAuthorize("hasAuthority('HRD')")
public class HrdController {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public String hrd() {
        return "hrd";
    }

    @GetMapping("/addWorker")
    public String newWorker() {
        return "/hrd/addWorker";
    }

    @PostMapping("/addWorker")
    public String addWorker(@RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("personnelNumber") String personnelNumber,
                            @RequestParam("telephoneNumber") String telephoneNumber,
                            @RequestParam("dateOfBirth") String dateOfBirth,
                            @RequestParam("role") String role,
                            Model model) {
        Worker worker = workerRepository.findByPersonnelNumber(personnelNumber);
        if (worker == null) {
            worker = new Worker();
            worker.setName(name);
            worker.setSurname(surname);
            worker.setPersonnelNumber(personnelNumber);
            worker.setTelephone(telephoneNumber);
            worker.setDateOfBirth(dateOfBirth);
            worker.getRoles().add(Role.valueOf(role));
            workerRepository.save(worker);
        }

        return "redirect:/hrd/addWorker";
    }

    @GetMapping("/removeWorker")
    public String dropWorker() {
        return "/hrd/removeWorker";
    }

    @PostMapping("/removeWorker")
    public String removeWorker(@RequestParam("personnelNumber") String personnelNumber) {
        return "redirect:/hrd/removeWorker";
    }
}
