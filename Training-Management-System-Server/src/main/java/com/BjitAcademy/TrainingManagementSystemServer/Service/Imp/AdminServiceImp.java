package com.BjitAcademy.TrainingManagementSystemServer.Service.Imp;

import com.BjitAcademy.TrainingManagementSystemServer.Dto.Admin.AdminRegReqDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Batch.BatchReqDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Batch.BatchResDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Common.UserResDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Course.CourseReqDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Course.CourseResDto;
import com.BjitAcademy.TrainingManagementSystemServer.Entity.*;
import com.BjitAcademy.TrainingManagementSystemServer.Exception.UserAlreadyExistException;
import com.BjitAcademy.TrainingManagementSystemServer.Mapper.AdminMappingModel;
import com.BjitAcademy.TrainingManagementSystemServer.Repository.*;
import com.BjitAcademy.TrainingManagementSystemServer.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.Counter;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImp implements AdminService {
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final BatchesRepository batchesRepository;
    private final CourseRepository courseRepository;
    private final TrainerRepository trainerRepository;
    @Override
    public ResponseEntity<String> createAdmin(AdminRegReqDto adminRegReqDto) {
        UserEntity userEntityById = userRepository.findByUserId(adminRegReqDto.getAdminId());
        if (userEntityById != null) {
            throw new UserAlreadyExistException("Admin is Already taken. Please enter a new trainee Id");
        }
        UserEntity userEntityByEmail = userRepository.findByEmail(adminRegReqDto.getEmail());
        if (userEntityByEmail != null) {
            throw new UserAlreadyExistException("Admin Already Exist.. Please Change the email");
        }

        UserEntity user =UserEntity.builder()
                .userId(adminRegReqDto.getAdminId())
                .email(adminRegReqDto.getEmail())
                .role(adminRegReqDto.getRole())
                .password(passwordEncoder.encode(adminRegReqDto.getPassword()))
                .build();
        AdminEntity admin = AdminMappingModel.AdminDtoToEntity(adminRegReqDto, user);
        adminRepository.save(admin);
        return new ResponseEntity<>("successfully Registered", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> createBatch(BatchReqDto batchReqDto) {
        BatchEntity batchByName=batchesRepository.findByBatchName(batchReqDto.getBatchName());
        if (batchByName!=null){
            throw new UserAlreadyExistException("Already Assigned Batch... please insert new batch name");
        }
        BatchEntity batch=AdminMappingModel.BatchDtoToEntity(batchReqDto);
        batchesRepository.save(batch);
        return new ResponseEntity<>("Successfully Batch Inserted",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BatchResDto>> getAllBatch() {
        List<BatchEntity> batches=batchesRepository.findAll();
        List<BatchResDto> batchResDtoList=batches.stream().map(AdminMappingModel::BatchEntityToDto).toList();
        return new ResponseEntity<>(batchResDtoList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> createCourse(CourseReqDto courseReqDto) {
        TrainerEntity trainer=trainerRepository.findByTrainerId(courseReqDto.getTrainerId());
        CourseEntity course=AdminMappingModel.CourseDtoToEntity(courseReqDto,trainer);
        courseRepository.save(course);
        return new ResponseEntity<>("Successfully Registered Course",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserResDto>> getAllUser() {
        List<UserEntity> users=userRepository.findAll();
        List<UserResDto> userResList=users.stream().map(AdminMappingModel::UserEntityToDto).toList();
        return new ResponseEntity<>(userResList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CourseResDto>> getAllCourse() {
        List<CourseEntity> courses=courseRepository.findAll();
        List<CourseResDto> courseResList=courses.stream().map(AdminMappingModel::CourseEntityToDto).toList();
        return new ResponseEntity<>(courseResList,HttpStatus.OK);
    }
}
