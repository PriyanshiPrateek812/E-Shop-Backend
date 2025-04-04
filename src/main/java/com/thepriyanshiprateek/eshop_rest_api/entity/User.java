package com.thepriyanshiprateek.eshop_rest_api.entity;

import jakarta.persistence.*;

import java.util.Set;

public class User {
    @Column(nullable = false, unique = true)
    private String Username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name="role_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Role> roles;
}
