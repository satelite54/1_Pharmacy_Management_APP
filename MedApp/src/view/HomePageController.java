package view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.jfoenix.controls.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DBConnect;
import model.Team01;


public class HomePageController {

	@FXML
	private JFXButton btnShow;

	@FXML
	private TableView<Team01> tvTeam01;

	@FXML
	private TableColumn<Team01, String> colFname;

	@FXML
	private TableColumn<Team01, String> colPass;

	@FXML
	private TableColumn<Team01, String> colEmail;

	@FXML
	private TableColumn<Team01, String> colHost;

	@FXML
	public void handleButton(ActionEvent event) {
		showTeam01();
	}

    private DBConnect connection= new DBConnect();


	// DB에 연결해서 모든 데이터를 가져온다. ( 1. DB 연결 2.sql문장 작성 3.sql문을 실행하고 결과를 받아온다.)
	public ObservableList<Team01> getTeam01List(){
		//fx에서 테이블뷰에 표시하기 위한 리스트로 oblservableList 를 사용한다.(특징 이벤트시 리스너 사용가능)
		ObservableList<Team01> stList = FXCollections.observableArrayList();

		//쿼리문 작성
		String sql = "SELECT * FROM  userdatas";
		//DB 연결
		Connection conn = connection.getConnection();
		Statement stmt;          //DB에 보낼 쿼리 객체
		ResultSet rs;            //DB에서 결과를 받아올 객체

		try {
			stmt = conn.createStatement(); //쿼리객체 생성
			rs = stmt.executeQuery(sql);   //stl문장을 넣어서 실행하고 결과를 rs에 담아옴
			Team01 st;
			while(rs.next()) {
				st = new Team01( rs.getString("fullname"), rs.getString("password"), rs.getString("email"), rs.getString("host"));
				stList.add(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stList;
	}

	public void showTeam01() {
		ObservableList<Team01> list = getTeam01List();
		//테이블에 리스트를 입력한다.
		tvTeam01.setItems(list);
		//각각의 셀들에 맞는 열의 데이터를 가져오게 한다.
		colFname.setCellValueFactory(new PropertyValueFactory<Team01, String>("fullname"));
		colPass.setCellValueFactory(new PropertyValueFactory<Team01, String>("password"));
		colEmail.setCellValueFactory(new PropertyValueFactory<Team01, String>("email"));
		colHost.setCellValueFactory(new PropertyValueFactory<Team01, String>("host"));

	}
}
