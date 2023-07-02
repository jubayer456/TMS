package com.BjitAcademy.TrainingManagementSystemServer.Dto.Common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {
    private Integer status;
    private String msg;
}
