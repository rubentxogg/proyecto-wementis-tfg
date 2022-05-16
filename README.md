# Proyecto WeMentis

## :whale: Manual de despliegue en Docker:

### 1. Descargar imagen de la BBDD 
docker pull rubentxogg/wementisbbdd:latest

### 2. Descargar imagen del back
docker pull rubentxogg/wementisback:latest

### 3. Descargar imagen del front
docker pull rubentxogg/wementisfront:latest

### :brain: 4. Crear una red interna
docker network create redwementis

### 5. Ejecutar contenedor de la BBDD
docker run -d --network redwementis --name wementisbbdd -e MYSQL_ROOT_PASSWORD=PracticaRoot -p 3307:3306 rubentxogg/wementisbbdd

### 6. Ejecutar contenedor del back
docker run -d --network redwementis --name wementisback -p 8080:8080 rubentxogg/wementisback

### 7. Ejecutar contenedor del front
docker run -d --network redwementis --name wementisfront -p 8081:8080 rubentxogg/wementisfront

### :crossed_flags: 8. Acceder con el navegador a la url: http://localhost:8081/