-- Active: 1746109704149@@127.0.0.1@3306@final_project_visual_programming
show tables;

select * from reg_provinces;

select * from reg_regencies;

SELECT * FROM reg_districts

SELECT * FROM reg_villages


SHOW CREATE TABLE reg_districts;
SHOW CREATE TABLE reg_regencies;
SHOW CREATE TABLE reg_villages;

ALTER TABLE reg_districts DROP FOREIGN KEY fk_regency;


DROP TABLE reg_proviences;

DROP TABLE reg_regencies;
DROP Table reg_districts;

show TABLEs;

drop DATABASE final_project_visual_programming;
create DATABASE final_project_visual_programming;

SELECT * from reg_provinces;
SELECT * from reg_regencies;
SELECT * from reg_districts;

SELECT provinces_id 
FROM reg_regencies 
WHERE provinces_id NOT IN (SELECT id FROM reg_provinces);