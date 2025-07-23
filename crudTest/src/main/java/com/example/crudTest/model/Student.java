package com.example.crudTest.model;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100 , nullable = false)
    private String name;

    @Column(length = 100 , nullable = false)
    private String surname;

    @Column(nullable = false)
    private boolean isWorking;
}