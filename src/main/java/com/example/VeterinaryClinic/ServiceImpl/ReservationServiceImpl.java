package com.example.VeterinaryClinic.ServiceImpl;

import org.springframework.stereotype.Service;

import com.example.VeterinaryClinic.DTO.ReservationDTO;
import com.example.VeterinaryClinic.Mapper.ReservationMapper;
import com.example.VeterinaryClinic.Service.ReservationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationMapper reservationMapper;

    @Override
    public int insertReservation(ReservationDTO reservationDTO) {
    	System.out.println(reservationDTO);
        return reservationMapper.insertReservation(reservationDTO);
    }
    public String generateResvNo() {
    	return reservationMapper.generateResvNo();
    };
}
