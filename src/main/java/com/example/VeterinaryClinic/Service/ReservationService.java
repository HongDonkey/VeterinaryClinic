package com.example.VeterinaryClinic.Service;

import com.example.VeterinaryClinic.DTO.ReservationDTO;

public interface ReservationService {
	int insertReservation(ReservationDTO reservationDTO);
	String generateResvNo();
}
