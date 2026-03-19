package com.cg.controller;

import com.cg.dto.TraineeDTO;
import com.cg.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TraineeController {
    @Autowired
    private TraineeService ts;

    @PostMapping
    public TraineeDTO createTrainee(@RequestBody TraineeDTO t){
          return ts.createTrainee(t);
    }
    @GetMapping
    public List<TraineeDTO> getAllTrainee(){
           return ts.getAllTrainee();
    }
    @GetMapping("/name/{name}")
    public List<TraineeDTO> getByName(@PathVariable String name){
           return ts.getByName(name);
    }

    @GetMapping("/id/{id}")
    public TraineeDTO getById(@PathVariable int id){
        return ts.getById(id);
    }

    @DeleteMapping("/id/{id}")
    public TraineeDTO deleteById(@PathVariable int id){
           return ts.deleteById(id);
    }

    @PutMapping
    public TraineeDTO updateTrainee(@RequestBody TraineeDTO t){
           return ts.updateTrainee(t);
    }

    @GetMapping("/loc/{loc}")
    public List<TraineeDTO> getByLocation(@PathVariable String loc){
        return ts.getByLocation(loc);
    }


}
