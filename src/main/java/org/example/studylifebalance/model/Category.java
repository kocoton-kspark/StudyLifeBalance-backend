package org.example.studylifebalance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String categoryID;
    private String code;
    private Integer count;
    private String description;

    public Category(String categoryID, String code, Integer count, String description) {
        this.categoryID = categoryID;
        this.code = code;
        this.count = count;
        this.description = description;
    }

    public String getCategoryID() {
        return categoryID;
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
