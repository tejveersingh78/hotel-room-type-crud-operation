package com.sunglowsys.repository;

import com.sunglowsys.domain.HotelRoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRoomTypeRepository extends JpaRepository<HotelRoomType,Long>{
}
