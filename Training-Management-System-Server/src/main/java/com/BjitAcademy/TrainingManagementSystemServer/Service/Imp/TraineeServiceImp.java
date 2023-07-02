package com.BjitAcademy.TrainingManagementSystemServer.Service.Imp;

import com.BjitAcademy.TrainingManagementSystemServer.Dto.Trainee.TraineeRegReqDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Trainee.TraineeResDto;
import com.BjitAcademy.TrainingManagementSystemServer.Entity.TraineeEntity;
import com.BjitAcademy.TrainingManagementSystemServer.Entity.UserEntity;
import com.BjitAcademy.TrainingManagementSystemServer.Exception.UserAlreadyExistException;
import com.BjitAcademy.TrainingManagementSystemServer.Mapper.TraineeMappingModel;
import com.BjitAcademy.TrainingManagementSystemServer.Repository.TraineeRepository;
import com.BjitAcademy.TrainingManagementSystemServer.Repository.UserRepository;
import com.BjitAcademy.TrainingManagementSystemServer.Service.TraineeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TraineeServiceImp implements TraineeService {
    private final TraineeRepository traineeRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public ResponseEntity<String> createTrainee(TraineeRegReqDto traineeReqDto) {
        UserEntity userEntityById=userRepository.findByUserId(traineeReqDto.getTraineeId());
        if (userEntityById!=null){
            throw new UserAlreadyExistException("TraineeId is Already taken. Please enter a new trainee Id");
        }
        UserEntity userEntityByEmail=userRepository.findByEmail(traineeReqDto.getEmail());
        if(userEntityByEmail!=null){
            throw new UserAlreadyExistException("User Already Exist.. Please Change the email");
        }

        UserEntity user =UserEntity.builder()
                .userId(traineeReqDto.getTraineeId())
                .email(traineeReqDto.getEmail())
                .role(traineeReqDto.getRole())
                .password(passwordEncoder.encode(traineeReqDto.getPassword()))
                .build();
        TraineeEntity trainee= TraineeMappingModel.traineeDtoToEntity(traineeReqDto,user);
        traineeRepository.save(trainee);
        return new ResponseEntity<>("successfully Registered", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<TraineeResDto>> getAllTrainee() {
        List<TraineeEntity> trainees=traineeRepository.findAll();
        List<TraineeResDto> traineeResDtoList=trainees.stream().map(trainee-> TraineeMappingModel.traineeEntityToDto(trainee,trainee.getUser())).toList();
        return new ResponseEntity<>(traineeResDtoList,HttpStatus.OK);
    }
}
