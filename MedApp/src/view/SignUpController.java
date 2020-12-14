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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.CSingelton;

public class SignUpController implements Initializable {

	@FXML
	private Label ManagerOrViewer;

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

    CSingelton mov = CSingelton.getInstance();

    @FXML
    void goLogin(ActionEvent event) throws IOException {
    	login.getScene().getWindow().hide(); //���� �������� �ݴ´�.

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
    		//DB�� �Է³����� ����->Insert into
    	if(check.isSelected()) {
    		//���� ���� ���->DB����
    		if(fullname.getText().equals("")) {
    			msg.setMessage("�̸��� �Է��� �ּ���!");
    			return;
    		}
    		if(email.getText().equals("")) {
    			msg.setMessage("���̵� �Է��� �ּ���!");
    			return;
    		}
    		if(password.getText().equals("")) {
    			msg.setMessage("�н����带 �Է��� �ּ���!");
    			return;
    		}
    		String sql = "INSERT INTO userdata Values(?, ?, ?, ?)";
    		PreparedStatement pstmt = mov.getDBConnect().prepareStatement(sql); //sql���� �غ�
    		pstmt.setNString(1,  fullname.getText());
    		pstmt.setNString(2,  email.getText());
    		pstmt.setNString(3,  password.getText());
    		pstmt.setNString(4,  "������");

    		pstmt.executeUpdate();//�غ�� �������� DB�� �����ؼ� ����

    		msg.setMessage("�����ڷ� ��� �Ǽ̽��ϴ�.");

    	}
    	else {
    		if(fullname.getText().equals("") ) {
    			msg.setMessage("�̸��� �Է��� �ּ���!");
    			return;
    		}
    		if(email.getText().equals("")) {
    			msg.setMessage("���̵� �Է��� �ּ���!");
    			return;
    		}
    		if(password.getText().equals("")) {
    			msg.setMessage("�н����带 �Է��� �ּ���!");
    			return;
    		}
    		String sql = "INSERT INTO userdata Values(?, ?, ?, ?)";
    		PreparedStatement pstmt = mov.getDBConnect().prepareStatement(sql); //sql���� �غ�

    		pstmt.setNString(1,  fullname.getText());
    		pstmt.setNString(2,  email.getText());
    		pstmt.setNString(3,  password.getText());
    		pstmt.setNString(4,  "�Խ�Ʈ");

    		pstmt.executeUpdate();//�غ�� �������� DB�� �����ؼ� ����

    		msg.setMessage("�����ڷ� ��� �Ǽ̽��ϴ�.");
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// �ʱ� ���°��� ����
		if(mov.getManagerOrViewer() == 1) {
			ManagerOrViewer.setText("�α��� ���� : ������");
		} else {
			msg.setMessage("���Ѿ���!");
			fullname.getScene().getWindow().hide();
		}
		fullname.setStyle("-fx-text-inner-color:#afbccd;");
		email.setStyle("-fx-text-inner-color:#afbccd;");
		password.setStyle("-fx-text-inner-color:#afbccd;");
	}

}
