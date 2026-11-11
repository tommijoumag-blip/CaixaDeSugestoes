package br.com.etecalbertoferes.CaixaDeSugestoes.infrastructure.persistence;

import jakarta.persistence.*;
@Entity
@Table(name = "courses")
public class CourseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true, length = 255)
    String name;
    Long getId() { return id; }
    String getName() { return name; }
    protected CourseEntity() {}
}