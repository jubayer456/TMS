package com.BjitAcademy.TrainingManagementSystemServer.Controller;

import com.BjitAcademy.TrainingManagementSystemServer.Dto.Admin.AdminRegReqDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Batch.BatchReqDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Batch.BatchResDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Common.UserResDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Course.CourseReqDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Course.CourseResDto;
import com.BjitAcademy.TrainingManagementSystemServer.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    @PostMapping
    public ResponseEntity<String> createAdmin(@RequestBody AdminRegReqDto adminRegReqDto){
        return adminService.createAdmin(adminRegReqDto);
    }
    @PostMapping("/batch")
    public ResponseEntity<String> createBatch(@RequestBody BatchReqDto batchReqDto){
        return adminService.createBatch(batchReqDto);
    }
    @GetMapping("/batch")
    public ResponseEntity<List<BatchResDto>> getAllBatch(){
        return adminService.getAllBatch();
    }
    @PostMapping("/course")
    public ResponseEntity<String> createCourse(@RequestBody CourseReqDto courseReqDto){
        return adminService.createCourse(courseReqDto);
    }
    @GetMapping("/AllUser")
    public ResponseEntity<List<UserResDto>> getAllUser(){
        return adminService.getAllUser();
    }
    @GetMapping("/course")
    public ResponseEntity<List<CourseResDto>> getAllCourse(){
        return adminService.getAllCourse();
    }
}
