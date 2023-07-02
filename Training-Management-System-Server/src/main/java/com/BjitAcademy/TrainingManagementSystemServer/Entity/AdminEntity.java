package com.BjitAcademy.TrainingManagementSystemServer.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Admins")
@Data
@Builder
public class AdminEntity {
    @Id
    private Long adminId;
    private String fullName;
    private String profilePicture;
    private String contactNumber;
    private String gender;
    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity user;
}
