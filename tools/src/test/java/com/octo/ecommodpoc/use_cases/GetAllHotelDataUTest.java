package com.octo.ecommodpoc.use_cases;

import com.octo.ecommodpoc.MockitoExtension;
import com.octo.ecommodpoc.domain.Hotel;
import com.octo.ecommodpoc.domain.HotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllHotelDataUTest {

    private GetAllHotelData getAllHotelData;

    @Mock
    private HotelRepository hotelRepository;

    @BeforeEach
    void setUp() {
        getAllHotelData = new GetAllHotelData(hotelRepository);
    }

    @Nested
    class GetAllShould {

        @Test
        void return_all_hotel_data() {
            // Given
            List<Hotel> hotelData = asList(new Hotel(), new Hotel());
            when(hotelRepository.findAll()).thenReturn(hotelData);

            // When
            List<Hotel> result = getAllHotelData.getAll();

            // Then
            assertThat(result).isEqualTo(hotelData);
        }
    }

}