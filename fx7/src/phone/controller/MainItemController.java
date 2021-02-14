package phone.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import phone.Main;

public class MainItemController {
	@FXML
	AnchorPane root;
    @FXML
    void onClickCafe(MouseEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("../view/CafeMain.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    @FXML
    void onClickAdress(MouseEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("../view/AddressMain.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void onClickPizza(MouseEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("../view/PizzaMain.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void onClickBus(MouseEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("../view/BusMain.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    

    @FXML
    void onClickRestaurant(MouseEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("../view/RestaurantMain.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
}
