package com.sunglowsys.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hotel_room_type_1")
public class HotelRoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer hotel_id;

    @Column(nullable = false)
    private Integer room_type_id;

    public HotelRoomType() {
        System.out.println("HotelRoomType object is created successfully : ");
    }

    public HotelRoomType(Long id, Integer hotel_id, Integer room_type_id) {
        this.id = id;
        this.hotel_id = hotel_id;
        this.room_type_id = room_type_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Integer getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(Integer room_type_id) {
        this.room_type_id = room_type_id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelRoomType that = (HotelRoomType) o;
        return Objects.equals(id, that.id) && Objects.equals(hotel_id, that.hotel_id) && Objects.equals(room_type_id, that.room_type_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hotel_id, room_type_id);
    }

    @Override
    public String
    toString() {
        return "HotelRoomType{" +
                "id=" + id +
                ", hotel_id=" + hotel_id +
                ", room_type_id=" + room_type_id +
                '}';
    }
}
