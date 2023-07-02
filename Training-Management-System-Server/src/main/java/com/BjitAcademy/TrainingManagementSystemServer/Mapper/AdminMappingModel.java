package com.BjitAcademy.TrainingManagementSystemServer.Mapper;

import com.BjitAcademy.TrainingManagementSystemServer.Dto.Admin.AdminRegReqDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Batch.BatchReqDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Batch.BatchResDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Common.UserResDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Course.CourseReqDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Course.CourseResDto;
import com.BjitAcademy.TrainingManagementSystemServer.Entity.*;
import com.BjitAcademy.TrainingManagementSystemServer.Repository.TrainerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdminMappingModel {
    public static AdminEntity AdminDtoToEntity(AdminRegReqDto adminRegReqDto, UserEntity user){
        return AdminEntity.builder()
                .adminId(adminRegReqDto.getAdminId())
                .profilePicture(adminRegReqDto.getProfilePicture())
                .contactNumber(adminRegReqDto.getContactNumber())
                .gender(adminRegReqDto.getGender())
                .user(user)
                .build();
    }
    public static BatchEntity BatchDtoToEntity(BatchReqDto batchReqDto){
        return BatchEntity.builder()
                .batchName(batchReqDto.getBatchName())
                .startingDate(batchReqDto.getStartingDate())
                .endingDate(batchReqDto.getEndingDate())
                .totalNumOfTrainee(batchReqDto.getTotalNumOfTrainee())
                .build();
    }
    public static BatchResDto BatchEntityToDto(BatchEntity batchEntity){
        return BatchResDto.builder()
                .batchId(batchEntity.getBatchId())
                .batchName(batchEntity.getBatchName())
                .startingDate(batchEntity.getStartingDate())
                .endingDate(batchEntity.getEndingDate())
                .totalNumOfTrainee(batchEntity.getTotalNumOfTrainee())
                .build();
    }
    public static CourseEntity CourseDtoToEntity(CourseReqDto courseReqDto,TrainerEntity trainer){
        return CourseEntity.builder()
                .name(courseReqDto.getName())
                .trainer(trainer)
                .build();
    }  public static CourseResDto CourseEntityToDto(CourseEntity courseEntity){
        return CourseResDto.builder()
                .courseId(courseEntity.getCourseId())
                .name(courseEntity.getName())
                .trainer(courseEntity.getTrainer())
                .build();
    }
    public static UserResDto UserEntityToDto(UserEntity userEntity){
        return UserResDto.builder()
                .userId(userEntity.getUserId())
                .email(userEntity.getEmail())
                .role(userEntity.getRole())
                .build();
    }
}
