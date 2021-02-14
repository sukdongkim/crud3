package phone.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DashBoardController {

	@FXML
	private Label lbl_username;

	Scene fxmlFile;
	Parent root;
	Stage window;

	public void userName(String userName) {
		lbl_username.setText(userName);
	}

	@FXML
	void manageProducts(ActionEvent event) {
		try {
			openModalWindow("../view/Products.fxml","Manage Products");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@FXML
	void manageTable(ActionEvent event) {
		try {
			openModalWindow("../view/Tables.fxml","Manage Table");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	private void openModalWindow(String resource, String title) throws IOException {
		root = FXMLLoader.load(getClass().getResource(resource));
		fxmlFile = new Scene(root);
		window = new Stage();
		window.setScene(fxmlFile);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setAlwaysOnTop(true);
		window.setIconified(false);
		window.setTitle(title);
		window.showAndWait();
	}
}
