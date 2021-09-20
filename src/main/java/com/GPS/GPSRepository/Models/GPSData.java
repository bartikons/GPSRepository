package com.GPS.GPSRepository.Models;

import com.GPS.GPSRepository.Commands.GPSDataCommands;

import javax.persistence.*;

@Table(name = "gps_data")
@Entity
public class GPSData {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Long id;
    @Column(name = "device_id", nullable = false)
    Long deviceId;

    @Column(name = "latitude", nullable = false)
    Long latitude;

    @Column(name = "longitude", nullable = false)
    Long longitude;

    public GPSData() {
    }

    public GPSData(GPSDataCommands gpsDataCommands) {
        this.deviceId = gpsDataCommands.getDeviceId();
        this.latitude = gpsDataCommands.getLatitude();
        this.longitude = gpsDataCommands.getLongitude();
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}