package view;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import model.Medicine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CSingelton;

public class MdateController implements Initializable{
@FXML
private Label ManagerOrViewer;
 @FXML
 private Label Today;
 @FXML
 private TableView<Medicine> medicine;
 @FXML
 private TableColumn<Medicine, String> colName;
 @FXML
 private TableColumn<Medicine, Date> colExpiration;
 @FXML
 private JFXButton btnHome;

 CSingelton mov = CSingelton.getInstance();

 public ObservableList<Medicine> getMedicineList(){
		ObservableList<Medicine> medicineList = FXCollections.observableArrayList();
		String sql = "SELECT name,(expiration) FROM medicine m where m.expiration < sysdate+10 minus"
				+ " " + "select name,expiration from medicine where sysdate > expiration";


		Statement stmt;
		ResultSet rs;
		try {
			stmt = mov.getDBConnect().createStatement();  //���� ��ü ����
			rs = stmt.executeQuery(sql);		//���ӵ� DB���� ������ �����ϰ� ����� ����
			Medicine medicine;
			while(rs.next()) {
				medicine = new Medicine(rs.getString("name"), rs.getDate("expiration"));
				medicineList.add(medicine);
			}
		} catch (Exception e) {
			System.out.println("DB���� sql���� ����Ұ�: "+e);
		}
		return medicineList;
	}
 	public void showMedicine() {
		ObservableList<Medicine> list = getMedicineList();
		medicine.setItems(list);
		colName.setCellValueFactory(new PropertyValueFactory<Medicine, String>("name"));
		colExpiration.setCellValueFactory(new PropertyValueFactory<Medicine, Date>("expiration"));
	}


		@Override
		public void initialize(URL location, ResourceBundle resources) {
			if(mov.getManagerOrViewer() == 1) {
	    		ManagerOrViewer.setText("�α��� ���� : ������");
	    	}
	    	else {
	    		ManagerOrViewer.setText("�α��� ���� : ������");
	    	}
			showMedicine();
			SimpleDateFormat Date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strDate = Date.format(System.currentTimeMillis());
			Today.setText(strDate);
		}
	    @FXML
	    void handleButton(ActionEvent event) {
	    	btnHome.getScene().getWindow().hide();
	    }
}
