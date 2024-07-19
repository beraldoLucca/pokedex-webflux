package com.webflux.pokedex.app.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Pokemon")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pokemon {

    @Id
    private String id;

    @Column("name")
    private String name;

    @Column("category")
    private String category;

    @Column("skill")
    private String skill;

    @Column("weight")
    private Double weight;
}
