  
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


public class DoctorCreateAccountController implements Initializable {

    @FXML
    private TextField fullname;
    @FXML
    private TextField hospital;
    @FXML
    private TextField mobNo;
    @FXML
    private JFXComboBox<String> gender;
    @FXML
    private JFXDatePicker DOJoining;
    @FXML
    private TextField docID;
    @FXML
    private TextField specialization;
    @FXML
    private JFXComboBox<String> securityQ;
    @FXML
    private TextField securityAns;
    @FXML
    private PasswordField pwd;
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
        fxml = FXMLLoader.load(getClass().getResource("/b_login/doctorLogin.fxml"));
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
               id = docID.getText(),
               date_join = ((TextField)DOJoining.getEditor()).getText(),
               spec = specialization.getText(),
               hosp = hospital.getText();

        database db = new database();
        boolean db_var = db.open();
        if (db_var)
            System.out.println("database open");
        else
            System.out.println("not open");

        boolean temp1 = db.register_doc(name,date_join,email1,gendr,id,hosp,spec,seq,username1,password,mob,seqans);//doc registration
        if(temp1){
            System.out.println("doc register");
            JOptionPane.showMessageDialog(null, "Registration Successful! wait for approval.");
            Parent fxml;
            fxml = FXMLLoader.load(getClass().getResource("/b_login/doctorLogin.fxml"));
            Scene s = new Scene(fxml);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(s);
            window.show();
        }
            
        
        else{
            JOptionPane.showMessageDialog(null, "Registration failed! Something went wrong.");
            System.out.println("doc not register");
        }
            
    }
    
}
