package ru.ygtu.student.security.project.controllers.fail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ygtu.student.security.project.dto.ProductDto;
import ru.ygtu.student.security.project.services.MainService;
import ru.ygtu.student.security.project.services.SystemService;

import java.util.List;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("/fail/main")
public class MainController {
    private final MainService mainService;
    private final SystemService systemService;

    @Autowired
    public MainController(MainService mainService, SystemService systemService) {
        this.mainService = mainService;
        this.systemService = systemService;

    }

    @GetMapping("/all")
    public Callable<ResponseEntity<List<ProductDto>>> getListProductAll() {
        return () -> ResponseEntity.ok().body(mainService.getListProductAll());
    }

    @GetMapping("/search")
    public Callable<ResponseEntity<List<ProductDto>>> getListProductByName(@RequestParam String name) {
        return () -> ResponseEntity.ok().body(mainService.getListProductByName(name));
    }

    @GetMapping("/reboot")
    public Callable<ResponseEntity<Void>> reboot() {
        return () -> {
            systemService.rebootBd();
            return ResponseEntity.ok().build();
        };
    }
}
