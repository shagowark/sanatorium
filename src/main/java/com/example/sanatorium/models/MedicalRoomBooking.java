package com.example.sanatorium.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Table(name="medical_room_booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRoomBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private UUID id;

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
    private LocalDateTime startDateTime;

    @Column(nullable = false)
    private LocalDateTime endDateTime;

    @Transient
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public String getFormattedStartDateTime(){
        return startDateTime.format(formatter);
    }

    public String getFormattedEndDateTime(){
        return endDateTime.format(formatter);
    }
}
