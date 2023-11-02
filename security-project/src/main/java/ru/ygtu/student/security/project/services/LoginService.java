package ru.ygtu.student.security.project.services;

import ru.ygtu.student.security.project.dto.LoginRequestDto;
import ru.ygtu.student.security.project.dto.UserDto;

public interface LoginService {
    public UserDto loging(LoginRequestDto loginRequestDto);
}
