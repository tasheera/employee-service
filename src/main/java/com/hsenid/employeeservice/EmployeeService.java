package com.hsenid.employeeservice;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import java.util.List;

public class EmployeeService {
    private List<String> ids;
    private List<String> names;

    public List<String> getIds(){
        return ids;
    }

    public void setIds(List<String> ids){
        this.ids = ids;
    }

    public List<String> getNames(){
        return names;
    }

    public void setNames(List<String> names){
        this.names = names;
    }

    @PostConstruct
    public void init(){
        System.out.println("Init method after properties are set ");
    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("Spring Container is destroy! Clean up");
    }


    public String fetchEmployee(){

        StringBuilder combined = new StringBuilder();

        for (int i = 0; i < ids.size(); i++) {
            combined.append(ids.get(i)).append(": ").append(names.get(i));
            if (i < ids.size() - 1) {
                combined.append(", ");
            }
        }

        return combined.toString();
    }
}
