package org.example.project.command;

import org.example.project.command.get.*;
import org.example.project.command.post.*;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private final Map<String, ICommand> commandMap;

    {
        commandMap = new HashMap<>();
        commandMap.put("AUTHENTICATION", new AuthenticationCommand());
        commandMap.put("REGISTRATION", new RegistrationCommand());
        commandMap.put("CREATE_WORKER", new CreateWorkerCommand());
        commandMap.put("DELETE_WORKER", new DeleteWorkerCommand());
        commandMap.put("CREATE_ROUTE", new CreateRouteCommand());
        commandMap.put("DELETE_ROUTE", new DeleteRouteCommand());
        commandMap.put("CREATE_SCHEDULE", new CreateScheduleCommand());
        commandMap.put("ADD_TIME", new AddTimeCommand());
        commandMap.put("WORK_TIME", new WorkTimeCommand());
        commandMap.put("WORK_MONEY", new SalaryCommand());
        commandMap.put("SEE_SCHEDULE", new SeeScheduleCommand());
        commandMap.put("SEE_WORK_TIME", new SeeWorkTimeCommand());
        commandMap.put("SEE_MONEY", new SeeMoneyCommand());
        commandMap.put("MESSAGE_WRITE", new MessageCommand());
        commandMap.put("MESSAGE_READ", new MessageReadCommand());
    }

    public ICommand get(String command){
        return commandMap.get(command);
    }
}
