package ru.ygtu.student.security.project.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ygtu.student.security.project.dto.ResponseFromQueryDto;
import ru.ygtu.student.security.project.repositories.MainRepository;
import ru.ygtu.student.security.project.services.QueryService;

@Service
public class QueryServiceImp implements QueryService {
    private final MainRepository mainRepository;

    @Autowired
    public QueryServiceImp(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    @Override
    public ResponseFromQueryDto sendQuery(String query, int roleId) {
        return mainRepository.sendQuery(query, roleId);
    }
}
