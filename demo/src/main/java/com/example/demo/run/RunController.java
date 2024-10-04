package com.example.demo.run;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs") //to cut down some of the duplication of mapping
public class RunController {
    // run repository is not available to the public but the controller requests it. The request is "hey i need all the runs"
    // and returns the response>"these are all the runs"
    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("") // shows on this page all of our runs
    List<Run> findAll(){
        return runRepository.findAll();
    }
   @GetMapping("/{id}")
    Run findById(@PathVariable Integer id){ // finding the variable
       Optional<Run> run = runRepository.findById(id);
       if(run.isEmpty()){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }
       return run.get();
    }

    // post

    @GetMapping("")
    void create(@RequestBody Run run){ //is going to be coming from the request body
        runRepository.create(run);
    }
    //put

    //delete

}
