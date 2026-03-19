package com.cg.service;

import com.cg.dao.ITraineeJPARepository;
import com.cg.dto.EntityMapper;
import com.cg.dto.TraineeDTO;
import com.cg.entity.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TraineeService implements ITraineeService {
    @Autowired
    private ITraineeJPARepository trepo;


    @Override
    public TraineeDTO createTrainee(TraineeDTO t) {
        Trainee tr = trepo.saveAndFlush(EntityMapper.convertObjectToEntity(t));
        return EntityMapper.convertEntityToDto(tr);
    }

    @Override
    public List<TraineeDTO> getAllTrainee() {
        List<Trainee> trainees = trepo.findAll();
        List<TraineeDTO> tdto = new ArrayList<>();
        trainees.forEach(e->tdto.add(EntityMapper.convertEntityToDto(e)));
        return tdto;
    }

    @Override
    public List<TraineeDTO> getByName(String name) {
        List<Trainee> t = trepo.findByTraineeName(name);
        List<TraineeDTO> tdto = new ArrayList<>();
        t.forEach(e->tdto.add(EntityMapper.convertEntityToDto(e)));
        return tdto;
    }

    @Override
    public TraineeDTO getById(int id) {
        Optional<Trainee> op = trepo.findById(id);
        if(op.isPresent())
            return EntityMapper.convertEntityToDto(op.get());
        else
            return null;
    }

    @Override
    public TraineeDTO deleteById(int id) {
        Optional<Trainee> op = trepo.findById(id);
        if(op.isPresent()) {
            trepo.deleteById(id);
            return EntityMapper.convertEntityToDto(op.get());
        }else
            return null;
    }

    @Override
    public TraineeDTO updateTrainee(TraineeDTO t) {
        Optional<Trainee> op = trepo.findById(t.getTraineeId());

        if(op.isPresent()) {
            Trainee tr = op.get();
            if (t.getTraineeName() != null) {
                tr.setTraineeName(t.getTraineeName());
            }

            if (t.getTraineeDomain() != null) {
                tr.setTraineeDomain(t.getTraineeDomain());
            }

            if (t.getTraineeLocation() != null) {
                tr.setTraineeLocation(t.getTraineeLocation());
            }

            return EntityMapper.convertEntityToDto(trepo.saveAndFlush(tr));
        }
        return null;
    }

    @Override
    public List<TraineeDTO> getByLocation(String loc) {
        List<Trainee> t = trepo.findByTraineeLocation(loc);
        List<TraineeDTO> tdto = new ArrayList<>();
        t.forEach(e->tdto.add(EntityMapper.convertEntityToDto(e)));
        return tdto;
    }
}
