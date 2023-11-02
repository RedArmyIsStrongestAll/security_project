package ru.ygtu.student.security.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.ygtu.student.security.project.entity.Role;

@Component
public class JdbcTemplateChain {
    private JdbcTemplate jdbcTemplateUser;
    private JdbcTemplate jdbcTemplateSeller;
    private JdbcTemplate jdbcTemplateAdmin;

    @Autowired
    public JdbcTemplateChain(@Qualifier("jdbcTemplateUser") JdbcTemplate jdbcTemplateUser,
                             @Qualifier("jdbcTemplateSeller") JdbcTemplate jdbcTemplateSeller,
                             @Qualifier("jdbcTemplateAdmin") JdbcTemplate jdbcTemplateAdmin) {
        this.jdbcTemplateUser = jdbcTemplateUser;
        this.jdbcTemplateSeller = jdbcTemplateSeller;
        this.jdbcTemplateAdmin = jdbcTemplateAdmin;
    }

    public JdbcTemplate get(Role role) {
        switch (role.getId()) {
            case 1:
                return jdbcTemplateUser;
            case 2:
                return jdbcTemplateSeller;
            case 3:
                return jdbcTemplateAdmin;
            default:
                return null;
        }
    }

    public JdbcTemplate get(int role) {
        switch (role) {
            case 1:
                return jdbcTemplateUser;
            case 2:
                return jdbcTemplateSeller;
            case 3:
                return jdbcTemplateAdmin;
            default:
                return null;
        }
    }

}
