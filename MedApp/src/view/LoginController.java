package view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import application.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.CSingelton;
import model.DBConnect;

public class LoginController {

    @FXML
    private AnchorPane anPane;

    @FXML
    private JFXTextField tfEmail;

    @FXML
    private JFXPasswordField tfPass;

    @FXML
    private JFXButton btnRegister;

    @FXML
    private JFXButton btnLogin;

    Message msg = new Message();
    DBConnect connect = new DBConnect();
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;

    @FXML
    void createLogin(ActionEvent event) throws SQLException, IOException {
        CSingelton mov = CSingelton.getInstance();
    	//System.out.println("�α��� ��������");
    	/*if(tfEmail.getText().equals("")) {
    		mgs.setMessage("�̸� ���Է�!");    	}*/
    	//DB�� �̸��ϰ� ��й�ȣ�� Ȯ���Ͽ� �α��� ���� �Ǵ� �Ұ�
    	String sql = "SELECT*FROM userdata WHERE id=? AND password=?";
    	pstmt = mov.getDBConnect().prepareStatement(sql);
    	pstmt.setNString(1,  tfEmail.getText());
    	pstmt.setNString(2,  tfPass.getText());

    	rs = pstmt.executeQuery(); //execute ������ �������� �ְ� update�� ����.

        boolean LoginSucess = false;
    	if(rs.next()) {
    		//msg.setMessage("Success!");
    		//���� â�� �ݴ´�.
    		if(tfEmail.getText().equals(rs.getNString("id")) &&
    				tfPass.getText().equals(rs.getNString("PASSWORD"))) {
    			if(rs.getNString("permit").equals("������")) {
    				mov.setManagerOrViewer(1);
    			}
        		LoginSucess = true;
    		}
    		if(LoginSucess == true) {
        		btnLogin.getScene().getWindow().hide();
        		//�α��� ���� �� Ȩ����������
        		Stage home = new Stage();
            	Parent root = FXMLLoader.load(getClass().getResource("../view/Main_KimtaeHeon.fxml"));
        		Scene scene = new Scene(root);
        		home.setScene(scene);
        		home.show();
        		msg.setMessage("Success!");
    		}
    	}
    	else {
    		msg.setMessage("���̵�� ��й�ȣ�� �߸��Ǿ����ϴ�.");

    	}
    }

    @FXML
    void createregister(ActionEvent event) throws IOException {
    		//System.out.println("���� ��������");
    	btnRegister.getScene().getWindow().hide(); //���� �������� �Ⱥ��̰�

    	Stage signup = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/SignUp.fxml"));
		Scene scene = new Scene(root);
		signup.setScene(scene);
		signup.show();
    }

}
