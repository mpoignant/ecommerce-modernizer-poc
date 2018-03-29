package com.octo.ecommodpoc.infrastructure.controllers;

import com.octo.ecommodpoc.domain.Hotel;
import com.octo.ecommodpoc.infrastructure.controllers.forms.CreateHotelDataForm;
import com.octo.ecommodpoc.use_cases.CreateHotelData;
import com.octo.ecommodpoc.use_cases.GetAllHotelData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
public class HotelController {

    private final CreateHotelData createHotelData;
    private final GetAllHotelData getAllHotelData;

    public HotelController(CreateHotelData createHotelData, GetAllHotelData getAllHotelData) {
        this.createHotelData = createHotelData;
        this.getAllHotelData = getAllHotelData;
    }

    @GetMapping(value = "/api/hotel", produces = "application/json")
    public List<Hotel> getAllHotelData() {
        return getAllHotelData.getAll();
    }

    @GetMapping(value = "/api/hotel/{hotelCode}", produces = "application/json")
    public Hotel getHotelData(@PathVariable String hotelCode) { return getAllHotelData.getHotel(hotelCode); }

    @PostMapping(value = "/api/hotel", produces = "application/json")
    public Hotel createHotelData(@RequestBody CreateHotelDataForm createHotelDataForm) {
        return createHotelData.create(createHotelDataForm.toHotel());
    }
}
