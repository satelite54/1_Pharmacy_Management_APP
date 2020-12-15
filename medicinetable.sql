CREATE TABLE MEDICINETEMP AS SELECT name, image ,character, effect, warning, company, expiration, price, stock FROM medicine;
commit;
DROP TABLE Medicine;

RENAME MEdicinetemp to medicine;
commit;

ALTER TABLE medicine MODIFY NAME VARCHAR2(100);
ALTER TABLE medicine MODIFY CHaracter VARCHAR2(100);
ALTER TABLE medicine MODIFY effect VARCHAR2(100);
ALTER TABLE medicine MODIFY Warning VARCHAR2(100);
ALTER TABLE medicine MODIFY company VARCHAR2(100);

CREATE TABLE UserDatatemp AS SELECT name, id, password, permit FROM UserData;
DROP TABLE UserData;
RENAME UserDatatemp to UserData;

ALTER TABLE UserData MODIFY name VARCHAR2(100);
ALTER TABLE UserData MODIFY id VARCHAR2(100);
ALTER TABLE UserData MODIFY password VARCHAR2(100);
ALTER TABLE UserData MODIFY permit VARCHAR2(100);


commit;