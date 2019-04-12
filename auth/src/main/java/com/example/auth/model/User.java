package com.example.auth.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "email")
    @Email(message = "please provide a valid email")
    @NotEmpty(message = "please provide an email")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "password should have at least 5 chars")
    @NotEmpty(message = "please provide a password")
    private String password;
    @Column(name = "name")
    @NotEmpty(message =  "please enter yoyr name")
    private String name;
    @Column(name = "last_name")
    @NotEmpty(message = "please provide your last name")
    private String lastName;
    @Column(name = "active")
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
