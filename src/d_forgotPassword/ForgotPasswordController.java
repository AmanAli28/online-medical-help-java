/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d_forgotPassword;

import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import z_database.database;


public class ForgotPasswordController implements Initializable {

    @FXML
    private JFXComboBox<String> securityQ;
    @FXML
    private TextField securityAns;
    @FXML
    private TextField email;
    @FXML
    private JFXComboBox<String> accType;

    ObservableList<String> list1 = FXCollections.observableArrayList("First pet's name?", "Mother's middle name?", "Your birthplace?", "Your nick name?");
    ObservableList<String> list2 = FXCollections.observableArrayList("Patient", "Doctor");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        securityQ.setItems(list1);
        accType.setItems(list2);
    }

    @FXML
    private void backToMain(MouseEvent event) throws IOException {
        Parent fxml;
        fxml = FXMLLoader.load(getClass().getResource("/a_frontPage/startPage.fxml"));
        Scene s = new Scene(fxml);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(s);
        window.show();
    }

    @FXML
    private void closeButton(MouseEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void restoreButton(MouseEvent event) throws IOException {
        String secq = securityQ.getValue(),
               secans = securityAns.getText(),
               emal = email.getText(),
               acctyp = accType.getValue();

        database db = new database();

        boolean db_var = db.open();
        if (db_var)
            System.out.println("database open");
        else
            System.out.println("not open");

        String temp2 = db.forgot_pass(emal, secq, secans, acctyp);//login
        System.out.println("your pass: "+temp2);
        JOptionPane.showMessageDialog(null, "Your Password: " + temp2);
        
        Parent fxml;
        fxml = FXMLLoader.load(getClass().getResource("/a_frontPage/startPage.fxml"));
        Scene s = new Scene(fxml);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(s);
        window.show();
//        else{
//            System.out.println("not login");
//            JOptionPane.showMessageDialog(null, "Not Registered or not approved!");
//        }
    }
    
}
