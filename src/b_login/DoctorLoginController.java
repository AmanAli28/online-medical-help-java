
package b_login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import z_database.database;
import main.Hospital;

public class DoctorLoginController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField pwd;

    public static String usernamegg;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginButton(MouseEvent event) throws IOException {
        String username1 = username.getText(),
               password = pwd.getText();

        boolean temp2 = Hospital.db.doc_login(password,username1);//login

        if(temp2){
            usernamegg = username1;
            System.out.println("login success");
            JOptionPane.showMessageDialog(null, "Welcome Doc!");
            Parent fxml;
            fxml = FXMLLoader.load(getClass().getResource("/e_dashBoard/doctorDash.fxml"));
            Scene s = new Scene(fxml);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(s);
            window.show();
        }
        else{
            System.out.println("not login");
            JOptionPane.showMessageDialog(null, "Not Registered or not approved!");
        }
    }

    @FXML
    private void backtoMain(MouseEvent event) throws IOException {
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
    private void forgotPasswordButton(MouseEvent event) throws IOException {
        Parent fxml;
        fxml = FXMLLoader.load(getClass().getResource("/d_forgotPassword/forgotPassword.fxml"));
        Scene s = new Scene(fxml);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(s);
        window.show();
    }

    @FXML
    private void createAccountButton(MouseEvent event) throws IOException {
        Parent fxml;
        fxml = FXMLLoader.load(getClass().getResource("/c_createAccount/doctorCreateAccount.fxml"));
        Scene s = new Scene(fxml);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(s);
        window.show();
    }
    
}
