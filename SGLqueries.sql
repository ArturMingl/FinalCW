-- 8. Создать таблицы с иерархией из диаграммы в БД
CREATE TABLE animal (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    birth_date DATE,
    age TEXT,
    animal_type TEXT
);

CREATE TABLE cat (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    birth_date DATE
);

CREATE TABLE dog (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    birth_date DATE
);

CREATE TABLE hamster (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    birth_date DATE
);

CREATE TABLE horse (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    birth_date DATE
);

CREATE TABLE camel (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    birth_date DATE
);

CREATE TABLE donkey (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    birth_date DATE
);

-- 9. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения
INSERT INTO cat (animal_name,commands, birth_date) VALUES 
	('Соня', 'есть', '2021-12-01'),
	('Борис', 'есть, спать', '2019-12-10'),
    ('Леопольд', 'есть, тыгыдыкать', '2020-02-03'),
    ('Маруся', 'тыгыдыкать', '2019-03-03'),
    ('Мия', 'есть', '2018-05-06');
   
INSERT INTO dog (animal_name,commands, birth_date) VALUES 
	('Бакс', 'голос', '2020-01-01'),
	('Барон', 'сидеть', '2021-12-10'),
    ('Грей', 'лежать, лапу', '2019-02-02'),
    ('Вулкан', 'лапу, другую лапу', '2022-05-03'),
    ('Борман', 'голос', '2023-07-05');
    
INSERT INTO hamster (animal_name,commands, birth_date) VALUES 
	('Хома', 'есть', '2021-01-01'),
	('Горох', 'есть', '2019-09-12'),
    ('Шлепок', 'грызть', '2021-02-02'),
    ('Жорик', 'бегать', '2023-05-03'),
    ('Этот', 'бегать', '2019-06-07');
    
INSERT INTO horse (animal_name,commands, birth_date) VALUES 
	('Астон', 'галоп', '2019-03-01'),
	('Гамлет', 'трусцой', '2019-12-10'),
    ('Астон', 'галоп, трусцой', '2021-02-02'),
    ('Бэлла', 'сальто', '2022-03-04'),
    ('Гельда', 'сальто', '2017-06-05');
    
INSERT INTO camel (animal_name,commands, birth_date) VALUES 
	('Азам', 'есть', '2022-05-07'),
	('Азиз', 'пить', '2018-12-10'),
    ('Акиф', 'ходить', '2021-02-02'),
    ('Алим', 'не пить', '2021-03-03'),
    ('Амир', 'есть', '2018-05-06');
    
INSERT INTO donkey (animal_name,commands, birth_date) VALUES 
	('Астон', 'галоп', '2018-01-01'),
	('Гамлет', 'трусцой', '2019-12-10'),
    ('Астон', 'трусцой', '2019-03-02'),
    ('Бэлла', 'галоп', '2020-05-03'),
    ('Гельда', 'сальто', '2018-05-05');
    
-- 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. 
-- Объединить таблицы лошади, и ослы в одну таблицу

TRUNCATE camel;

INSERT INTO horse (animal_name, commands, birth_date)
SELECT animal_name, commands, birth_date
FROM donkey;

DROP TABLE donkey;

RENAME TABLE horse TO horse_and_donkey;

-- 11. Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет 
-- в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице

CREATE TABLE young_animal (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    birth_date DATE,
    age TEXT
);

DELIMITER \\
CREATE FUNCTION f_age (b_date DATE)
RETURNS TEXT
DETERMINISTIC
BEGIN
    DECLARE res TEXT DEFAULT '';
	SET res = CONCAT(
            TIMESTAMPDIFF(YEAR, b_date, CURDATE()),
            ' лет ',
            TIMESTAMPDIFF(MONTH, b_date, CURDATE()) % 12,
            ' мес.'
        );
	RETURN res;
END \\
DELIMITER ;

INSERT INTO young_animal (animal_name, commands, birth_date, age)
SELECT animal_name, commands, birth_date, f_age(birth_date)
FROM cat
WHERE TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 1 AND 2
UNION ALL
SELECT animal_name, commands, birth_date, f_age(birth_date)
FROM dog
WHERE TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 1 AND 2
UNION ALL
SELECT animal_name, commands, birth_date, f_age(birth_date)
FROM hamster
WHERE TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 1 AND 2
UNION ALL
SELECT animal_name, commands, birth_date, f_age(birth_date)
FROM horse_and_donkey
WHERE TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 1 AND 2;

-- 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам

INSERT INTO animal (animal_name, commands, birth_date, age, animal_type)
SELECT animal_name, commands, birth_date, f_age(birth_date), 'cat'
FROM cat
UNION ALL
SELECT animal_name, commands, birth_date, f_age(birth_date), 'dog'
FROM dog
UNION ALL
SELECT animal_name, commands, birth_date, f_age(birth_date), 'hamster'
FROM hamster
UNION ALL
SELECT animal_name, commands, birth_date, f_age(birth_date), 'horse_and_donkey'
FROM horse_and_donkey
UNION ALL
SELECT animal_name, commands, birth_date, age, 'young_animals'
FROM young_animal;

