package com.GPS.GPSRepository.Services;

import com.GPS.GPSRepository.Commands.GPSDataCommands;
import com.GPS.GPSRepository.Models.GPSData;
import com.GPS.GPSRepository.Repositories.GPSDataRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class GPSService {
    final GPSDataRepository gpsDataRepository;

    GPSService(GPSDataRepository gpsDataRepository) {
        this.gpsDataRepository = gpsDataRepository;
    }

    public ResponseEntity<GPSData> saveData(GPSDataCommands gpsDataCommands) {
        if (gpsDataCommands.getDeviceId() == null) {

            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        } else if (gpsDataCommands.getLatitude() == null) {

            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        } else if (gpsDataCommands.getLongitude() == null) {

            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        GPSData gpsData = new GPSData(gpsDataCommands);

        gpsDataRepository.save(gpsData);

        return new ResponseEntity<>(gpsData, HttpStatus.OK);
    }
}
