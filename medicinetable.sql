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