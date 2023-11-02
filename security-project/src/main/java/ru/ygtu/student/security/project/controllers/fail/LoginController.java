package ru.ygtu.student.security.project.controllers.fail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ygtu.student.security.project.dto.LoginRequestDto;
import ru.ygtu.student.security.project.dto.UserDto;
import ru.ygtu.student.security.project.services.LoginService;

import javax.servlet.http.HttpSession;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("/fail/log")
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping()
    public Callable<ResponseEntity<UserDto>> loging(@RequestBody LoginRequestDto loginRequestDto, HttpSession session) {
        return () -> {
            UserDto userDto = loginService.loging(loginRequestDto);
            if (userDto != null) {
                session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                        SecurityContextHolder.getContext());
                return ResponseEntity.ok().body(userDto);
            } else {
                return ResponseEntity.badRequest().build();
            }
        };
    }
}
