package jpa.study.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {

    @Id
    @Column(name="category_id")
    private Long id;

    @Column
    private String name;
}
