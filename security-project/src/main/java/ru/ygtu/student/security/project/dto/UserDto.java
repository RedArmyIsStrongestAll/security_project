package ru.ygtu.student.security.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private int id;
    @JsonProperty("login")
    private String username;
    @JsonProperty("role_id")
    private int roleId;
    private String name;
    @JsonProperty("last_name")
    private String lastName;
}
