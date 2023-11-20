package com.example.sanatorium.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
@Table(name="residential_apartment_bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentialApartmentBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="residential_apartment_id", nullable = false)
    private ResidentialApartment residentialApartment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id", nullable = false)
    private Client client;

    @Column(name = "arrival_date_time",nullable = false)
    private LocalDateTime arrivalDateTime;

    @Column(name = "departure_date_time", nullable = false)
    private LocalDateTime departureDateTime;

    @Transient
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");

    public String getFormattedArrivalDateTime(){
        return arrivalDateTime.format(formatter);
    }

    public String getFormattedDepartureDateTime(){
        return departureDateTime.format(formatter);
    }
}
