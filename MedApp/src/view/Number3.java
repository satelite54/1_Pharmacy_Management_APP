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

import javafx.collections.ObservableList;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.CManagerOrViewer;
import model.CPage;
import model.DBConnect;

public class Number3 implements Initializable {
	CManagerOrViewer MOrV = CManagerOrViewer.getInstance();

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

    DBConnect connection= new DBConnect();
    private Connection conn;
    private PreparedStatement pstmt;

    StringBuilder strb = new StringBuilder();

    CPage page = new CPage();
    @FXML
    void ClikSreachBox(ActionEvent event) {

    }

    @FXML
    void onClickSearchbtn(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resoruces) { //�̹��� Ŭ�� �̺�Ʈ ���� Ȯ��
    	SearchListBox.setVisible(false);
    	if(MOrV.getManagerOrViewer() == 0) {
    		ManagerOrViewer.setText("�����ڴ� �ȳ��ϼ���!");
    	}
    	else {
    		ManagerOrViewer.setText("�����ڴ� �ȳ��ϼ���!");
    	}

    	input.setOnMouseClicked( new EventHandler() {
               @Override
               public void handle( Event evnet ) {
                   // ���ϴ� ���๮
            	   Stage stage = new Stage();
            	   String FXMLRout = "";
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
                // ���ϴ� ���๮
         	   Stage stage = new Stage();
         	   String FXMLRout = "";
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
                // ���ϴ� ���๮
         	   Stage stage = new Stage();
         	   String FXMLRout = "";
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
                // ���ϴ� ���๮
         	   Stage stage = new Stage();
         	   String FXMLRout = "";
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
    			conn = connection.getConnection();
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
					pstmt = conn.prepareStatement(sql);
	    			ResultSet rs = pstmt.executeQuery();

	    	        while(rs.next())
	    	        {
	    	        	SearchListBox.setVisible(true); 	//DB �˻� ����� �ִٸ� true
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
