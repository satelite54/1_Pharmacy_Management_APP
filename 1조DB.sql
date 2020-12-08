
-- Medicine Table
CREATE TABLE Medicine
(
    name          VARCHAR2(20)    NOT NULL, 
    character     VARCHAR2(20)    NULL,
    effect        VARCHAR2(20)    NULL, 
    warning       VARCHAR2(20)    NULL, 
    company       VARCHAR2(20)    NULL, 
    expiration    DATE            NULL, 
    price         NUMBER          NULL, 
    CONSTRAINT MEDICINE_PK PRIMARY KEY (name)
);

-- User Table
CREATE TABLE UserData
(
    name        VARCHAR2(10)    NOT NULL, 
    id          VARCHAR2(10)    NULL, 
    password    VARCHAR2(4)     NULL, 
    permit      VARCHAR2(20)    NULL, 
    CONSTRAINT USER_PK PRIMARY KEY (id)
);
DROP TABLE Medicine;
--commit;

SELECT email FROM student where email LIKE '%s%';
