package phone.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import phone.Main;
import phone.mysqlconnect;

public class BusController {
	Connection conn;
	PreparedStatement pst = null;
	ResultSet srs;
	int seatno = 0;
	int price;
	AnchorPane root;

	Main main = new Main();
    @FXML
    private ComboBox<String> comboPrice;
    
    ObservableList<String> comboBoxList = 
			FXCollections.observableArrayList("유아 : 2,000원","학생 : 3,000원","일반 : 5,000원");
	
	@FXML
	private void initialize() {
		conn = mysqlconnect.ConnectDb();
		try {
			pst = conn.prepareStatement("select * from busses where date =? and seatno=?");			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		comboPrice.setItems(comboBoxList);
	}
	

    @FXML
    private TextField txtcustomer;

    @FXML
    private TextField txtprice;

    @FXML
    private DatePicker txtdate;

    @FXML
    private TextArea txtbill;
    

    
    @FXML
    void onClickCombo(ActionEvent event) {
		int a = comboPrice.getSelectionModel().getSelectedIndex(); 
			if(a==0) price = 2000;
			if(a==1) price = 3000;
			if(a==2) price = 5000;
    }

    @FXML
    void onClick1(ActionEvent event) {
    	seatno = 1;
    	JOptionPane.showMessageDialog(null, seatno);
    }

    @FXML
    void onClick10(ActionEvent event) {
    	seatno = 10;
    	JOptionPane.showMessageDialog(null, seatno);
    }

    @FXML
    void onClick11(ActionEvent event) {
    	seatno = 11;
    	JOptionPane.showMessageDialog(null, seatno);
    }

    @FXML
    void onClick12(ActionEvent event) {
    	seatno = 12;
    	JOptionPane.showMessageDialog(null, seatno);
    }

    @FXML
    void onClick2(ActionEvent event) {
    	seatno = 2;
    	JOptionPane.showMessageDialog(null, seatno);
    }

    @FXML
    void onClick3(ActionEvent event) {
    	seatno = 3;
    	JOptionPane.showMessageDialog(null, seatno);
    }

    @FXML
    void onClick4(ActionEvent event) {
    	seatno = 4;
    	JOptionPane.showMessageDialog(null, seatno);
    }

    @FXML
    void onClick5(ActionEvent event) {
    	seatno = 5;
    	JOptionPane.showMessageDialog(null, seatno);
    }

    @FXML
    void onClick6(ActionEvent event) {
    	seatno = 6;
    	JOptionPane.showMessageDialog(null, seatno);
    }

    @FXML
    void onClick7(ActionEvent event) {
    	seatno = 7;
    	JOptionPane.showMessageDialog(null, seatno);
    }

    @FXML
    void onClick8(ActionEvent event) {
    	seatno = 8;
    	JOptionPane.showMessageDialog(null, seatno);
    }

    @FXML
    void onClick9(ActionEvent event) {
    	seatno = 9;
    	JOptionPane.showMessageDialog(null, seatno);
    }
    
    @FXML
    void onClickContinue(ActionEvent event) {
    	main.showMainView();
    }
    
    @FXML
    void onClickBook(ActionEvent event) {
    	String customer = txtcustomer.getText();
    	int seat = seatno;
 //   	price = Integer.parseInt(txtprice.getText());
    	
    	int year = (txtdate.getValue().getYear());
    	int month = (txtdate.getValue().getMonthValue());
    	int day = (txtdate.getValue().getDayOfMonth());
    	
    	String date = ""+year+"-"+month+"-"+day;
    	
    	System.out.println(seatno);
    	System.out.println(month);
    	
		try {
			pst.setString(1, date);
			pst.setInt(2, seat);
			srs = pst.executeQuery();
			
			if(srs.next()) {
				JOptionPane.showMessageDialog(null, "This seat is Already booked!");
			} else {
				pst = conn.prepareStatement("insert into busses (name, seatno, price,date) values (?,?,?,?)");
				pst.setString(1, customer);
				pst.setInt(2, seat);
				pst.setInt(3, price);
				pst.setString(4, date);
				int k =pst.executeUpdate();
				
				if(k==1) {
					JOptionPane.showMessageDialog(null, "Seat Booked!");
					bill();
				} else {
					JOptionPane.showMessageDialog(null, "Some error!");
				}

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
    }
    
    @FXML
    void onClickCheck(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("../view/BusCheck.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void onClickStop(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("../view/MainItem.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    public void bill() {
    	String customer = txtcustomer.getText();
    	int seat = seatno;
   // 	int price = Integer.parseInt(txtprice.getText());
    	
    	int year = (txtdate.getValue().getYear());
    	int month = (txtdate.getValue().getMonthValue());
    	int day = (txtdate.getValue().getDayOfMonth());
    	
    	String date = ""+year+"-"+month+"-"+day;
    	
    	txtbill.setText(txtbill.getText()+"**********************************************************\n");
    	txtbill.setText(txtbill.getText()+"****************    bill    **********************************\n");
    	txtbill.setText(txtbill.getText()+"**********************************************************\n\n\n");
    	txtbill.setText(txtbill.getText()+"Customer" + "\t"+ customer + "\n");
    	txtbill.setText(txtbill.getText()+"SeatNo" + "\t"+ seat + "\n");
    	txtbill.setText(txtbill.getText()+"Prices" + "\t"+ price + "\n");
    	txtbill.setText(txtbill.getText()+"Date" + "\t"+ date + "\n\n\n");
    	txtbill.setText(txtbill.getText()+"**********************************************************\n");
    	txtbill.setText(txtbill.getText()+"**************** Thank you Come Again******************\n");
    }

}