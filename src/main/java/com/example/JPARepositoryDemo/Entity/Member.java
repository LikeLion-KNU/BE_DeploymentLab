package com.example.JPARepositoryDemo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    private Long studentId;
    private String name;
    private int age;
    private String gender;
    private String school;
    private String department;
    private String grade;
}
