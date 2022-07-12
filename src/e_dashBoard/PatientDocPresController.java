/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e_dashBoard;

import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import z_database.doctor;
import main.Hospital;
import z_database.patient;
import b_login.PatientLoginController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;

public class PatientDocPresController implements Initializable {

    @FXML
    private JFXTextArea textArea;
    @FXML
    private TableView<patientTable1> tablegg;
    @FXML
    private TableColumn<patientTable1, String> tab_pid;
    @FXML
    private TableColumn<patientTable1, String> tab_name;
    @FXML
    private TableColumn<patientTable1, String> tab_parea;
    @FXML
    private TableColumn<patientTable1, String> tab_sym;
    @FXML
    private TableColumn<patientTable1, String> tab_mess;

    ObservableList<patientTable1> oblist = FXCollections.observableArrayList();
    public static String id;
    
    
    public void onEdit(){
        if(tablegg.getSelectionModel().getSelectedItem() != null){
            patientTable1 obj =  tablegg.getSelectionModel().getSelectedItem();
            System.out.println(obj.getmProbid());
            
            id=obj.getmProbid();
            textArea.setText("");
            ArrayList<doctor> temp14 = Hospital.db.print_doctor(id);
            for(doctor pt : temp14){
                textArea.setText(" Problem ID: " + pt.getId() + "\n Doctor Name: " + pt.getName() 
                    + "\n Advise: " + pt.getAdvise() + "\n Prescription: " + pt.getPrescription() + "\n\n\n");
                System.out.println("ID = " + pt.getId() + ", Name=" + pt.getName() + " Username= " + pt.getUsername() + " prescription=" + pt.getPrescription() + " advise=" + pt.getAdvise());
            }
        }
    }
    
    public void function1(){
        tab_pid.setCellValueFactory(new PropertyValueFactory<>("mProbid"));
        tab_name.setCellValueFactory(new PropertyValueFactory<>("mName"));
        tab_parea.setCellValueFactory(new PropertyValueFactory<>("mSpec"));
        tab_sym.setCellValueFactory(new PropertyValueFactory<>("mSymp"));
        tab_mess.setCellValueFactory(new PropertyValueFactory<>("mMessage"));
        ArrayList<patient> temp13 = Hospital.db.patient_username(PatientLoginController.username1);//print patient data using username
        for(patient pt : temp13){
            oblist.add(new patientTable1(pt.getId(), pt.getName(), pt.getField(), pt.getSymptoms(), pt.getMessage()));
            System.out.println("ID = " + pt.getId() + ", Name=" + pt.getName() + " Username= " + pt.getUsername() + " Fileld=" +
                    pt.getField() + " Message=" + pt.getMessage() + " Symptoms=" +pt.getSymptoms() + " Resolved =" + pt.getResolved());
        }
        tablegg.setItems(oblist);
        tablegg.setOnMouseClicked((MouseEvent event) -> {
            if(event.getClickCount() > 1) {
                onEdit();
            }
        });
    }
    
    public void function2() {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        function1();
    }    
    
}
