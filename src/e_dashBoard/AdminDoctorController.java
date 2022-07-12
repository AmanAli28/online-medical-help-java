/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e_dashBoard;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import z_database.doctor;

import main.Hospital;

public class AdminDoctorController implements Initializable {

    @FXML
    private TableColumn<adminTable3, String> tusername;
    @FXML
    private TableColumn<adminTable3, String> tname;
    @FXML
    private TableColumn<adminTable3, String> tmobno;
    @FXML
    private TableColumn<adminTable3, String> thospital;
    @FXML
    private TableColumn<adminTable3, String> tdoj;
    @FXML
    private TableColumn<adminTable3, String> tgender;
    @FXML
    private TableColumn<adminTable3, String> tspeciallization;
    @FXML
    private TableColumn<adminTable3, String> temail;
    @FXML
    private TableColumn<adminTable3, String> tid;
    @FXML
    private TableColumn<adminTable3, String> tapproved;
    @FXML
    private TableView<adminTable3> docTable;
    
    ObservableList<adminTable3> list = FXCollections.observableArrayList();

    public void function1() {
        tusername.setCellValueFactory(new PropertyValueFactory<>("musername"));
        tname.setCellValueFactory(new PropertyValueFactory<>("mname"));
        tmobno.setCellValueFactory(new PropertyValueFactory<>("mmobno"));
        thospital.setCellValueFactory(new PropertyValueFactory<>("mhospital"));
        tdoj.setCellValueFactory(new PropertyValueFactory<>("mdoj"));
        tgender.setCellValueFactory(new PropertyValueFactory<>("mgender"));
        tspeciallization.setCellValueFactory(new PropertyValueFactory<>("mspecialization"));
        temail.setCellValueFactory(new PropertyValueFactory<>("memail"));
        tid.setCellValueFactory(new PropertyValueFactory<>("mid"));
        tapproved.setCellValueFactory(new PropertyValueFactory<>("mapproved"));
        
        ArrayList<doctor>temp17 = Hospital.db.print_doc_table();
        for (doctor doc : temp17) {
            list.add(new adminTable3(doc.username1, doc.getName(), doc.getMob(), doc.getHospital(),
                                     doc.getDate_join(), doc.getGender(), doc.getSpecialization(),
                                     doc.getEmail(), doc.getId(), doc.getApproved()));
            System.out.println(doc.getUsername() + ", " + doc.getName() + ", " 
                    + doc.getMob() +", " + doc.getHospital() + ", "+doc.getDate_join()
                    + ", " + doc.getGender() + ", " + doc.getSpecialization() + ", " + doc.getEmail() + ", " 
                    + doc.getPassword() + ", " + doc.getId() + ", " 
                    + doc.getSecurity_que() + ", " + doc.getSecurity_ans() + ", " + doc.getApproved());
        }
        docTable.setItems(list);        
    }
    
    

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        function1();
    }    
    
}
