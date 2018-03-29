package com.octo.ecommodpoc.use_cases;

import com.octo.ecommodpoc.MockitoExtension;
import com.octo.ecommodpoc.domain.Hotel;
import com.octo.ecommodpoc.domain.HotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateHotelDataUTest {

    private CreateHotelData createHotelData;

    @Mock
    private HotelRepository hotelRepository;

    @BeforeEach
    void setUp() {
        createHotelData = new CreateHotelData(hotelRepository);
    }

    @Nested
    class CreateShould {

        @Test
        void return_save_and_return_saved_hotel_data() {
            // Given
            Hotel hotel = new Hotel("some hotel value", true);
            hotel.setId(42L);
            when(hotelRepository.save(hotel)).thenReturn(hotel);

            // When
            Hotel result = createHotelData.create(hotel);

            // Then
            assertThat(result).isEqualTo(hotel);
        }
    }

}