package com.example.sanatorium.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="residential_apartment")
@Data
@AllArgsConstructor
@NoArgsConstructor

@EqualsAndHashCode(exclude = {"residentialApartmentBookings"})
@ToString(exclude = {"residentialApartmentBookings"})
public class ResidentialApartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "rooms_number", nullable = false)
    private int roomsNumber;

    @Column(name = "price_one_night", nullable = false)
    private int priceOneNight;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "residentialApartment")
    private Set<ResidentialApartmentBooking> residentialApartmentBookings;
}
