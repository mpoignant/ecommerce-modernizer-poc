package com.octo.ecommodpoc.use_cases;


import com.octo.ecommodpoc.domain.Hotel;
import com.octo.ecommodpoc.domain.HotelRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CreateHotelData {

    private final HotelRepository hotelRepository;

    public CreateHotelData(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}
