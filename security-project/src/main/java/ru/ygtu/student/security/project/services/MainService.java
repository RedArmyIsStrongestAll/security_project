package ru.ygtu.student.security.project.services;

import ru.ygtu.student.security.project.dto.ProductDto;
import ru.ygtu.student.security.project.dto.UserDto;

import java.util.List;

public interface MainService {
    public List<ProductDto> getListProductAll();

    public List<ProductDto> getListProductByName(String name);

    public List<UserDto> getListUserAll();
}
