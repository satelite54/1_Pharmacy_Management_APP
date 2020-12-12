package view;

import java.io.IOException;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.CSingelton;
import model.CPage;

public class Number3 implements Initializable {
	CSingelton MOrV = CSingelton.getInstance();

    @FXML
    private Label ManagerOrViewer;

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
    private ListView<String> SearchListBox;

    private PreparedStatement pstmt;

    StringBuilder strb = new StringBuilder();

    CPage page = new CPage();
    @FXML
    void ClikSreachBox(ActionEvent event) {

    }

    @FXML
    void onClickSearchbtn(ActionEvent event) {
        // 원하는 실행문
 	   MOrV.setSearchText(SearchBox.getText());
    	Stage stage = new Stage();
 	   String FXMLRout = "../view/DBSearch.fxml";
 	   try {
			page.CreatePage(stage, FXMLRout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public void initialize(URL location, ResourceBundle resoruces) { //이미지 클릭 이벤트 까지 확인
    	SearchListBox.setVisible(false);
    	if(MOrV.getManagerOrViewer() == 1) {
    		ManagerOrViewer.setText("관리자님 안녕하세요!");
    	}
    	else {
    		ManagerOrViewer.setText("열람자님 안녕하세요!");
    	}

    	input.setOnMouseClicked( new EventHandler() {
               @Override
               public void handle( Event evnet ) {
                   // 원하는 실행문
            	   Stage stage = new Stage();
            	   String FXMLRout = "../view/DBRegister.fxml";
            	   try {
					page.CreatePage(stage, FXMLRout);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
              }
        });
    	Manage.setOnMouseClicked( new EventHandler() {
            @Override
            public void handle( Event evnet ) {
                // 원하는 실행문
         	   Stage stage = new Stage();
         	   String FXMLRout = "../view/DBSearch.fxml";
         	   try {
				page.CreatePage(stage, FXMLRout);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
    	});
    	ShelfLife.setOnMouseClicked( new EventHandler() {
            @Override
            public void handle( Event evnet ) {
                // 원하는 실행문
         	   Stage stage = new Stage();
         	   String FXMLRout = "../view/Mdate.fxml";
         	   try {
				page.CreatePage(stage, FXMLRout);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
    	});
    	add.setOnMouseClicked( new EventHandler() {
            @Override
            public void handle( Event evnet ) {
                // 원하는 실행문
         	   Stage stage = new Stage();
         	   String FXMLRout = "../view/SignUp.fxml";
         	   try {
				page.CreatePage(stage, FXMLRout);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
    	});

    	SearchListBox.setOnMouseClicked ((MouseEvent) -> {
    		String Obj = SearchListBox.getSelectionModel().getSelectedItem();
    		SearchBox.setText(Obj);
    	});

    	SearchBox.setOnKeyPressed( new EventHandler<KeyEvent>() {
    		@Override
    		public void handle( KeyEvent event ) {
				SearchListBox.getItems().clear();
				if(event.getCode().equals(KeyCode.BACK_SPACE) && strb.length() != 0) {
					strb.delete(strb.length()-1, strb.length());
				}
				else {
					strb.append(event.getText());
				}
				if(strb.length() == 0) {
					SearchListBox.setVisible(false);
					return;
				}
    			String sql = "SELECT name, effect, stock FROM Medicine where name LIKE '" + strb.toString() +"%'";

    			try {
					pstmt = MOrV.getDBConnect().prepareStatement(sql);
	    			ResultSet rs = pstmt.executeQuery();

	    	        while(rs.next())
	    	        {
	    	        	SearchListBox.setVisible(true); 	//DB 검색 목록이 있다면 true
	    	        	SearchListBox.getItems().add(rs.getNString("NAME") + "  " + rs.getString("EFFECT") + "  " + rs.getString("STOCK"));
	    	        }

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
		});
    }
}
