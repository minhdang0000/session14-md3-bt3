package com.example.security.entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long id;
    private String fullName;
    private double salary;
}
