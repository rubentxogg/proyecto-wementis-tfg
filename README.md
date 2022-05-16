# Proyecto WeMentis

## :whale: Manual de despliegue en Docker:

### :purple_circle: 1. Descargar imagen de la BBDD 
docker pull rubentxogg/wementisbbdd:latest

### :green_circle: 2. Descargar imagen del back
docker pull rubentxogg/wementisback:latest

### :large_blue_circle: 3. Descargar imagen del front
docker pull rubentxogg/wementisfront:latest

### :brain: 4. Crear una red interna
docker network create redwementis

### :purple_circle: 5. Ejecutar contenedor de la BBDD
docker run -d --network redwementis --name wementisbbdd -e MYSQL_ROOT_PASSWORD=PracticaRoot -p 3307:3306 rubentxogg/wementisbbdd

### :green_circle: 6. Ejecutar contenedor del back
docker run -d --network redwementis --name wementisback -p 8080:8080 rubentxogg/wementisback

### :large_blue_circle: 7. Ejecutar contenedor del front
docker run -d --network redwementis --name wementisfront -p 8081:8080 rubentxogg/wementisfront

### :crossed_flags: 8. Acceder con el navegador a la url: http://localhost:8081/