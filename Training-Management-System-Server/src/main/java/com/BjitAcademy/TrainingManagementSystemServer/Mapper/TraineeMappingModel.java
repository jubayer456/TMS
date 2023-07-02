package com.BjitAcademy.TrainingManagementSystemServer.Mapper;

import com.BjitAcademy.TrainingManagementSystemServer.Dto.Trainee.TraineeRegReqDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Trainee.TraineeResDto;
import com.BjitAcademy.TrainingManagementSystemServer.Entity.TraineeEntity;
import com.BjitAcademy.TrainingManagementSystemServer.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;


public class TraineeMappingModel {
    @Autowired
    private static PasswordEncoder passwordEncoder;

    public static TraineeEntity traineeDtoToEntity(TraineeRegReqDto traineeRegReqDto, UserEntity user){
        return TraineeEntity.builder()
                .traineeId(traineeRegReqDto.getTraineeId())
                .fullName(traineeRegReqDto.getFullName())
                .dob(traineeRegReqDto.getDob())
                .cgpa(traineeRegReqDto.getCgpa())
                .address(traineeRegReqDto.getAddress())
                .gender(traineeRegReqDto.getGender())
                .contactNumber(traineeRegReqDto.getContactNumber())
                .educationalInstitute(traineeRegReqDto.getEducationalInstitute())
                .passingYear(traineeRegReqDto.getPassingYear())
                .profilePicture(traineeRegReqDto.getProfilePicture())
                .degreeName(traineeRegReqDto.getDegreeName())
                .user(user)
                .build();
    }
    public static TraineeResDto traineeEntityToDto(TraineeEntity traineeEntity, UserEntity user){
        return TraineeResDto.builder()
                .traineeId(traineeEntity.getTraineeId())
                .fullName(traineeEntity.getFullName())
                .dob(traineeEntity.getDob())
                .cgpa(traineeEntity.getCgpa())
                .address(traineeEntity.getAddress())
                .gender(traineeEntity.getGender())
                .contactNumber(traineeEntity.getContactNumber())
                .educationalInstitute(traineeEntity.getEducationalInstitute())
                .passingYear(traineeEntity.getPassingYear())
                .profilePicture(traineeEntity.getProfilePicture())
                .degreeName(traineeEntity.getDegreeName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
