package com.octo.ecommodpoc.infrastructure.controllers.forms;

import com.octo.ecommodpoc.domain.Hotel;

public class CreateHotelDataForm {

    private String hotelCode;
    private Boolean status;

    public Hotel toHotel() {
        return new Hotel(hotelCode, status);
    }

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
