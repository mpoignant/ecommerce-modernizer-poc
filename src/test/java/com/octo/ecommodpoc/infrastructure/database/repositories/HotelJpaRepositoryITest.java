package com.octo.ecommodpoc.infrastructure.database.repositories;

import com.octo.ecommodpoc.domain.Hotel;
import com.octo.ecommodpoc.domain.HotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class HotelJpaRepositoryITest {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    private Hotel hotel;

    @BeforeEach
    void setUp() {
        hotel = new Hotel("hotel", true);
    }

    @Test
    void save_should_persist_hotel_with_auto_incremented_id() throws Exception {
        // Given
        Hotel secondHotel = new Hotel("secondHotel", false);

        Hotel firstPersist = hotelRepository.save(hotel);

        // When
        Hotel secondPersist = hotelRepository.save(secondHotel);

        // Then
        assertThat(secondPersist.getId()).isEqualTo(firstPersist.getId() + 1);
    }

    @Test
    void save_should_throw_DataIntegrityViolationException_when_value_is_null() {
        // Given
        hotel.setHotelCode(null);

        // When
        Throwable throwable = catchThrowable(() -> hotelRepository.save(hotel));

        // Then
        assertThat(throwable).isInstanceOf(DataIntegrityViolationException.class);
        assertThat(throwable).hasStackTraceContaining("value");
    }

    @Test
    void findAllByUserId_should_return_all_dummy() throws Exception {
        // Given
        Hotel secondDummy = new Hotel("secondHotel", true);
        testEntityManager.persist(hotel);
        testEntityManager.persist(secondDummy);

        // When
        List<Hotel> found = hotelRepository.findAll();

        // Then
        assertThat(found).containsExactly(hotel, secondDummy);
    }

}