package view;

import java.net.URL;
import java.sql.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jfoenix.controls.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DBConnect;
import model.Medicine;
import javafx.fxml.Initializable;


public class MdateController33 implements Initializable {

	@FXML
	private JFXButton btnHome;
	
	@FXML
	private TableView<Medicine> medicine;
	
	@FXML
	private TableColumn<Medicine, String> colName;
	
	@FXML
	private TableColumn<Medicine, Date> colExpiration;
	
	
    private DBConnect connection= new DBConnect();
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		
	}
    

	
	
	public ObservableList<Medicine> getMedicineList(){
		//fx���� ���̺�信 ǥ���ϱ� ���� ����Ʈ�� oblservableList �� ����Ѵ�.(Ư¡ �̺�Ʈ�� ������ ��밡��)
		ObservableList<Medicine> stList = FXCollections.observableArrayList();
		
		//������ �ۼ�
		String sql = "SELECT * FROM medicine"; 
		//DB ����
		Connection conn = connection.getConnection();
		Statement stmt;          //DB�� ���� ���� ��ü 
		ResultSet rs;            //DB���� ����� �޾ƿ� ��ü
		
		try {
			stmt = conn.createStatement(); //������ü ����
			rs = stmt.executeQuery(sql);   //stl������ �־ �����ϰ� ����� rs�� ��ƿ�
			Medicine st;
			while(rs.next()) {
				st = new Medicine( rs.getString("name"), rs.getDate("expiration"));
				stList.add(st);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stList;
	}
	
	public void showMedicine() {
		ObservableList<Medicine> list = getMedicineList();
		medicine.setItems(list);
		colName.setCellValueFactory(new PropertyValueFactory<Medicine, String>("name"));
		colExpiration.setCellValueFactory(new PropertyValueFactory<Medicine, Date>("expiration"));
		
	}	
}
