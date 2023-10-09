package com.example.sanatorium.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name="procedures")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Procedure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int durationMinutes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedure")
    private Set<MedicalRoomBooking> medicalRoomBookings;
}
