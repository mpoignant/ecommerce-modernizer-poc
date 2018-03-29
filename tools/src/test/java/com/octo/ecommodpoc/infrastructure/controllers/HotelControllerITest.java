package com.octo.ecommodpoc.infrastructure.controllers;

import com.octo.ecommodpoc.domain.Hotel;
import com.octo.ecommodpoc.use_cases.CreateHotelData;
import com.octo.ecommodpoc.use_cases.GetAllHotelData;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HotelController.class)
class HotelControllerITest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CreateHotelData createHotelData;

    @MockBean
    private GetAllHotelData getAllHotelData;

    @Nested
    class GetOnApiHotelEndpointShould {

        @Test
        void return_hotel_data_as_json_array() throws Exception {
            // Given
            Hotel hotel = new Hotel("hotelCode1", true);
            hotel.setId(1337L);
            when(getAllHotelData.getAll()).thenReturn(asList(hotel));

            // When
            ResultActions resultActions = mvc.perform(get("/api/hotel"));

            // Then
            resultActions.andExpect(status().isOk())
                    .andExpect(content().string("[{\"id\":1337,\"hotelCode\":\"hotelCode1\",\"status\":true}]"));
        }
    }

    @Nested
    class PostOnApiHotelEndpointShould {

        @Test
        void return_created_hotel_data_as_json_object() throws Exception {
            // Given
            Hotel hotel = new Hotel("hotelCode1", true);
            hotel.setId(42L);
            when(createHotelData.create(any(Hotel.class))).thenReturn(hotel);

            // When
            ResultActions resultActions = mvc.perform(post("/api/hotel")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"hotelCode\":\"hotelCode1\",\"status\":\"true\"}}"));

            // Then
            resultActions.andExpect(status().isOk()).andExpect(content().string("{\"id\":42,\"hotelCode\":\"hotelCode1\",\"status\":true}"));
        }

        @Test
        void return_bad_request_when_hotel_is_invalid() throws Exception {
            // When
            ResultActions resultActions = mvc.perform(post("/api/hotel")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"value\":\"\"}}"));

            // Then
            resultActions.andExpect(status().isBadRequest());
        }
    }

}