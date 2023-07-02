package com.BjitAcademy.TrainingManagementSystemServer.Dto.Common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResDto {
    private Long userId;
    private String email;
    private String role;
}
