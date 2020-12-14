CREATE TABLE MEDICINETEMP AS SELECT name, image ,character, effect, warning, company, expiration, price, stock FROM medicine;
commit;
DROP TABLE Medicine;

RENAME MEdicinetemp to medicine;
commit;