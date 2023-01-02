

-- saving users
INSERT INTO users (id,name,surname,username,mail,password)
    VALUES(99, 'David','Rey','dreyg','d.reyg30@gmail.com','1234');
INSERT INTO users (id,name,surname,username,mail,password)
    VALUES(100, 'Antonio','Arellano','aarellanom','a.arellano@gmail.com','1234');


INSERT INTO address (id,address,door,floor,user_id)
    VALUES(50, 'Calle Adelfas 2C','4','D',99);

INSERT INTO address (id,address,door,floor,user_id)
    VALUES(51, 'Calle Petroleo 7','5','A',100);