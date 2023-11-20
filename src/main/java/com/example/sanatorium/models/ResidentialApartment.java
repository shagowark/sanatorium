package com.example.sanatorium.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name="residential_apartments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentialApartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "rooms_number", nullable = false)
    private int roomsNumber;

    @Column(name = "price_one_night", nullable = false)
    private int priceOneNight;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "residentialApartment")
    private Set<ResidentialApartmentBooking> residentialApartmentBookings;
}