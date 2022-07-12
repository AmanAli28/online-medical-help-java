/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e_dashBoard;

import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import main.stuff;
import z_database.database;
import b_login.PatientLoginController;
import main.Hospital;

public class PatientProbController implements Initializable {

    @FXML
    private TextField docid;
    @FXML
    private TextField fname;
    @FXML
    private TextField problem;
    @FXML
    private JFXTextArea symp;
    @FXML
    private JFXTextArea message;
    
    stuff s = new stuff();
    public static String id1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        docid.setText(s.RR()+"");
    }    

    @FXML
    private void submitButton(MouseEvent event) {
        id1 = docid.getText();
        String fname1 = fname.getText();
        String problem1 = problem.getText();
        String symp1 = symp.getText();
        String message1 = message.getText();
        String uname = PatientLoginController.username1;
        
        
        
        boolean temp6 = Hospital.db.registration_patient_dashboard(id1,fname1,uname,problem1,message1,symp1);
        if(temp6)
            System.out.println("data added successfully");
        else
            System.out.println("unable to add data");
        
    }
    
}
