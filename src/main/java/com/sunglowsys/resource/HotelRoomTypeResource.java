package com.sunglowsys.resource;

import com.sunglowsys.domain.HotelRoomType;
import com.sunglowsys.resource.util.BadRequestException;
import com.sunglowsys.service.HotelRoomTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HotelRoomTypeResource {

    private final Logger log = LoggerFactory.getLogger(HotelRoomTypeResource.class);


    private final HotelRoomTypeService hotelRoomTypeService;

    public HotelRoomTypeResource(HotelRoomTypeService hotelRoomTypeService) {
        this.hotelRoomTypeService = hotelRoomTypeService;
    }

    @PostMapping("/hotel-room-types")
    public ResponseEntity<HotelRoomType> createHotelRoomType(@RequestBody HotelRoomType hotelRoomType) throws URISyntaxException{
        log.debug("REST request to create HotelRoomType : {}",hotelRoomType);
        if(hotelRoomType.getId() != null){
            throw new BadRequestException("Id should be null in create api call ");
        }
        HotelRoomType result = hotelRoomTypeService.save(hotelRoomType);
        return ResponseEntity
                .created(new URI("/api/hotel-room-types/" + result.getId()))
                .body(result);
    }

    @PutMapping("/hotel-room-types")
    public ResponseEntity<HotelRoomType> updateHotelRoomType(@RequestBody HotelRoomType hotelRoomType) throws URISyntaxException {
        log.debug("REST request to update HotelRoomType :{} " ,hotelRoomType);
        if(hotelRoomType.getId() == null){
            throw new BadRequestException("Id should not be null in update api call");
        }
        HotelRoomType result = hotelRoomTypeService.update(hotelRoomType);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/hotel-room-types")
    public ResponseEntity<List<HotelRoomType>> getAllHotelRoomType(Pageable pageable){
        log.debug("REST request to get HotelRoomType : {} ",pageable.toString());
        Page<HotelRoomType> result = hotelRoomTypeService.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(result.getContent());
    }

    @GetMapping("/hotel-room-types/{id}")
    public ResponseEntity<HotelRoomType> getHotelRoomType(@PathVariable Long id){
        log.debug("REST request to get HotelRoomType : {} ", id);
        Optional<HotelRoomType> result = hotelRoomTypeService.findById(id);
        return ResponseEntity
                .ok()
                .body(result.get());
    }

    @DeleteMapping("/hotel-room-types/{id}")
    public ResponseEntity<Void> deleteHotelRoomType(@PathVariable Long id){
        hotelRoomTypeService.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }


}
