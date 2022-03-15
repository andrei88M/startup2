package com.example.startup2.controller;

import com.example.startup2.model.AmountTime;
import com.example.startup2.model.Route;
import com.example.startup2.model.Schedule;
import com.example.startup2.model.Worker;
import com.example.startup2.repository.AmountTimeRepository;
import com.example.startup2.repository.RouteRepository;
import com.example.startup2.repository.ScheduleRepository;
import com.example.startup2.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;
import java.util.Optional;

@Controller
@RequestMapping("/dispatcher")
public class DispatcherController {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private AmountTimeRepository amountTimeRepository;

    @GetMapping("")
    public String dispatcher() {
        return "dispatcher";
    }

    @GetMapping("/addRoute")
    public String newRoute() {
        return "addRoute";
    }

    @PostMapping("/addRoute")
    public String addRoute(@RequestParam("number") Integer number,
                           @RequestParam("type") String type,
                           @RequestParam("start") LocalTime start,
                           @RequestParam("finish") LocalTime finish,
                           @RequestParam("replacement") LocalTime replacement) {
        Route route = Route.builder()
                .number(number)
                .typeNumber(type)
                .startTime(start)
                .finishTime(finish)
                .replacementTime(replacement)
                .build();
        routeRepository.save(route);
        return "redirect:/dispatcher/addRoute";
    }


    @GetMapping("/createSchedule")
    public String newSchedule() {
        return "createSchedule";
    }

    @PostMapping("/createSchedule")
    public String newSchedule(@RequestParam("date") String date,
                              @RequestParam("personnelNumber") Integer persNumber,
                              @RequestParam("route") Integer route,
                              @RequestParam("type") String type,
                              @RequestParam("replacement") Integer replacement) {
        Optional<Worker> optionalWorker = workerRepository.findById(persNumber);
        Worker worker = optionalWorker.get();


        Optional<Route> route1 = routeRepository.findRouteByNumberAndTypeNumber(route, type);
        Schedule schedule = Schedule.builder()
                .worker(worker)
                .route(route1.get())
                .date(date.toString())
                .replacement(replacement)
                .build();
        scheduleRepository.save(schedule);
        return "redirect:/dispatcher/createSchedule";
    }

    @GetMapping("/regOfSpentTime")
    public String regOfTime() {
        return "registrationOfSpentTime";
    }

    @PostMapping("/regOfSpentTime")
    public String regOfSpentTime(@RequestParam("date") String date,
                                 @RequestParam("id") Integer personnelNumber,
                                 @RequestParam("quantityTime") Double quantityTime) {
        Optional<Worker> worker = workerRepository.findById(personnelNumber);
        AmountTime amountTime = AmountTime.builder()
                .date(String.valueOf(date))
                .time(quantityTime)
                .worker(worker.get())
                .build();
        amountTimeRepository.save(amountTime);
        return "redirect:/dispatcher/regOfSpentTime";
    }
}
