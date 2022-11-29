# admin-court by DRG

with DEV profile, you should execute this commands:

docker run --name basic-mysql --rm -v /tmp/mysql-data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=MY-COURT -p 3306:3306 -it mysql:8.0

docker-compose -f docker-compose-mysql-only.yml up

docker exec -it mycourtdb mysql -uroot -p
Enter password:

mysql>  CREATE USER 'sa'@'172.17.0.1' IDENTIFIED BY 'password';
mysql> GRANT ALL PRIVILEGES ON *.* TO 'sa'@'172.17.0.1' WITH GRANT OPTION;
mysql> flush privileges;
mysql> exit

docker-compose -f docker-compose-mysql-only.yml down