package ru.ygtu.student.security.project.controllers.xss;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ygtu.student.security.project.dto.UserDto;

@RestController
@RequestMapping("/xss")
public class XssController {

    @PostMapping()
    public UserDto xss(@RequestBody UserDto userDto) {
        return userDto;
    }
}
