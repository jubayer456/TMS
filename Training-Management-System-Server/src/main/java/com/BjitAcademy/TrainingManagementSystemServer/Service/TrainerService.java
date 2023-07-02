package com.BjitAcademy.TrainingManagementSystemServer.Service;

import com.BjitAcademy.TrainingManagementSystemServer.Dto.Trainer.TrainerRegReqDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Trainer.TrainerResDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TrainerService {
    ResponseEntity<String> createTrainers(TrainerRegReqDto trainerRegReqDto);

    ResponseEntity<List<TrainerResDto>> getAllTrainee();
}
