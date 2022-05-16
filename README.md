# Proyecto WeMentis

## :whale: Manual de despliegue en Docker:

### 1. :purple_circle: Descargar imagen de la BBDD 
docker pull rubentxogg/wementisbbdd:latest

### 2. :green_circle: Descargar imagen del back
docker pull rubentxogg/wementisback:latest

### 3. :large_blue_circle: Descargar imagen del front
docker pull rubentxogg/wementisfront:latest

### 4. :brain: Crear una red interna
docker network create redwementis

### 5. :purple_circle: Ejecutar contenedor de la BBDD
docker run -d --network redwementis --name wementisbbdd -e MYSQL_ROOT_PASSWORD=PracticaRoot -p 3307:3306 rubentxogg/wementisbbdd

### 6. :green_circle: Ejecutar contenedor del back
docker run -d --network redwementis --name wementisback -p 8080:8080 rubentxogg/wementisback

### 7. :large_blue_circle: Ejecutar contenedor del front
docker run -d --network redwementis --name wementisfront -p 8081:8080 rubentxogg/wementisfront

### 8. :crossed_flags: Acceder con el navegador a la url: http://localhost:8081/