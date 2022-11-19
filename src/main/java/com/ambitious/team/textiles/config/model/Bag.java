package com.ambitious.team.textiles.config.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Bag {
    @Id
    @GeneratedValue
    private Long id;
    private Long bagId;
    private Double weight;
    private Boolean sort;

    @Override
    public String toString() {
        return "Bag{" +
                "id=" + id +
                ", bagId=" + bagId +
                ", weight=" + weight +
                ", sort=" + sort +
                '}';
    }
}
