# admin-court by DRG

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

