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
		//fx에서 테이블뷰에 표시하기 위한 리스트로 oblservableList 를 사용한다.(특징 이벤트시 리스너 사용가능)
		ObservableList<Medicine> stList = FXCollections.observableArrayList();
		
		//쿼리문 작성
		String sql = "SELECT * FROM medicine"; 
		//DB 연결
		Connection conn = connection.getConnection();
		Statement stmt;          //DB에 보낼 쿼리 객체 
		ResultSet rs;            //DB에서 결과를 받아올 객체
		
		try {
			stmt = conn.createStatement(); //쿼리객체 생성
			rs = stmt.executeQuery(sql);   //stl문장을 넣어서 실행하고 결과를 rs에 담아옴
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
