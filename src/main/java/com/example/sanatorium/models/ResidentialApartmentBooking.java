package com.example.sanatorium.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="residential_apartment_bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentialApartmentBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private long id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="residentialApartment_id", nullable = false)
    private ResidentialApartment residentialApartment;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="client_id", nullable = false)
    private Client client;

    @Column(nullable = false)
    private LocalDateTime arrivalDateTime;

    @Column(nullable = false)
    private LocalDateTime departureDateTime;

}
