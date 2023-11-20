package com.example.sanatorium.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name="medical_room_bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRoomBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private long id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="medical_room_id", nullable = false)
    private MedicalRoom medicalRoom;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="procedure_id", nullable = false)
    private Procedure procedure;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="staff_id", nullable = false)
    private Staff staff;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="client_id", nullable = false)
    private Client client;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;
}
