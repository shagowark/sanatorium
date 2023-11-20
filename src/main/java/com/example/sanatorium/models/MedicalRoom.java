package com.example.sanatorium.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name="medical_rooms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private long id;

    @Column(nullable = false)
    private int number;

    @Column()
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalRoom")
    private Set<MedicalRoomBooking> medicalRoomBookings;
}