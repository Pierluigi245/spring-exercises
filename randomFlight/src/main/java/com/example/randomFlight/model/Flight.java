package com.example.randomFlight.model;

import jakarta.persistence.*;
import org.hibernate.Length;
import org.hibernate.id.factory.spi.GenerationTypeStrategy;

@Entity
@Table(name="flight")
public class Flight {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id ;

    @Column(nullable = false, length = 150)
    private String description;

    @Column(nullable = false, length = 5)
    private String fromAirport ;

    @Column(nullable = false, length = 3)
    private String toAirport ;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status ;

    private Flight() {

    }

    public Flight(String description, String fromAirport, String toAirport, Status status) {
        this.description = description;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
