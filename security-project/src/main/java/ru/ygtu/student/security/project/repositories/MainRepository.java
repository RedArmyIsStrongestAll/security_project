package ru.ygtu.student.security.project.repositories;

import ru.ygtu.student.security.project.dto.ProductDto;
import ru.ygtu.student.security.project.dto.ResponseFromQueryDto;
import ru.ygtu.student.security.project.dto.UserDto;

import java.util.List;

public interface MainRepository {
    public UserDto getUserByUsernameAndPassword(String username, String password);

    public List<ProductDto> getListProductAll();

    public List<ProductDto> getListProductByName(String name);

    public List<UserDto> getListUserAll();

    public ResponseFromQueryDto sendQuery(String query, int roleId);
}
