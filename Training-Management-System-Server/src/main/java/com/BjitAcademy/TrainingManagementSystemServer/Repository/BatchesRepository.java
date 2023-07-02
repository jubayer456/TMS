package com.BjitAcademy.TrainingManagementSystemServer.Repository;

import com.BjitAcademy.TrainingManagementSystemServer.Entity.AdminEntity;
import com.BjitAcademy.TrainingManagementSystemServer.Entity.BatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchesRepository extends JpaRepository<BatchEntity,Long> {
    BatchEntity findByBatchName(String batchName);
}
