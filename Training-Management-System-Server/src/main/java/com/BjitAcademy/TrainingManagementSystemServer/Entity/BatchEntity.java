package com.BjitAcademy.TrainingManagementSystemServer.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "batches")
public class BatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long batchId;
    private String batchName;
    private String startingDate;
    private String endingDate;
    private Integer totalNumOfTrainee;
}
