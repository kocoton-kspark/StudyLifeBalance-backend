package main.model;

@Entity
public class Category {
    @Id
    private String categoryID;
    private String name;
    private Integer count;
    private String description;

    public Category(String categoryID, String name, Integer count, String description) {
        this.categoryID = categoryID;
        this.name = name;
        this.count = count;
        this.description = description;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }

    public String getDescription() {
        return description;
    }
}
