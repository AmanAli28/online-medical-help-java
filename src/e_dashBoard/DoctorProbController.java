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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import z_database.patient;
import main.Hospital;
import b_login.DoctorLoginController;

public class DoctorProbController implements Initializable {

    @FXML
    private TextField type;
    @FXML
    private TableView<doctorTable1> Table1;
    @FXML
    private TextField name;
    @FXML
    private JFXTextArea advise;
    @FXML
    private JFXTextArea prescription;
    @FXML
    private TableColumn<doctorTable1, String> tab_pid;
    @FXML
    private TableColumn<doctorTable1, String> tab_name;
    @FXML
    private TableColumn<doctorTable1, String> tab_type;
    @FXML
    private TableColumn<doctorTable1, String> tab_message;
    @FXML
    private TableColumn<doctorTable1, String> tab_symp;

    ObservableList<doctorTable1> list = FXCollections.observableArrayList();
    public static String ID;
    
    public void onEdit(){
        if(Table1.getSelectionModel().getSelectedItem() != null){
            doctorTable1 obj =  Table1.getSelectionModel().getSelectedItem();
            System.out.println(obj.getMprobid());
            
            ID = (String)obj.getMprobid();
            
        }
    }
    
    public void function1() {
        tab_pid.setCellValueFactory(new PropertyValueFactory<>("mprobid"));
        tab_name.setCellValueFactory(new PropertyValueFactory<>("mname"));
        tab_type.setCellValueFactory(new PropertyValueFactory<>("mtype"));
        tab_message.setCellValueFactory(new PropertyValueFactory<>("mmessage"));
        tab_symp.setCellValueFactory(new PropertyValueFactory<>("msymptoms"));
        
        String field = type.getText();
        
        ArrayList<patient> temp15 = Hospital.db.search_patient(field);
        for(patient pt : temp15){
            list.add(new doctorTable1(pt.getId(), pt.getName(), pt.getField(), pt.getMessage(), pt.getSymptoms()));
            System.out.println("ID = " + pt.getId() + ", Name=" + pt.getName() + " Username= " + pt.getUsername() + " Fileld=" +
                    pt.getField() + " Message=" + pt.getMessage() + " Symptoms=" +pt.getSymptoms() + " Resolved =" + pt.getResolved());
        }
        Table1.setItems(list);
        
        Table1.setOnMouseClicked((MouseEvent event) -> {
            if(event.getClickCount() > 1) {
                onEdit();
            } 
        });
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchButton(MouseEvent event) {
        function1();
    }

    @FXML
    private void submitButton(MouseEvent event) {
        String NAME = name.getText();
        String ADVISE = advise.getText();
        String PRESCRIPTION = prescription.getText();
        
        boolean temp5 = Hospital.db.register_doc_dashboard(ID,NAME,PRESCRIPTION,ADVISE,DoctorLoginController.usernamegg);
            if(temp5)
                System.out.println("data added successfully");
            else
                System.out.println("unable to add data");
    }
    
}
