package phone.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import phone.mysqlconnect;
import phone.Main;

public class CafeMainController {
	Main main = new Main();
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    private ComboBox<String> comboType;
    @FXML
    private AnchorPane loginpane;
    @FXML
    private AnchorPane lblpane;
    @FXML
    private Label lbl_welcome;
    @FXML
    private TextField txt_username;

    @FXML
    private PasswordField txt_password;
    
    @FXML
    private VBox logo;
	@FXML
	private void initialize() {
		comboType.getItems().addAll("판매담당","관리자","임원");
		if(Main.sw.equals("on")) {
		String s1 = "안녕하세요? " +main.t_name+ "님 !!!";
		loginpane.setVisible(false);
		lbl_welcome.setText(s1);
		lblpane.setVisible(true);

		}
	}
    @FXML
    void onClickType(ActionEvent event) {

    }
    @FXML
    void onClickLogin(ActionEvent event) {
    	conn = mysqlconnect.ConnectDb();
    	String sql = "select * from student where id =? and name=?";
    	
    	Main.position = comboType.getValue().toString();
    	
    	try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, txt_username.getText());
			pst.setString(2, txt_password.getText());
			rs = pst.executeQuery();			
			if(rs.next()) {
				Main.sw = "on";
				main.t_name = txt_username.getText().toString();
				String s1 = "안녕하세요? " +main.t_name+ "님 !!!";
				JOptionPane.showMessageDialog(null,"Welcome");
				loginpane.setVisible(false);
				lbl_welcome.setText(s1);
				lblpane.setVisible(true);
	
												
			} else {
				JOptionPane.showMessageDialog(null,"Try to another Username or Password");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void onClickLogout(ActionEvent event) {
		loginpane.setVisible(true);
		lblpane.setVisible(false);
		Main.sw = "off";
		
    }
    @FXML
    void onClickSignup(ActionEvent event) {
    	JOptionPane.showMessageDialog(null,"Comming soon !");
    }

	@FXML
	void onClickOrder(ActionEvent event) throws IOException {
		if(Main.sw.equals("on") && ((Main.position.equals("판매담당"))||(Main.position.equals("임원")))) {
			main.stopMainView();
			main.showOrderView();
		} else
			JOptionPane.showMessageDialog(null,"Try to another Username or position !");
	}

	@FXML
	void onClickStatistic(ActionEvent event) throws IOException {
		if(Main.sw.equals("on") && ((Main.position.equals("관리자"))||(Main.position.equals("임원")))) {
			main.stopMainView();
			main.showCheckView();
		} else
			JOptionPane.showMessageDialog(null,"Try to another Username or position !!!");
	}

}

