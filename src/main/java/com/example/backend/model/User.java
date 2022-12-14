package com.example.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="username",nullable = false,length = 50,unique = true)
    private String userName;
    @Column(name="first_name", nullable = false,length = 50)
    private String firstName;
    @Column(name="last_name", nullable = false,length = 50)
    private  String lastName;

    public User (String userName,String firstName,String lastName){
        this.userName=userName;
        this.firstName=firstName;
        this.lastName=lastName;
    }
}
