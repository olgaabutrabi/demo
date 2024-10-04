package com.example.demo.run;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Repository

public class RunRepository { //class that have the ability to store runs
    private List<Run> runs =new ArrayList<>(); // list of all runs
    List<Run> findAll(){ // method that returns all the runs
        return runs;
    }
    Optional<Run> findById(Integer id){ // method that returns run find by id
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();

    }
    void create(Run run){ //method which adds runs
        runs.add(run);
    }
    @PostConstruct
    private void init(){  // saved runs
        runs.add(new Run(4, "Monday morning run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 6, Location.INDOOR));
        runs.add(new Run(67, "Tuesday night run", LocalDateTime.now(), LocalDateTime.now().plus(2, ChronoUnit.HOURS), 13, Location.OUTDOOR));
        runs.add(new Run(44, "Friday afternoon run", LocalDateTime.now(), LocalDateTime.now().plus(3, ChronoUnit.HOURS), 10, Location.INDOOR));
        runs.add(new Run(8, "Sunday marathon", LocalDateTime.now(), LocalDateTime.now().plus(4, ChronoUnit.HOURS), 19, Location.OUTDOOR));
    }
}
