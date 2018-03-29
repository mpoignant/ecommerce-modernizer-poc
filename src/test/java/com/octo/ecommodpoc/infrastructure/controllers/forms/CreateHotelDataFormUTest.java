package com.octo.ecommodpoc.infrastructure.controllers.forms;

import com.octo.ecommodpoc.domain.Hotel;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CreateHotelDataFormUTest {

    @Nested
    class ToHotelShould {

        @Test
        void return_new_Hotel_object_with_form_hotelCode() {
            // Given
            String formHotelCode = "some hotelCode";
            CreateHotelDataForm createHotelDataForm = new CreateHotelDataForm();
            createHotelDataForm.setHotelCode(formHotelCode);

            // When
            Hotel hotel = createHotelDataForm.toHotel();

            // Then
            assertThat(hotel.getHotelCode()).isEqualTo(formHotelCode);
        }
    }

}