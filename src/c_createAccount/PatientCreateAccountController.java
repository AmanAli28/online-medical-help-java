/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_createAccount;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import z_database.database;

/**
 * FXML Controller class
 *
 * @author amana
 */
public class PatientCreateAccountController implements Initializable {

    @FXML
    private TextField fullname;
    @FXML
    private TextField adhNo;        // forgot to add in database
    @FXML
    private TextField mobNo;
    @FXML
    private JFXComboBox<String> gender;
    @FXML
    private JFXDatePicker DOB;      // forgot to add in database
    @FXML
    private TextField address;
    @FXML
    private TextField prevAllergies;
    @FXML
    private JFXComboBox<String> securityQ;
    @FXML
    private TextField securityAns;
    @FXML
    private PasswordField pwd;
    @FXML
    private TextField onTreatment;
    @FXML
    private TextField email;
    @FXML
    private TextField username;

    ObservableList<String> list1 = FXCollections.observableArrayList("First pet's name?", "Mother's middle name?", "Your birthplace?", "Your nick name?");
    ObservableList<String> list2 = FXCollections.observableArrayList("Male", "Female", "Other");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        securityQ.setItems(list1);
        gender.setItems(list2);
    }    

    @FXML
    private void backToLogin(MouseEvent event) throws IOException {
        Parent fxml;
        fxml = FXMLLoader.load(getClass().getResource("/b_login/patientLogin.fxml"));
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
    private void createAccountButton(MouseEvent event) throws IOException {
        String name = fullname.getText(),
               gendr = gender.getValue(),
               username1 = username.getText(),
               password = pwd.getText(),
               email1 = email.getText(),
               seq = securityQ.getValue(),
               seqans = securityAns.getText(),
               mob = mobNo.getText(),
               add1 = address.getText(),
               allergy = prevAllergies.getText(),
               pre_med = onTreatment.getText(),
               dob1 = ((TextField)DOB.getEditor()).getText(),
               aadhar = adhNo.getText();

        database db = new database();
        boolean temp;
        boolean db_var = db.open();
        if (db_var)
            System.out.println("database open");
        else
            System.out.println("not open");
        
        temp = db.register_patient(name,gendr,password,email1,username1,allergy,pre_med,mob,add1,seq,seqans, dob1, aadhar);//patient registration
        if(temp){
            System.out.println("user registration successfully");
            JOptionPane.showMessageDialog(null, "Registration Successful!");
            Parent fxml;
            fxml = FXMLLoader.load(getClass().getResource("/b_login/patientLogin.fxml"));
            Scene s = new Scene(fxml);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(s);
            window.show();
        }
        else{
            System.out.println("unable to register");
        }
            
    }
    
}
