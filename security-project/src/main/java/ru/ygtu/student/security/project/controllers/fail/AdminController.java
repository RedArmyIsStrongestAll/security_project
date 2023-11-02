package ru.ygtu.student.security.project.controllers.fail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ygtu.student.security.project.dto.UserDto;
import ru.ygtu.student.security.project.services.MainService;

import java.util.List;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("/fail/admin")
public class AdminController {
    private final MainService mainService;

    @Autowired
    public AdminController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/user/all")
    public Callable<ResponseEntity<List<UserDto>>> getListUserAll() {
        return () -> ResponseEntity.ok().body(mainService.getListUserAll());
    }

}
