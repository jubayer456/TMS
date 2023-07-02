package com.BjitAcademy.TrainingManagementSystemServer.Repository;

import com.BjitAcademy.TrainingManagementSystemServer.Entity.TraineeEntity;
import com.BjitAcademy.TrainingManagementSystemServer.Entity.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineeRepository extends JpaRepository<TraineeEntity,Long> {
}
