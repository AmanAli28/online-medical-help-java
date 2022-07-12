
package e_dashBoard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import b_login.PatientLoginController;
import java.util.ArrayList;
import z_database.database;
import z_database.patient;
import z_database.doctor;
import main.Hospital;

public class PatientDashController implements Initializable {

    @FXML
    private Label nameHeading;
    @FXML
    private AnchorPane ggPane;
    @FXML
    private Label lab_name;
    @FXML
    private Label lab_email;
    @FXML
    private Label lab_dob;
    @FXML
    private Label lab_mob;

    public void function1(){
        
        System.out.println(PatientLoginController.username1);
        
        ArrayList<patient> temp11 = Hospital.db.patientuserinfo(PatientLoginController.username1);

        for(patient pt : temp11){
            nameHeading.setText(pt.getName());
            lab_name.setText(pt.getName());
            lab_email.setText(pt.getEmail());
            lab_dob.setText(pt.getDob());
            lab_mob.setText(pt.getMob());
            System.out.println("Name = " + pt.getName()+" , Email = " + pt.getEmail() + " , DOB"+pt.getDob() + ", mobile" + pt.getMob());
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        function1();// TODO
    }    

    @FXML
    private void dashboardButton(MouseEvent event) throws IOException {
        Parent fxml;
        fxml = FXMLLoader.load(getClass().getResource("/e_dashBoard/patientDash.fxml"));
        Scene s = new Scene(fxml);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(s);
        window.show();
    }

    @FXML
    private void addproblemButton(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/e_dashBoard/patientProb.fxml"));
        ggPane.getChildren().removeAll();
        ggPane.getChildren().addAll(fxml);
    }

    @FXML
    private void doctorPresButton(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/e_dashBoard/patientDocPres.fxml"));
        ggPane.getChildren().removeAll();
        ggPane.getChildren().addAll(fxml);
    }

    @FXML
    private void logoutButton(MouseEvent event) throws IOException {
        int result = JOptionPane.showConfirmDialog(null,"Sure? You want to exit?",
                                                    "Swing Tester",
                                                    JOptionPane.YES_NO_OPTION,
                                                    JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
               Parent fxml;
                fxml = FXMLLoader.load(getClass().getResource("/a_frontPage/startPage.fxml"));
                Scene s = new Scene(fxml);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(s);
                window.show();
            }
    }
    
}
