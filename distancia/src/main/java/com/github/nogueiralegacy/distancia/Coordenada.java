package com.github.nogueiralegacy.distancia;

public class Coordenada {
    private double latitude;
    private double longitude; 

    public Coordenada(double latitude, double longitude) {
        if (latitude < -90) {
            throw new CoordenadaInvalidaException("Latitude inválida, menor que -90°");
        } else if (latitude > 90) {
            throw new CoordenadaInvalidaException("Latitude inválida, maior que 90°");
        }

        if (longitude < -180) {
            throw new CoordenadaInvalidaException("Longitude inválida, menor que -180°");
        } else if (longitude > 180) {
            throw new CoordenadaInvalidaException("Longitude inválida, maior que 180°");
        }

        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
