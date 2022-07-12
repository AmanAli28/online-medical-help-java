
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import z_database.database;
import main.Hospital;



public class AdminDashController implements Initializable {

    @FXML
    private Pane mainpane;
    @FXML
    private Label docCount;
    @FXML
    private Label patCount;

    
    public void count() {
        int temp9 = Hospital.db.count_patient();
        System.out.println(temp9);
        patCount.setText(""+temp9);
        int temp10 = Hospital.db.count_doc();
        System.out.println(temp10);
        docCount.setText(""+temp10);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        count();
    }    

    @FXML
    private void dashboardButton(MouseEvent event) throws IOException {
        Parent fxml;
        fxml = FXMLLoader.load(getClass().getResource("/e_dashBoard/adminDash.fxml"));
        Scene s = new Scene(fxml);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(s);
        window.show();
    }

    @FXML
    private void patientsButton(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/e_dashBoard/adminPatient.fxml"));
        mainpane.getChildren().removeAll();
        mainpane.getChildren().addAll(fxml);
    }

    @FXML
    private void doctors_to_be_approved(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/e_dashBoard/adminDTBA.fxml"));
        mainpane.getChildren().removeAll();
        mainpane.getChildren().addAll(fxml);
    }

    @FXML
    private void doctorsButton(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/e_dashBoard/adminDoctor.fxml"));
        mainpane.getChildren().removeAll();
        mainpane.getChildren().addAll(fxml);
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
