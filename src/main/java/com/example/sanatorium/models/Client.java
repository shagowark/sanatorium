package com.example.sanatorium.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="client")
@Data
@AllArgsConstructor
@NoArgsConstructor

@EqualsAndHashCode(exclude = {"residentialApartmentBookings", "medicalRoomBookings"})
@ToString(exclude = {"residentialApartmentBookings", "medicalRoomBookings"})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "passport",nullable = false, unique = true)
    private long passport;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<ResidentialApartmentBooking> residentialApartmentBookings;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<MedicalRoomBooking> medicalRoomBookings;
}

