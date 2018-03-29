package com.octo.ecommodpoc.infrastructure.controllers;

import com.octo.ecommodpoc.MockitoExtension;
import com.octo.ecommodpoc.domain.Hotel;
import com.octo.ecommodpoc.infrastructure.controllers.forms.CreateHotelDataForm;
import com.octo.ecommodpoc.use_cases.CreateHotelData;
import com.octo.ecommodpoc.use_cases.GetAllHotelData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HotelControllerUTest {

    private HotelController hotelController;

    @Mock
    private CreateHotelData createHotelData;

    @Mock
    private GetAllHotelData getAllHotelData;

    @BeforeEach
    void setUp() {
        hotelController = new HotelController(createHotelData, getAllHotelData);
    }

    @Nested
    class GetAllHotelDataShould {

        @Test
        void return_hotel_data() {
            // Given
            List<Hotel> hotelData = asList(new Hotel());
            when(getAllHotelData.getAll()).thenReturn(hotelData);

            // When
            List<Hotel> result = hotelController.getAllHotelData();

            // Then
            assertThat(result).isEqualTo(hotelData);
        }
    }

    @Nested
    class CreateHotelDataShould {

        @Test
        void create_hotel_using_form_hotelCode() {
            // Given
            String formHotelCode = "some hotel hotelCode";
            CreateHotelDataForm createHotelDataForm = new CreateHotelDataForm();
            createHotelDataForm.setHotelCode(formHotelCode);

            // When
            hotelController.createHotelData(createHotelDataForm);

            // Then
            ArgumentCaptor<Hotel> argumentCaptor = ArgumentCaptor.forClass(Hotel.class);
            verify(createHotelData).create(argumentCaptor.capture());
            Hotel hotelToCreate = argumentCaptor.getValue();
            assertThat(hotelToCreate.getHotelCode()).isEqualTo(formHotelCode);
        }

        @Test
        void return_created_hotel_data() {
            // Given
            Hotel hotel = new Hotel();
            CreateHotelDataForm createHotelDataForm = new CreateHotelDataForm();
            createHotelDataForm.setHotelCode("some hotel hotelCode");
            when(createHotelData.create(any(Hotel.class))).thenReturn(hotel);

            // When
            Hotel result = hotelController.createHotelData(createHotelDataForm);

            // Then
            assertThat(result).isEqualTo(hotel);
        }
    }

}