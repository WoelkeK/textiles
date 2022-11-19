package com.ambitious.team.textiles.config.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Receiver {
    @Id
    @GeneratedValue
    private Long id;
    private String receiverId;
    private String name;
    private String address;
    private int carbonFootprint;
    private int tokens;

    @Override
    public String toString() {
        return "Receiver{" +
                "id=" + id +
                ", ReceiverId= '" + receiverId + '\'' +
                ", name= '" + name + '\'' +
                ", adrress='" + address + '\'' +
                ", carbonFootprint= " + carbonFootprint +
                ", tokens=" + tokens +
                '}';
    }
}
