package org.example.studylifebalance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Ment {
    @Id
    private Integer mentId;
    private String content;

    public Ment(Integer mentId, String content) {
        this.mentId = mentId;
        this.content = content;
    }

    public Integer getMentId() {
        return mentId;
    }

    public String getContent() {
        return content;
    }
}
