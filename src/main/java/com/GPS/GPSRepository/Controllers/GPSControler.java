package com.GPS.GPSRepository.Controllers;

import com.GPS.GPSRepository.Commands.GPSDataCommands;
import com.GPS.GPSRepository.Models.GPSData;
import com.GPS.GPSRepository.Services.GPSService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GPSControler {
    final GPSService gpsService;

    GPSControler(GPSService gpsService) {
        this.gpsService = gpsService;
    }

    @PostMapping
    public ResponseEntity<GPSData> saveGPSData(@RequestBody GPSDataCommands gpsDataCommands) {

        return gpsService.saveData(gpsDataCommands);

    }
}
