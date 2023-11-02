package ru.ygtu.student.security.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcConfiguration {
    private final Environment env;

    @Autowired
    public JdbcConfiguration(Environment env) {
        this.env = env;
    }

    @Bean(name = "datasourceUser")
    @Primary
    public DataSource getDataSourceUser() {
        return DataSourceBuilder.create().url(env.getProperty("datasource.url"))
                .username(env.getProperty("user.datasource.username"))
                .password(env.getProperty("user.datasource.password"))
                .driverClassName(env.getProperty("datasource.driver-class-name"))
                .build();
    }

    @Bean(name = "datasourceSeller")
    public DataSource getDataSourceSeller() {
        return DataSourceBuilder.create().url(env.getProperty("datasource.url"))
                .username(env.getProperty("seller.datasource.username"))
                .password(env.getProperty("seller.datasource.password"))
                .driverClassName(env.getProperty("datasource.driver-class-name"))
                .build();
    }

    @Bean(name = "datasourceAdmin")
    public DataSource getDataSourceAdmin() {
        return DataSourceBuilder.create().url(env.getProperty("datasource.url"))
                .username(env.getProperty("admin.datasource.username"))
                .password(env.getProperty("admin.datasource.password"))
                .driverClassName(env.getProperty("datasource.driver-class-name"))
                .build();
    }

    @Bean(name = "jdbcTemplateUser")
    public JdbcTemplate getJdbcTemplateUser() {
        return new JdbcTemplate(getDataSourceUser());
    }

    @Bean(name = "jdbcTemplateSeller")
    public JdbcTemplate getOdbcTemplateSeller() {
        return new JdbcTemplate(getDataSourceSeller());
    }

    @Bean(name = "jdbcTemplateAdmin")
    public JdbcTemplate getJdbcTemplateAdmin() {
        return new JdbcTemplate(getDataSourceAdmin());
    }
}
