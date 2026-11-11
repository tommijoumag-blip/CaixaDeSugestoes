package br.com.etecalbertoferes.CaixaDeSugestoes.infrastructure.persistence;

import jakarta.persistence.*;
@Entity
@Table(name = "categories")
public class CategoryEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true, length = 255)
    String name;
    Long getId() { return id; }
    String getName() { return name; }
    protected CategoryEntity() {}
}