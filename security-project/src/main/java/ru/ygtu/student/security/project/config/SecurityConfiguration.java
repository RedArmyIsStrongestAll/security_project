package ru.ygtu.student.security.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import ru.ygtu.student.security.project.entity.Role;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                //swagger
                .antMatchers("/swag").permitAll()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/swagger-ui/**", "/swagger-ui/**.css",
                        "/swagger-ui/**.js", "/swagger-ui/**.html").permitAll()
                //open url
                .antMatchers("/fail/log").permitAll()
                .antMatchers("/query").permitAll()
                .antMatchers("/fail/main/reboot").permitAll()
                //close url
                .antMatchers("/fail/admin/**").hasAuthority(String.valueOf(Role.ADMIN.getId()))
                .anyRequest().authenticated();
        return http.build();
    }
}
