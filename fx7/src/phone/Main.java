package phone;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage primaryStage;
	public static Stage stage;
	public static BorderPane mainLayout;
	
	public static String sw = "off";
	public static String position = null;
	public static String t_name;
	public static String m_name,m_phone,m_address;
	@Override
	public void start(Stage primaryStage) {
		try {
			Main.primaryStage = primaryStage;						
			
			showMainView();		
			showMainItems();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showMainView() {
		try {
			mainLayout = FXMLLoader.load(getClass().getResource("view/MainView.fxml"));
			Scene scene = new Scene(mainLayout,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("통합관리");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
		
	public void showMainItems() {
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("view/MainItem.fxml"));
			mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}			
	}		

	public static void showCheckView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/CafeView.fxml"));
		AnchorPane checkView = loader.load();

		stage = new Stage();
		stage.setTitle("통계 화면");
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primaryStage);
		Scene scene = new Scene(checkView);
		stage.setScene(scene);
		stage.showAndWait();

	}
		
	public static void showOrderView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/CafeMenu.fxml"));
		AnchorPane orderView = loader.load();

		stage = new Stage();
		stage.setTitle("주문 화면");
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primaryStage);
		Scene scene = new Scene(orderView);
		stage.setScene(scene);
		stage.showAndWait();

	}
	
	public static void showPizzaMenuView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/PizzaMenu.fxml"));
		AnchorPane checkView = loader.load();

		stage = new Stage();
		stage.setTitle("Pizza Order");
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primaryStage);
		Scene scene = new Scene(checkView);
		stage.setScene(scene);
		stage.showAndWait();

	}	
	
	public static void showEmployeeAddStage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/AddNewEmployee.fxml"));
		BorderPane addNewEmployee = loader.load();
		
		Stage stage = new Stage();
		stage.setTitle("Add New Employee");
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primaryStage);
		Scene scene = new Scene(addNewEmployee);
		stage.setScene(scene);
		stage.showAndWait();
	
	}
	
	public void stopMainView() {
		primaryStage.close();
	}
	
	public static void stopstageView() {
		stage.close();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
