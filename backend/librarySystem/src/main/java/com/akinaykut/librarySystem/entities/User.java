package com.akinaykut.librarySystem.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    long id;
    String name;
    String surname;
    String password;
    int phoneNumber;
}
