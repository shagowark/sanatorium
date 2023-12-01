package com.example.sanatorium.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column
    private String name;

//    @ManyToMany(mappedBy = "roles", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    private Set<User> roles;
    //TODO возможно доп. табличку (user-role)? с many-to-many почему-то ломается
}
