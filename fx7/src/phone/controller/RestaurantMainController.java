package phone.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import phone.mysqlconnect;

public class RestaurantMainController {
	Connection conn = null;

	@FXML
	private TextField txt_username;

	@FXML
	private PasswordField txt_password;

	@FXML
	void onClickLogin(ActionEvent event) throws SQLException {
		Window owner = txt_username.getScene().getWindow();
		if(txt_username.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR,owner,"Please enter a valid username", "Form error!");
			return;
		}
		if(txt_password.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR,owner,"Please enter a valid Password", "Form error!");
			return;
		}
		conn = mysqlconnect.ConnectDb();
		String username = txt_username.getText();
		String password = txt_password.getText();

		boolean flag =true;
		
			flag = mysqlconnect.validate(username, password);
	
		if(!flag)
			infoBox("Please enter correct username and password",null,"Failed");
		else {
			infoBox("Login Successful",null,"Success");
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ResDashBoard.fxml"));
				Parent root = fxmlLoader.load();
				Stage stage = new Stage();
				stage.setTitle("POS DashBoard");
				stage.setScene(new Scene(root));
				DashBoardController controller = (DashBoardController) fxmlLoader.getController();
				controller.userName(username);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void infoBox(String infoMessage, String headerText, String title) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(infoMessage);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.showAndWait();    	
	}

	public static void showAlert(Alert.AlertType alertType, Window owner, String message, String title) {
		Alert alert = new Alert(alertType);
		alert.setContentText(message);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.initOwner(owner);
		alert.show();    	
	}
}
