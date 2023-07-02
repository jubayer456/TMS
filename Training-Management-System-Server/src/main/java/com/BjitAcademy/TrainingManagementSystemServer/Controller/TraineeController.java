package com.BjitAcademy.TrainingManagementSystemServer.Controller;

import com.BjitAcademy.TrainingManagementSystemServer.Dto.Trainee.TraineeRegReqDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Trainee.TraineeResDto;
import com.BjitAcademy.TrainingManagementSystemServer.Service.TraineeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainee")
@RequiredArgsConstructor
public class TraineeController {
    private final TraineeService traineeService;
    @PostMapping
    public ResponseEntity<String> createTrainee(@RequestBody TraineeRegReqDto traineeReqDto) {
        return traineeService.createTrainee(traineeReqDto);
    }
    @GetMapping
    public ResponseEntity<List<TraineeResDto>> getAllTrainee() {
        return traineeService.getAllTrainee();
    }
}
