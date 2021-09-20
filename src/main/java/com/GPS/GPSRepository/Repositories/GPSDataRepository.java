package com.GPS.GPSRepository.Repositories;

import com.GPS.GPSRepository.Models.GPSData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GPSDataRepository extends JpaRepository<GPSData, Long> {
    Optional<GPSData> findGPSDataByDeviceId(Long deviceId);
}