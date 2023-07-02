package com.BjitAcademy.TrainingManagementSystemServer.Service.Imp;

import com.BjitAcademy.TrainingManagementSystemServer.Dto.Trainer.TrainerRegReqDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Trainer.TrainerResDto;
import com.BjitAcademy.TrainingManagementSystemServer.Entity.TrainerEntity;
import com.BjitAcademy.TrainingManagementSystemServer.Entity.UserEntity;
import com.BjitAcademy.TrainingManagementSystemServer.Exception.UserAlreadyExistException;
import com.BjitAcademy.TrainingManagementSystemServer.Mapper.TrainerMappingModel;
import com.BjitAcademy.TrainingManagementSystemServer.Repository.TrainerRepository;
import com.BjitAcademy.TrainingManagementSystemServer.Repository.UserRepository;
import com.BjitAcademy.TrainingManagementSystemServer.Service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainerServiceImp implements TrainerService {
    private final TrainerRepository trainerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public ResponseEntity<String> createTrainers(TrainerRegReqDto trainerRegReqDto) {
        UserEntity userEntityById=userRepository.findByUserId(trainerRegReqDto.getTrainerId());
        if (userEntityById!=null){
            throw new UserAlreadyExistException("Trainer is Already taken. Please enter a new trainee Id");
        }
        UserEntity userEntityByEmail=userRepository.findByEmail(trainerRegReqDto.getEmail());
        if(userEntityByEmail!=null){
            throw new UserAlreadyExistException("Trainer Already Exist.. Please Change the email");
        }

        UserEntity user =UserEntity.builder()
                .userId(trainerRegReqDto.getTrainerId())
                .email(trainerRegReqDto.getEmail())
                .role(trainerRegReqDto.getRole())
                .password(passwordEncoder.encode(trainerRegReqDto.getPassword()))
                .build();
        TrainerEntity trainer= TrainerMappingModel.trainerDtoToEntity(trainerRegReqDto,user);
        trainerRepository.save(trainer);
        return new ResponseEntity<>("successfully Registered", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<TrainerResDto>> getAllTrainee() {
        List<TrainerEntity> trainees=trainerRepository.findAll();
        List<TrainerResDto> traineeResDtoList=trainees.stream().map(trainer-> TrainerMappingModel.trainerEntityToDto(trainer,trainer.getUser())).toList();
        return new ResponseEntity<>(traineeResDtoList,HttpStatus.OK);
    }
}
