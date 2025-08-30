package org.example.studylifebalance.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Category {
    @Id
    @Column(name = "category_id")
    // DB에 맞춰 명시
    private String categoryId;
    private String code;
    private Integer count;
    private String description;


    public Category(String code, Integer count, String description) {
        this.code = code;
        this.count = count;
        this.description = description;
    }


    public String getCategoryId() {
        return categoryId;
    }

    public String getCode() {
        return code;
    }

    public Integer getCount() {
        return count;
    }

    public String getDescription() {
        return description;
    }
}
