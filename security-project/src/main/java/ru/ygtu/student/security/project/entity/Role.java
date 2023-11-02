package ru.ygtu.student.security.project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    USER(1),
    SELLER(2),
    ADMIN(3);
    private final int id;
}
