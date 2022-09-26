package jpa.study.entity;

import lombok.Setter;
import javax.persistence.*;
@Setter
@Entity
public class Item {

    @Id
    @GeneratedValue
    @Column(name="item_id")
    private Long id;

    @Column
    private String name;

//    @ManyToOne
//    @JoinColumn(name="category_id")
//    private Category category;
}
