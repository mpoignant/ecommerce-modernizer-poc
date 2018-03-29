package com.octo.ecommodpoc.domain;

import java.util.List;

public interface HotelRepository {

    Hotel save(Hotel hotel);

    List<Hotel> findAll();

    Hotel findByHotelCode(String hotelCode);
}
