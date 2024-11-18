package com.github.nogueiralegacy.distancia;

public class Calculadora {

    private static final double RAIO_TERRA = 6371.0;

    public static double getRaioTerra() {
        return RAIO_TERRA;
    }
    
    public static final double Haversine(Coordenada coordenada1, Coordenada coordenada2, double raio) {

        double latitude1 = Math.toRadians(coordenada1.getLatitude());
        double longitude1 = Math.toRadians(coordenada1.getLongitude());
        double latitude2 = Math.toRadians(coordenada2.getLatitude());
        double longitude2 = Math.toRadians(coordenada2.getLongitude());
    
        double deltaLatitude = latitude2 - latitude1;
        double deltaLongitude = longitude2 - longitude1;
    
        double a = Math.pow(Math.sin(deltaLatitude / 2), 2)
                 + Math.cos(latitude1) * Math.cos(latitude2) * Math.pow(Math.sin(deltaLongitude / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    
        double distancia = raio * c;
    
        return Math.round(distancia);
    }
    
}
