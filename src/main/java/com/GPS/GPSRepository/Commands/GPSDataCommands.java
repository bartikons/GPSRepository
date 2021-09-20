package com.GPS.GPSRepository.Commands;

public class GPSDataCommands {
    Long deviceId;
    Long latitude;
    Long longitude;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
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

    @Override
    public String toString() {
        return "GPSDataCommands{" +
                "deviceId=" + deviceId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
