package com.cg.service;

import com.cg.dto.TraineeDTO;

import java.util.List;

public interface ITraineeService {

    public TraineeDTO createTrainee(TraineeDTO t);
    public List<TraineeDTO> getAllTrainee();
    public List<TraineeDTO> getByName(String name);
    public TraineeDTO getById(int id);
    public TraineeDTO deleteById(int id);
    public TraineeDTO updateTrainee(TraineeDTO t);
    public List<TraineeDTO> getByLocation(String loc);

}
