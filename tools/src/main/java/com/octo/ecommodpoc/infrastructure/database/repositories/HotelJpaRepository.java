package com.octo.ecommodpoc.infrastructure.database.repositories;

import com.octo.ecommodpoc.domain.Hotel;
import com.octo.ecommodpoc.domain.HotelRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelJpaRepository extends JpaRepository<Hotel, Long>, HotelRepository {
}
