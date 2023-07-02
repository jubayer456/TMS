package com.BjitAcademy.TrainingManagementSystemServer.Controller;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Trainer.TrainerRegReqDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Trainer.TrainerResDto;
import com.BjitAcademy.TrainingManagementSystemServer.Service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainer")
@RequiredArgsConstructor
public class TrainerController {
    private final TrainerService trainerService;
    @PostMapping
    public ResponseEntity<String> createTrainers(@RequestBody TrainerRegReqDto trainerRegReqDto){
        return trainerService.createTrainers(trainerRegReqDto);
    }
    @GetMapping
    public ResponseEntity<List<TrainerResDto>> getAllTrainee() {
        return trainerService.getAllTrainee();
    }
}
