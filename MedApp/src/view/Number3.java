package view;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import model.DBConnect;

public class Number3 implements Initializable {

    @FXML
    private ImageView add;

    @FXML
    private ImageView input;

    @FXML
    private ImageView Manage;

    @FXML
    private ImageView ShelfLife;

    @FXML
    private JFXTextField SearchBox;

    @FXML
    private JFXButton Searchbtn;

    @FXML
    private Text Manager;

    @FXML
    private ListView<String> SearchListBox;

    DBConnect connection= new DBConnect();
    private Connection conn;
    private PreparedStatement pstmt;



    @FXML
    void ClikSreachBox(ActionEvent event) {

    }

    @FXML
    void onClickSearchbtn(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resoruces) { //이미지 클릭 이벤트 까지 확인
    	input.setOnMouseClicked( new EventHandler() {
               @Override
               public void handle( Event evnet ) {
                   // 원하는 실행문

              }
        });
    	Manage.setOnMouseClicked( new EventHandler() {
            @Override
            public void handle( Event evnet ) {
                // 원하는 실행문

            }
    	});
    	ShelfLife.setOnMouseClicked( new EventHandler() {
            @Override
            public void handle( Event evnet ) {
                // 원하는 실행문

            }
    	});
    	add.setOnMouseClicked( new EventHandler() {
            @Override
            public void handle( Event evnet ) {
                // 원하는 실행문

            }
    	});
    	SearchBox.setOnKeyPressed( new EventHandler() {
    		@Override
    		public void handle( Event event ) {
    			conn = connection.getConnection();
    			String sql = "SELECT *FROM student where email = ?;";

    			try {
					pstmt = conn.prepareStatement(sql);
	    			pstmt.setString(1, SearchBox.getText());
	    			ResultSet rs = pstmt.executeQuery();

	    	        while(rs.next())
	    	        {
	    	        	SearchListBox
	    	        }



				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
		});
    }
}
