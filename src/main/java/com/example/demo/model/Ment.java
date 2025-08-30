package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ment")
public class Ment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    // 기본 생성자
    public Ment() {}

    // 생성자
    public Ment(String content) {
        this.content = content;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Ment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
