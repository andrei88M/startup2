package com.example.startup2.controller;

import com.example.startup2.model.Worker;
import com.example.startup2.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hrd")
public class HrdController {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping("")
    public String hrd(){
        return "hrd";
    }

    @GetMapping("/addWorker")
    public String newWorker(){
        return "addWorker";
    }

    @PostMapping("/addWorker")
    public String addWorker(@RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("personnelNumber") String personnelNumber,
                            @RequestParam("telephoneNumber") String telephoneNumber,
                            @RequestParam("role") String role,
                            Model model){

        boolean aBoolean;
        aBoolean = workerRepository.existsById(Integer.valueOf(personnelNumber));

        if (aBoolean){
            model.addAttribute("message", "not_save");
            return "addWorker";
        }else {
            Worker worker = Worker.builder()
                    .name(name)
                    .surname(surname)
                    .personnelNumber(Integer.valueOf(personnelNumber))
                    .telephoneNumber(telephoneNumber)
                    .role(role)
                    .build();
            workerRepository.save(worker);
        }
        return "redirect:/hrd/addWorker";
    }

    @GetMapping("/removeWorker")
    public String dropWorker(){
        return "removeWorker";
    }

    @PostMapping("/removeWorker")
    public String removeWorker(@RequestParam("personnelNumber") String personnelNumber){
        workerRepository.deleteById(Integer.valueOf(personnelNumber));
        return "redirect:/hrd/removeWorker";
    }
}
