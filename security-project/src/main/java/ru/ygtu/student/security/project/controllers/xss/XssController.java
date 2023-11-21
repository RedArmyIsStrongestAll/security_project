package ru.ygtu.student.security.project.controllers.xss;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xss")
public class XssController {

    @PostMapping()
    public Object xss(@RequestBody Object userDto) {
        return userDto;
    }
}
