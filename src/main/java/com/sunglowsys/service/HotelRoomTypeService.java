package com.sunglowsys.service;

import com.sunglowsys.domain.HotelRoomType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface HotelRoomTypeService {

        HotelRoomType save(HotelRoomType hotelRoomType);

        HotelRoomType update(HotelRoomType hotelRoomType);

        Page<HotelRoomType> findAll(Pageable pageable);

        Optional<HotelRoomType> findById(Long id);

        void delete(Long id);
}
