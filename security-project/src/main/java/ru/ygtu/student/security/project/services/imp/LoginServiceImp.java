package ru.ygtu.student.security.project.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.ygtu.student.security.project.dto.LoginRequestDto;
import ru.ygtu.student.security.project.dto.UserDto;
import ru.ygtu.student.security.project.repositories.MainRepository;
import ru.ygtu.student.security.project.services.LoginService;

import java.util.List;

@Service
public class LoginServiceImp implements LoginService {
    private final MainRepository mainRepository;

    @Autowired
    public LoginServiceImp(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    @Override
    public UserDto loging(LoginRequestDto loginRequestDto) {
        UserDto userDto = mainRepository.getUserByUsernameAndPassword(
                loginRequestDto.getUsername(),
                loginRequestDto.getPassword());

        if (userDto != null) {
            GrantedAuthority role = new SimpleGrantedAuthority(String.valueOf(userDto.getRoleId()));
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDto.getUsername(),
                    null, List.of(role));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return userDto;
        } else {
            return null;
        }
    }
}
