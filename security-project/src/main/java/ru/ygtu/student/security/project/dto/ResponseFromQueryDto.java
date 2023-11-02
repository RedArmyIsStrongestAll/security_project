package ru.ygtu.student.security.project.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
public class ResponseFromQueryDto {
    private List<Map<String, Object>> response;
    private String error;

    public ResponseFromQueryDto(List<Map<String, Object>> response) {
        this.response = response;
    }

    public ResponseFromQueryDto(String error) {
        this.error = error;
    }
}
