# Distância
Este projeto tem como objetivo calcular a distância entre dois pontos 
na superfície da Terra.

## Conceitos Estruturantes
1. **Latitude**: Medida, em graus, que representa a posição de qualquer 
ponto da superfície terrestre em relação à Linha do Equador. Os valores 
de latitude variam de 0° a 90° para o Norte ou de 0° a -90° para o Sul.
   
2. **Longitude**: Medida, em graus, que representa a posição de qualquer 
ponto da superfície terrestre em relação ao Meridiano de Greenwich. Os 
valores de longitude variam de 0° a 180° para o Leste ou de 0° a -180° 
para o Oeste.

## Considerações
1. Este projeto considera a Terra como uma esfera perfeita, com raio 
(distância do centro da esfera até qualquer ponto de sua superfície) 
de **6.371 km**, [valor do raio médio da Terra divulgado pela NASA](https://nssdc.gsfc.nasa.gov/planetary/factsheet/earthfact.html).
2. Este projeto faz uso da [fórmula de Haversine](https://www.igismap.com/haversine-formula-calculate-geographic-distance-earth/). 
A fórmula de Haversine é usada para calcular a menor distância entre 
dois pontos na superfície de uma esfera perfeita, baseada em duas 
latitudes e longitudes. 
