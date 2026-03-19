package com.cg.dto;

import com.cg.entity.Trainee;

public class EntityMapper {
    public static Trainee convertObjectToEntity(TraineeDTO tdto){
        return new Trainee(tdto.getTraineeName(),tdto.getTraineeDomain(),tdto.getTraineeLocation());
    }

    public static TraineeDTO convertEntityToDto(Trainee t){
        return new TraineeDTO(t.getTraineeId(),t.getTraineeName(),t.getTraineeDomain(),t.getTraineeLocation());
    }

}
