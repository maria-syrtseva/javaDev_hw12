package spacetravel.entity;

import javax.persistence.*;

@Entity
public class Planet {
    @Id
    @Column(length = 10)
    private String id;

    @Column(length = 500, nullable = false)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}