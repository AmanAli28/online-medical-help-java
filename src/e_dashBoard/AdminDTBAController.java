
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import z_database.database;
import z_database.doctor;
import main.Hospital;


public class AdminDTBAController implements Initializable {

    @FXML
    private TextField docid;
    @FXML
    private TextField fname;
    @FXML
    private TextField hosp;
    @FXML
    private TextField spec;
    @FXML
    private TextField doj;
//    @FXML
//    private TextField gen;
    @FXML
    private Pane paneApproval;
    @FXML
    private TableView<adminTable1> Table1;
    @FXML
    private TableColumn<adminTable1, String> tab_docid;
    @FXML
    private TableColumn<adminTable1, String> tab_name;
    @FXML
    private TableColumn<adminTable1, String> tab_hosp;
    @FXML
    private TableColumn<adminTable1, String> tab_doj;
    @FXML
    private TableColumn<adminTable1, String> tab_spec;
    @FXML
    private TableColumn<adminTable1, String> uname;
    @FXML
    private TextField username1;
    
    public static String un;
    ObservableList<adminTable1> oblist = FXCollections.observableArrayList();
    
    
    public void onEdit(){
        if(Table1.getSelectionModel().getSelectedItem() != null){
            adminTable1 obj =  Table1.getSelectionModel().getSelectedItem();
            System.out.println(obj.getTname());
            System.out.println(obj.getTdocid());
            
            un=obj.getTusername();
            
            username1.setText(un);
            docid.setText(obj.getTdocid());
            fname.setText(obj.getTname());
            hosp.setText(obj.getThospital());
            spec.setText(obj.getTspec());
            doj.setText(obj.getTdoj());
        }
    }
    public void function1(){
        tab_docid.setCellValueFactory(new PropertyValueFactory<>("tdocid"));
        tab_name.setCellValueFactory(new PropertyValueFactory<>("tname"));
        tab_hosp.setCellValueFactory(new PropertyValueFactory<>("thospital"));
        tab_doj.setCellValueFactory(new PropertyValueFactory<>("tdoj"));
        tab_spec.setCellValueFactory(new PropertyValueFactory<>("tspec"));
        uname.setCellValueFactory(new PropertyValueFactory<>("tusername"));
        
        ArrayList<doctor>temp16= Hospital.db.print_table();
        for (doctor doc : temp16){
            oblist.add(new adminTable1(doc.getId(), doc.getUsername(), doc.getName(), doc.getSpecialization(), doc.getHospital(), doc.getDate_join()));
            System.out.println(doc.getUsername() + ", " + doc.getName() + ", " + doc.getMob() +", " + doc.getHospital() + ", "+doc.getDate_join()
            + ", " + doc.getGender() + ", " + doc.getSpecialization() + ", " + doc.getEmail() + ", " + doc.getPassword() + ", " + doc.getId() + ", " + doc.getSecurity_que() + ", " + doc.getSecurity_ans() + ", " + doc.getApproved());
        }
        Table1.setItems(oblist);
        Table1.setOnMouseClicked((MouseEvent event) -> {
            if(event.getClickCount() > 1) {
                onEdit();
       } 
    });
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Table1.getItems().clear();
        function1();       
    }

    @FXML
    private void verifyButton(MouseEvent event) {
        boolean temp3 = Hospital.db.admin(un);// change to false to true
        if(temp3){
            System.out.println("worked");
            JOptionPane.showMessageDialog(null, "Data Approved Successfully!");
            Table1.getItems().clear();
            function1();
        }
            
        else
            System.out.println("not worked");
    }
    
}
