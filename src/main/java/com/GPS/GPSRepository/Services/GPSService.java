package com.GPS.GPSRepository.Services;

import com.GPS.GPSRepository.Commands.GPSDataCommands;
import com.GPS.GPSRepository.Models.GPSData;
import com.GPS.GPSRepository.Repositories.GPSDataRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GPSService {
    final GPSDataRepository gpsDataRepository;
    GPSService(GPSDataRepository gpsDataRepository){
        this.gpsDataRepository=gpsDataRepository;
    }

    public ResponseEntity<GPSData> saveData(GPSDataCommands gpsDataCommands) {

        GPSData gpsData=new GPSData(gpsDataCommands);
        gpsDataRepository.save(gpsData);

        return new ResponseEntity<>(gpsData, HttpStatus.OK);
    }
}
