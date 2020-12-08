package view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

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
    }
}
