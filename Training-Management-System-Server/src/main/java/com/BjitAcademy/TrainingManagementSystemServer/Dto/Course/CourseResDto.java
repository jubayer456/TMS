package com.BjitAcademy.TrainingManagementSystemServer.Dto.Course;

import com.BjitAcademy.TrainingManagementSystemServer.Entity.TrainerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResDto {
    private Long courseId;
    private String name;
    private TrainerEntity trainer;
}
