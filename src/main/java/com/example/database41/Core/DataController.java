package com.example.database41.Core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class DataController {

    RepositoryImpl rep;

    public DataController(RepositoryImpl rep) {this.rep = rep;}

    @GetMapping("/persons/initial")
    public void initialPersons() {
        rep.initial();
    }

    @GetMapping("/persons/by-city")
    public List<Persons> initialPersons(@RequestParam("city") String city) {return rep.getPersonsByCity(city);}
}
