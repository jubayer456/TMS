package com.BjitAcademy.TrainingManagementSystemServer.Service;

import com.BjitAcademy.TrainingManagementSystemServer.Dto.Admin.AdminRegReqDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Batch.BatchReqDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Batch.BatchResDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Common.UserResDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Course.CourseReqDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Course.CourseResDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {
    ResponseEntity<String> createAdmin(AdminRegReqDto adminRegReqDto);

    ResponseEntity<String> createBatch(BatchReqDto batchReqDto);

    ResponseEntity<List<BatchResDto>> getAllBatch();

    ResponseEntity<String> createCourse(CourseReqDto courseReqDto);

    ResponseEntity<List<UserResDto>> getAllUser();

    ResponseEntity<List<CourseResDto>> getAllCourse();
}
