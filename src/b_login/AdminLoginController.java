/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import main.Hospital;


public class AdminLoginController implements Initializable {

    @FXML
    private JFXPasswordField pwd;
    @FXML
    private JFXTextField username;

    
    
    
    @FXML
    private void closeButton(MouseEvent event) {
        Platform.exit();
        System.exit(0);
    }
    
    @FXML
    private void loginButton(MouseEvent event) throws IOException {
        String un = username.getText();
        String pw = pwd.getText();
        
        if (un.equals("admin") && pw.equals("admin")) {
            JOptionPane.showMessageDialog(null, "Login successful!");
            
            Parent fxml;
            fxml = FXMLLoader.load(getClass().getResource("/e_dashBoard/adminDash.fxml"));
            Scene s = new Scene(fxml);
        
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(s);
            window.show();
        }
        else {
            JOptionPane.showMessageDialog(null, "something went wrong!");
            
        }
    }
    @FXML
    private void backtoMain(MouseEvent event) throws IOException {
        //Hospital.stage.getScene().setRoot(FXMLLoader.load(getClass().getResource("/a_frontPage/startPage.fxml")));
        Parent fxml;
        fxml = FXMLLoader.load(getClass().getResource("/a_frontPage/startPage.fxml"));
        Scene s = new Scene(fxml);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(s);
        window.show();
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
