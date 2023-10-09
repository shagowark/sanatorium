package com.example.sanatorium.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name="clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private long id;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String firstName;

    @Column()
    private String middleName;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false, unique = true)
    private int passport;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<ResidentialApartmentBooking> residentialApartmentBookings;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<MedicalRoomBooking> medicalRoomBookings;
}

