package ru.ygtu.student.security.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.ygtu.student.security.project.repositories.MainRepository;
import ru.ygtu.student.security.project.services.SystemService;

@SpringBootApplication
public class SecurityProjectApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SecurityProjectApplication.class, args);
        var service = context.getBean(SystemService.class);
        service.rebootBd();
    }
}
