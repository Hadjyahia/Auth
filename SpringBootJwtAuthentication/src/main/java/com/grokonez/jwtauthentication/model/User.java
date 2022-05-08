package com.grokonez.jwtauthentication.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;


@Getter
@Setter
@Entity
@Table(name = "users", uniqueConstraints = {

        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String username;

    @NaturalId

    private String email;


    private String phone;

    private String password;

    @Enumerated(EnumType.STRING)
    private Region region;

    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

    private Boolean enabled=false;

    private String genre;

    private int age;

    private String poids;

    private String taille;

    private String typeSang;

    private int nbDemandeSang=0;

    private int nbDonSang=0;

    private int nbPoints=0;

    @ManyToMany
    @JoinTable(name = "user_roles", 
    	joinColumns = @JoinColumn(name = "user_id"), 
    	inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {}

    public User(String username, String email, String password) {

        this.username = username;
        this.email = email;
        this.password = password;
    }
}