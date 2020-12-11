package model;

import java.sql.Connection;

import model.DBConnect;

public class CSingelton {
	private static CSingelton printer = null;
	private static int ManagerOrViewerstatic;
	// �̱��� Ŭ�������� �α��� ���� ���
	// 2020 12 10 ������
	private static Connection conn;
	private static DBConnect connect = new DBConnect();
	// �̱��� Ŭ�������� DB Ŀ��Ʈ ���
	// �ѹ� �����ϸ� ��� ����� ���� ������ �� �ְ�
	// 2020 12 11 ������
	public static CSingelton getInstance() {
		if(printer == null) {
			conn = connect.getConnection();
			//���� �̱��� ��ü ������ �� DB ����
			printer = new CSingelton();
		}
		return printer;
	}

	public int getManagerOrViewer() {
		return ManagerOrViewerstatic;
	}
	public void setManagerOrViewer(int ManagerOrViewer) {
		ManagerOrViewerstatic = ManagerOrViewer;
	}

	public Connection getDBConnect() {
		return conn;
	}
}
