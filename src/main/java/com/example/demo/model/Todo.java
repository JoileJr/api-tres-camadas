package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Data
@Table(name = "todo")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String item;
}
