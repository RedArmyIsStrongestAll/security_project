package ru.ygtu.student.security.project.repositories.imp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import ru.ygtu.student.security.project.config.JdbcTemplateChain;
import ru.ygtu.student.security.project.dto.ProductDto;
import ru.ygtu.student.security.project.dto.ResponseFromQueryDto;
import ru.ygtu.student.security.project.dto.UserDto;
import ru.ygtu.student.security.project.entity.Role;
import ru.ygtu.student.security.project.repositories.MainRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
@Slf4j
public class MainRepositoryImp implements MainRepository {
    private JdbcTemplateChain jdbcTemplateChain;

    @Autowired
    public MainRepositoryImp(JdbcTemplateChain jdbcTemplateChain) {
        this.jdbcTemplateChain = jdbcTemplateChain;
    }

    @Override
    public UserDto getUserByUsernameAndPassword(String username, String password) {
        try {
            String query = "select id, name, last_name, password, login, role_id \n" +
                    "from users \n" +
                    "where login = " + "'" + username + "'" + "\n" +
                    "and password_noencoder = " + "'" + password + "'" + "\n" +
                    "and deleted_at is null;";

            List<UserDto> userDtoList = jdbcTemplateChain.get(Role.ADMIN).query(query, (rs, i) -> UserDto.builder()
                    .id(rs.getInt("id"))
                    .username(rs.getString("login"))
                    .roleId(rs.getInt("role_id"))
                    .name(rs.getString("name"))
                    .lastName(rs.getString("last_name"))
                    .build());
            if (!userDtoList.isEmpty()) {
                return userDtoList.get(0);
            } else {
                return null;
            }
        } catch (DataAccessException e) {
            log.error("Error in method getUserByUsernameAndPassword: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<ProductDto> getListProductAll() {
        try {
            String query = "select id, name, description, price, code_product, deleted_at " +
                    "from products " +
                    "where deleted_at is null";

            return jdbcTemplateChain.get(getRoleId()).query(query, (rs, i) -> ProductDto.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .description(rs.getString("description"))
                    .price(rs.getBigDecimal("price"))
                    .codeProduct(rs.getInt("code_product"))
                    .build());
        } catch (NumberFormatException | DataAccessException e) {
            log.error("Error in method getListProductAll: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<ProductDto> getListProductByName(String name) {
        try {
            String query = "select id, name, description, price, code_product, deleted_at \n" +
                    "from products " +
                    "where deleted_at is null " +
                    "and name ilike " + "'%" + name + "%';";

            return jdbcTemplateChain.get(getRoleId()).query(query, (rs, i) -> ProductDto.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .description(rs.getString("description"))
                    .price(rs.getBigDecimal("price"))
                    .codeProduct(rs.getInt("code_product"))
                    .build());
        } catch (NumberFormatException | DataAccessException e) {
            log.error("Error in method getListProductByName: " + e.getMessage());
            return null;
        }
    }

    private int getRoleId() {
        List<GrantedAuthority> listRole =
                new ArrayList<>(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return Integer.parseInt(listRole.get(0).getAuthority());
    }

    @Override
    public List<UserDto> getListUserAll() {
        try {
            String query = "select id, name, last_name, password, login, role_id " +
                    "from users " +
                    "where deleted_at is null;";

            return jdbcTemplateChain.get(Role.ADMIN).query(query, (rs, i) -> UserDto.builder()
                    .id(rs.getInt("id"))
                    .username(rs.getString("login"))
                    .roleId(rs.getInt("role_id"))
                    .name(rs.getString("name"))
                    .lastName(rs.getString("last_name"))
                    .build());
        } catch (NumberFormatException | DataAccessException e) {
            log.error("Error in method getListProductAll: " + e.getMessage());
            return null;
        }
    }

    @Override
    public ResponseFromQueryDto sendQuery(String query, int roleId) {
        try {
            List<Map<String, Object>> response = jdbcTemplateChain.get(roleId).queryForList(query);
            return new ResponseFromQueryDto(response);
        } catch (DataAccessException e) {
            String errorMessage = e.getMessage();
            String regex = ":(.*?)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(errorMessage);
            if (matcher.find()) {
                String specificErrorMessage = matcher.group(1).trim();
                return new ResponseFromQueryDto(specificErrorMessage);
            } else {
                return new ResponseFromQueryDto(e.getMessage());
            }
        }
    }
}
