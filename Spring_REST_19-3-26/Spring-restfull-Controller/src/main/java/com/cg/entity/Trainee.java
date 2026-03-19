package com.cg.entity;

import jakarta.persistence.*;

@Entity
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trainee_id")
    private int traineeId;
    private String traineeName;
    private String traineeDomain;
    private String traineeLocation;

    public Trainee(String traineeName, String traineeDomain, String traineeLocation) {
        this.traineeName = traineeName;
        this.traineeDomain = traineeDomain;
        this.traineeLocation = traineeLocation;
    }

    public Trainee() {
    }

    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName;
    }

    public String getTraineeDomain() {
        return traineeDomain;
    }

    public void setTraineeDomain(String traineeDomain) {
        this.traineeDomain = traineeDomain;
    }

    public String getTraineeLocation() {
        return traineeLocation;
    }

    public void setTraineeLocation(String traineeLocation) {
        this.traineeLocation = traineeLocation;
    }
}
