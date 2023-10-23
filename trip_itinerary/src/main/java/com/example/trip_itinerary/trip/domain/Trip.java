package com.example.trip_itinerary.trip.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Trip {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "is_domestic", nullable = false)
    private boolean isDomestic;

    protected Trip(){
    }

    private Trip(Long id, String name, LocalDateTime startDate, LocalDateTime endDate, boolean isDomestic) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isDomestic = isDomestic;
    }

    public static Trip of(Long id, String name, LocalDateTime startDate, LocalDateTime endDate, boolean isDomestic) {
        return new Trip(id, name, startDate, endDate, isDomestic);
    }

}