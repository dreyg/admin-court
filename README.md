# admin-court by DRG

PRE REQUISITOS:
- Java11
- docker 4.15.0

with DEV profile, you should execute this commands:
--docker run --name basic-mysql --rm -v /tmp/mysql-data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=MY-COURT -p 3306:3306 -it mysql:8.0

-- levantar el contenedor de la bdd
docker-compose -f docker-compose-mysql-only.yml up

// El usuario root ya viene con los privilegios, no hace falta, 
        pero si q hay q crear la primera vez la database courtdb

docker exec -it mycourtdb mysql -uroot -p
Enter password:

mysql>  CREATE USER 'sa'@'172.17.0.1' IDENTIFIED BY 'password';
mysql> GRANT ALL PRIVILEGES ON *.* TO 'sa'@'172.17.0.1' WITH GRANT OPTION;
mysql> flush privileges;
mysql> exit

-- eliminar el contenedor de la bdd
docker-compose -f docker-compose-mysql-only.yml down

-- Seguridad en la APP.
-> se genera el fichero keystore.jks
-> se añade al proyecto (main/resources/keystore.jks)


-- Añadir seguridad al proyecto:
httpS:
keytool -genkey -keyalg RSA -alias selfsigned -keystore keystore.jks -storepass password -validity 360 -keysize 2048
keytool -importkeystore -srckeystore keystore.jks -destkeystore keystore.p12 -deststoretype pkcs12
keytool -import -keystore $JAVA_HOME/jre/lib/security/cacerts -alias selfsigned -file DavidRey.cer
password //// everywhere

--1º Crear truestore, puede ser en formato jks o pkcs (más moderno, se suele usar este)
--2º Cuando hacemos peticion a través de chrome, generamos el certificado y lo importamos dentro del cacerts.
--3º Añadimos configuración en el servidor/API, modificando el properties y añadiendo clase de configuración.

JWT:
