package com.BjitAcademy.TrainingManagementSystemServer.Common;

import com.BjitAcademy.TrainingManagementSystemServer.Dto.Common.AuthenticationResDto;
import com.BjitAcademy.TrainingManagementSystemServer.Dto.Common.LoginDto;
import com.BjitAcademy.TrainingManagementSystemServer.Repository.UserRepository;
import com.BjitAcademy.TrainingManagementSystemServer.Utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public ResponseEntity<AuthenticationResDto> login(LoginDto loginDto) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.getEmail(),
                    loginDto.getPassword()));
            var user=userRepository.findByEmail(loginDto.getEmail());
            var jwtToken=jwtService.generateToken(user);
            return new ResponseEntity<>(AuthenticationResDto.builder().token(jwtToken).build(), HttpStatus.OK);
        }
    }
