package com.example.trip_itinerary.itinerary.controller;

import com.example.trip_itinerary.itinerary.dto.request.*;
import com.example.trip_itinerary.itinerary.dto.request.update.AccommodationPatchRequest;
import com.example.trip_itinerary.itinerary.dto.request.update.ItineraryPatchRequest;
import com.example.trip_itinerary.itinerary.dto.request.update.StayPatchRequest;
import com.example.trip_itinerary.itinerary.dto.request.update.TransportPatchRequest;
import com.example.trip_itinerary.itinerary.service.ItineraryService;
import com.example.trip_itinerary.trip.exception.InvalidDateException;
import com.example.trip_itinerary.trip.exception.TripErrorCode;
import com.example.trip_itinerary.util.DateUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trips")
public class ItineraryController {

    private final ItineraryService itineraryService;

    public ItineraryController(ItineraryService itineraryService){
        this.itineraryService = itineraryService;
    }

    @PostMapping("/{id}/itinerary")
    public Long saveItinerary(@PathVariable Long id, @RequestBody @Validated ItinerarySaveRequest staySaveRequest){
        return itineraryService.saveItinerary(id, staySaveRequest);
    }

    @PatchMapping("/itineraries/{id}")
    public Long patchItinerary(@PathVariable Long id, @RequestBody @Validated ItineraryPatchRequest itineraryPatchRequest){
        return itineraryService.patchItinerary(id, itineraryPatchRequest);
    }
}
