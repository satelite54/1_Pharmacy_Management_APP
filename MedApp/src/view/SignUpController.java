package view;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import application.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DBConnect;

public class SignUpController implements Initializable {

    @FXML
    private JFXTextField fullname;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXCheckBox check;



    @FXML
    private JFXButton signup;

    @FXML
    private JFXButton login;

    Message msg = new Message();
    DBConnect connect = new DBConnect();
    Connection conn;

    @FXML
    void goLogin(ActionEvent event) throws IOException {
    	login.getScene().getWindow().hide(); //현재 페이지를 닫는다.

    	Stage login = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
		login.setScene(scene);
		login.setTitle("Team01");
		login.show();
    }

    @FXML
    void signUp(ActionEvent event) throws SQLException{
    		//DB로 입력내용을 저장->Insert into
    	if(check.isSelected()) {
    		//동의 했을 경우->DB저장
    		if(fullname.getText().equals("")) {
    			msg.setMessage("이름을 입력해 주세요!");
    			return;
    		}
    		if(email.getText().equals("")) {
    			msg.setMessage("아이디를 입력해 주세요!");
    			return;
    		}
    		if(password.getText().equals("")) {
    			msg.setMessage("패스워드를 입력해 주세요!");
    			return;
    		}
    		conn = connect.getConnection();
    		String sql = "INSERT INTO userdata Values(?, ?, ?, ?)";
    		PreparedStatement pstmt = conn.prepareStatement(sql); //sql문을 준비
    		pstmt.setNString(1,  fullname.getText());
    		pstmt.setNString(2,  email.getText());
    		pstmt.setNString(3,  password.getText());
    		pstmt.setNString(4,  "관리자");

    		pstmt.executeUpdate();//준비된 쿼리문을 DB에 접속해서 실행

    		msg.setMessage("관리자로 등록 되셨습니다.");

    	}
    	else {
    		if(fullname.getText().equals("") ) {
    			msg.setMessage("이름을 입력해 주세요!");
    			return;
    		}
    		if(email.getText().equals("")) {
    			msg.setMessage("아이디를 입력해 주세요!");
    			return;
    		}
    		if(password.getText().equals("")) {
    			msg.setMessage("패스워드를 입력해 주세요!");
    			return;
    		}
    		conn = connect.getConnection();
    		String sql = "INSERT INTO userdata Values(?, ?, ?, ?)";
    		PreparedStatement pstmt = conn.prepareStatement(sql); //sql문을 준비

    		pstmt.setNString(1,  fullname.getText());
    		pstmt.setNString(2,  email.getText());
    		pstmt.setNString(3,  password.getText());
    		pstmt.setNString(4,  "게스트");

    		pstmt.executeUpdate();//준비된 쿼리문을 DB에 접속해서 실행

    		msg.setMessage("게스트로 등록 되셨습니다.");
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 초기 상태값을 설정
		fullname.setStyle("-fx-text-inner-color:#afbccd;");
		email.setStyle("-fx-text-inner-color:#afbccd;");
		password.setStyle("-fx-text-inner-color:#afbccd;");
	}

}
