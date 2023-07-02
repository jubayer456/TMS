package com.BjitAcademy.TrainingManagementSystemServer.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Trainees")
@Builder
public class TraineeEntity{
    @Id
    private Long traineeId;
    private String fullName;
    private String profilePicture;
    private String contactNumber;
    private String address;
    private String gender;
    private String dob;
    private String degreeName;
    private String educationalInstitute;
    private Integer passingYear;
    private Double cgpa;
    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity user;
}
