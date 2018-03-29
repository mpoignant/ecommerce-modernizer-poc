package com.octo.ecommodpoc.domain;

import org.apache.commons.lang3.StringUtils;

public class Hotel {

    private Long id;
    private String hotelCode;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    private Boolean status; // Open(true)/Close(false)


    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Hotel() {
        // Default constructor is required for JPA
    }

    public Hotel(String code, Boolean status) {
        if (StringUtils.isEmpty(code)) {
            throw new InvalidHotelException("hotelCode cannot be null or empty");
        }
        this.hotelCode = code;
        this.status = status;
    }
}
