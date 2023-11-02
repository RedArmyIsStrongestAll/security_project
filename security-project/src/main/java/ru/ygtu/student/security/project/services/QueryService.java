package ru.ygtu.student.security.project.services;

import ru.ygtu.student.security.project.dto.ResponseFromQueryDto;

public interface QueryService {
    public ResponseFromQueryDto sendQuery(String query, int roleId);
}
