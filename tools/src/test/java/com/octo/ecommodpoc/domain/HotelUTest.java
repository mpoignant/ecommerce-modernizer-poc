package com.octo.ecommodpoc.domain;

import com.octo.ecommodpoc.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@ExtendWith(MockitoExtension.class)
class HotelUTest {

    private String hotelCode;

    @BeforeEach
    void setUp() {
        hotelCode = "some hotel hotelCode";
    }

    @Nested
    class ConstructorShould {

        @Test
        void fail_when_hotelCode_is_null() {
            // Given
            hotelCode = null;

            // When
            Throwable throwable = catchThrowable(() -> new Hotel(hotelCode, true));

            // Then
            assertThat(throwable).isInstanceOf(InvalidHotelException.class)
                    .hasMessage("hotelCode cannot be null or empty");
        }

        @Test
        void fail_when_hotelCode_is_empty() {
            // Given
            hotelCode = "";

            // When
            Throwable throwable = catchThrowable(() -> new Hotel(hotelCode, true));

            // Then
            assertThat(throwable).isInstanceOf(InvalidHotelException.class)
                    .hasMessage("hotelCode cannot be null or empty");
        }
    }

}