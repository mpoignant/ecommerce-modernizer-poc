package com.octo.ecommodpoc.use_cases;

import com.octo.ecommodpoc.domain.Hotel;
import com.octo.ecommodpoc.domain.HotelRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GetAllHotelData {

    private final HotelRepository hotelRepository;

    public GetAllHotelData(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    public Hotel getHotel(String hotelCode) {
        return hotelRepository.findByHotelCode(hotelCode);
    }

}
