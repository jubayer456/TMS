package com.BjitAcademy.TrainingManagementSystemServer.Common;

import com.BjitAcademy.TrainingManagementSystemServer.Dto.Common.AuthenticationResDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Common.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginController {
    private final LoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResDto> login(@RequestBody LoginDto loginDto) {
        return loginService.login(loginDto);
    }
}
