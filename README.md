# Proyecto_WeMentis
Proyecto final DAW

# 1 Crear la imagen mediante dockerFile
docker build -t rubentxogg/bbdd1 .

# 2 Crear la red interna
docker network create redwementis

# 3 Crear un contenedor en la red creada en el paso anterior, indicar la contraseña en la variable de entorno y asignar puertos
docker run -d --network redwementis --name wementisbbdd -e MYSQL_ROOT_PASSWORD=PracticaRoot -p 3307:3306 rubentxogg/bbdd1
35b9a3bb0de06d952af7464c63006f03f2d185c8341b29fe1da71340789fb810

# 4 Abrir el bash en el contenedor creado 
docker exec -it mysql mysql -p