Drop Table Medicine;

CREATE TABLE Medicine (
  name VARCHAR2(300) NOT NULL,
  image VARCHAR2(300) NOT NULL,
  character VARCHAR2(300) NOT NULL,
  effect VARCHAR2(300) NOT NULL,
  warning VARCHAR2(300) NOT NULL,
  company VARCHAR2(300) NOT NULL,
  expiration DATE NOT NULL,
  price NUMBER NOT NULL,
  stock NUMBER NOT NULL,
  PRIMARY KEY (name)
  );
  
INSERT INTO Medicine VALUES('tinunband', 'file:/C:/MedApp/src/img/tinunband.png', '��� ���', 'Ƽ�� ����', '�索��ȯ�� ��� ����', '�Ž�', to_date('2020/12/20', 'YYYY/MM/DD'), 3500, 5);
INSERT INTO Medicine VALUES('bepanthen', 'file:/C:/MedApp/src/img/bepanthen.png', '�Ͼ�� ����', '��ó �� ���� ġ��', '�� ���� ����', '���̿��ڸ���', to_date('2020/12/21', 'YYYY/MM/DD'), 8000, 6);
INSERT INTO Medicine VALUES('hemaforce ��', 'file:/C:/MedApp/src/img/hemaforce.png', '����� ����', 'ö ���� �� ���� ����', '�˷����� ����', '���̴������߿��������̴������߿�����', to_date('2020/12/20', 'YYYY/MM/DD'), 20000, 7);
INSERT INTO Medicine VALUES('lindan', 'file:/C:/MedApp/src/img/lindan.png', '����� ��Ź�� �ο�����', '�Ӹ��� ������', '�ӻ�� ����', '�Ž�', to_date('2020/12/24','YYYY/MM/DD'), 4000, 3);
INSERT INTO Medicine VALUES('dupi', 'file:/C:/MedApp/src/img/dupi.png', '��ü', '������, �Ǻο�', '1�� ��ȸ ���', '�ѹ�', to_date('2020/12/31', 'YYYY/MM/DD'), 3500, 4);
INSERT INTO Medicine VALUES('lamisil', 'file:/C:/MedApp/src/img/lamisil.png', '����� ũ����', '�Ǻ����հ������Ǻ����հ�����', '1�� 1-2ȸ, �Ҿ� �������', '�۶��ҽ��̽�Ŭ�����������ｺ�ɾ��ڸ��Ʊ۶��ҽ��̽�Ŭ�����������ｺ�ɾ��ڸ���', to_date('2020/12/20', 'YYYY/MM/DD'), 8000, 3);
INSERT INTO Medicine VALUES('easycare', 'file:/C:/MedApp/src/img/easycare.png', '�����ü', '����������', '30�� ���� �� 6�ð� ��ô����, 18�� �̸� ����', '���Ѿ���', to_date('2021/01/01', 'YYYY/MM/DD'), 10000, 10);
INSERT INTO Medicine VALUES('tylenol', 'file:/C:/MedApp/src/img/tylenol.png', '����� ������ �ʸ�������', '�ؿ�, ����, �ҿ���', '��12�� �̻� 1�� 3ȸ', '�ѱ��Ἶ', to_date('2021/02/20', 'YYYY/MM/DD'), 3000, 7);
INSERT INTO Medicine VALUES('aspirin', 'file:/C:/MedApp/src/img/aspirin.png', '����� ���� �ʸ�������', '���� ���� ����', '1�� 1ȸ 1��, ���캴 ȯ�� ������', '�ѹ̾�ǰ', to_date('2021/02/18', 'YYYY/MM/DD'), 5000, 7);
INSERT INTO Medicine VALUES('rexen', 'file:/C:/MedApp/src/img/rexen.png', '����� ��ź�� ����', 'ġ�� ���� ��ȭ', 'ȯ�ΰ� ȭ��Ǿ��ִ� ȯ�� ��� ����', '�Ѹ�����', to_date('2021/03/15', 'YYYY/MM/DD'), 20000, 4);
INSERT INTO Medicine VALUES('touchmed', 'file:/C:/MedApp/src/img/touchmed.png', '���� û���� ������', '������, ����', '1�� 2-4ȸ ȯ�ο� ����, �˷���������', '��ȭ��ǰ', to_date('2022/06/22', 'YYYY/MM/DD'), 5000, 4);
INSERT INTO Medicine VALUES('stomasin', 'file:/C:/MedApp/src/img/stomasin.png', '�Ķ��� ����� ����ĸ��', '���� ��ȭ', '1ȸ 2ĸ��, ����ҳ��� ȯ�� ������', '���̿�������', to_date('2022/04/05', 'YYYY/MM/DD'), 8000, 3);
INSERT INTO Medicine VALUES('strepsils', 'file:/C:/MedApp/src/img/strepsils.png', '��Ȳ���� ���� Ʈ��Ű��', 'ȿ��\\���Ŀ� ���� ��ȭ', '1�� �ִ� 5�� ����', '���÷�Ŷ��Ű��', to_date('2022/03/20', 'YYYY/MM/DD'), 8000, 6);
INSERT INTO Medicine VALUES('pollydent', 'file:/C:/MedApp/src/img/pollydent.png', '������', 'Ʋ��, ��ġ ����, ����ȿ��', '��Ű�� �� ��', '�۶��ҽ��̽�Ŭ����', to_date('2022/02/01', 'YYYY/MM/DD'), 25000, 8);
INSERT INTO Medicine VALUES('coq10', 'file:/C:/MedApp/src/img/coq10.png', '������ ����ĸ��', '�׻�ȭ�� ���а��ҵ���', '1�� ĸ��', 'GNM', to_date('2022/09/10', 'YYYY/MM/DD'), 30000, 4);
INSERT INTO Medicine VALUES('champix', 'file:/C:/MedApp/src/img/champix.png', '����� ����� �ʸ������������ ����� �ʸ�������', '�ݿ�ġ���� ��������ݿ�ġ���� �������', '�ڻ���⼺ �����ڻ���⼺ ����', 'ȭ����ȭ����', to_date('2021/12/20', 'YYYY/MM/DD'), 15000, 8);
INSERT INTO Medicine VALUES('tinun', 'file:/C:/MedApp/src/img/tinun.png', '�����ü', 'Ƽ��, ������ ����', '2-5�� �� ��ü', '�Ž�', to_date('2021/07/13', 'YYYY/MM/DD'), 2800, 3);
INSERT INTO Medicine VALUES('cleancle', 'file:/C:/MedApp/src/img/cleancle.png', '���������� ��', '����, ��������, ������� ����', '�ֻ����� ������', '���̴������������', to_date('2023/02/17', 'YYYY/MM/DD'), 1700, 3);
INSERT INTO Medicine VALUES('brown juice', 'file:/C:/MedApp/src/img/juice.png', '������ ���������� ������ ��ü', '���ü��, �Ƿ�ȸ��, ����', '������ȯ�� ����, 1�� 3ȸ', '���¿���ġƼ��', to_date('2020/12/22', 'YYYY/MM/DD'), 3700, 4);
INSERT INTO Medicine VALUES('roidipen', 'file:/C:/MedApp/src/img/roidipen.png', '����', '����, ���� ��, ü��, ���', '15�� �̻�, 1ȸ2ĸ�� 1�� 2ȸ', '�̷�����', to_date('2020/12/23', 'YYYY/MM/DD'), 7000, 4);
INSERT INTO Medicine VALUES('stomaq', 'file:/C:/MedApp/src/img/stomaq.png', 'Ȳ������ ������', '����� ��ġ, �Ű���� ���� ��ȭ', '1�� 3ȸ, ������ ȯ�� ����', '���ž�', to_date('2020/12/23', 'YYYY/MM/DD'), 4000, 4);
INSERT INTO Medicine VALUES('buscopan', 'file:/C:/MedApp/src/img/buscopan.png', '����� Ÿ���� �ʸ�������', '�㵵�� ������ �� ��ü� ����', '1�� 3ȸ, ���� �Բ� ����� ���ջ� ����', '����Ǿƺ�Ƽ���ڸ���', to_date('2020/12/27', 'YYYY/MM/DD'), 7000, 6);
INSERT INTO Medicine VALUES('bomilong', 'file:/C:/MedApp/src/img/bomilong.png', 'Ȳ���� ����', '�ֹ̿� ���� ��������, ����, ������ ���� �� ��ȭ', '����: 1ȸ 1��,�Ҿ�: 1ȸ 2/3�� ', '��������', to_date('2020/12/31', 'YYYY/MM/DD'), 5000, 1);
INSERT INTO Medicine VALUES('kimite', 'file:/C:/MedApp/src/img/kimite.png', '���� Ȳ������ ���������׸��ʸ������� ���� ����', '�ֹ̿� ���� ����, ������ ����', '7�� ���� ������', '������', to_date('2020/12/31', 'YYYY/MM/DD'), 18000, 7);
INSERT INTO Medicine VALUES('insadol', 'file:/C:/MedApp/src/img/insadol.png', '��Ȳ�� ���� �ʸ�������', 'ġ��ġ�� �� ġ����, ġ�ֿ��� ����ġ��ġ��ġ�� �� ġ����, ġ�ֿ��� ����ġ��', '����ҳ��� ȯ�� ����', '��������', to_date('2022/07/19', 'YYYY/MM/DD'), 21000, 8);
INSERT INTO Medicine VALUES('igatan', 'file:/C:/MedApp/src/img/igatan.png', '��ȫ�� ���簡 �� ����� ����� ����ĸ����ȫ�� ���簡 �� ����� ����� ����ĸ��', 'ġ��ġ�� �� ġ����, ġ�ֿ��� ����ġ��', '�˷����� ����', '��������', to_date('2022/06/09', 'YYYY/MM/DD'), 20000, 11);
INSERT INTO Medicine VALUES('rhamnople', 'file:/C:/MedApp/src/img/rhamnople.png', '�� ���簡 �� ����� ĸ��', '���������', '1�� 1ȸ 1ĸ��, �˷���������', '���ع��̿���', to_date('2021/03/16', 'YYYY/MM/DD'), 150000, 7);
INSERT INTO Medicine VALUES('bcomc', 'file:/C:/MedApp/src/img/bcomc.jpg', '��ȫ���� Ÿ���� �ʸ�������', 'B1, B2, B6, C�� ����', '������ ���� �� �������', '1�� 2ȸ',to_date('2022/12/22', 'YYYY/MM/DD'), 28000, 20);
INSERT INTO Medicine VALUES('lemona', 'file:/C:/MedApp/src/img/lemona.jpg', 'Ȳ���� �̸��� ����', 'B2, B6, C�� ����, ���, �ֱٱ� ��ȭ', '1�� 1ȸ 1��', '�泲�����ֽ�ȸ��', to_date('2021/01/20', 'YYYY/MM/DD'), 18000, 14);

CREATE TABLE userdata (
    name VARCHAR2(1000) NOT NULL,
    id VARCHAR2(1000) NOT NULL,
    password VARCHAR2(1000) NOT NULL,
    permit VARCHAR2(1000) NOT NULL,
    PRIMARY KEY (id));

INSERT INTO userdata(name, id, password, permit) Values ('������', 'manager', '0000', '������');

commit;