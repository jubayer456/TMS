package com.BjitAcademy.TrainingManagementSystemServer.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Trainers")
@Data
@Builder
public class TrainerEntity {
    @Id
    private Long trainerId;
    private String fullName;
    private String profilePicture;
    private String contactNumber;
    private String address;
    private String gender;
    private String designation;
    private String joiningDate;
    private Integer totalYrsExp;
    private String expertises;
    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity user;
}
