package com.ambitious.team.textiles.config.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue
    private Long id;
    private String idClient;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private int token;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", idClient='" + idClient + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}