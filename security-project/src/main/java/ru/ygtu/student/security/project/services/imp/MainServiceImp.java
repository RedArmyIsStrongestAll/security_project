package ru.ygtu.student.security.project.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ygtu.student.security.project.dto.ProductDto;
import ru.ygtu.student.security.project.dto.UserDto;
import ru.ygtu.student.security.project.repositories.MainRepository;
import ru.ygtu.student.security.project.services.MainService;

import java.util.List;

@Service
public class MainServiceImp implements MainService {
    private final MainRepository mainRepository;

    @Autowired
    public MainServiceImp(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    @Override
    public List<ProductDto> getListProductAll() {
        return mainRepository.getListProductAll();
    }

    @Override
    public List<ProductDto> getListProductByName(String name) {
        return mainRepository.getListProductByName(name);
    }

    @Override
    public List<UserDto> getListUserAll() {
        return mainRepository.getListUserAll();
    }


}
