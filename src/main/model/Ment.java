package main.model;

@Entity
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
