
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
import b_login.DoctorLoginController;
import java.util.ArrayList;
import z_database.doctor;
import main.Hospital;

public class DoctorDashController implements Initializable {

    @FXML
    private Label nameHeading;
    @FXML
    private Label lab_name;
    @FXML
    private Label lab_email;
    @FXML
    private Label lab_doj;
    @FXML
    private Label lab_mob;
    @FXML
    private Pane mainpane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<doctor>temp18 = Hospital.db.doc_print(DoctorLoginController.usernamegg);
        for (doctor doc : temp18){
            nameHeading.setText(doc.getName());
            lab_name.setText(doc.getName());
            lab_email.setText(doc.getEmail());
            lab_doj.setText(doc.getDate_join());
            lab_mob.setText(doc.getMob());
            System.out.println(doc.getUsername() + ", " + doc.getName() + ", " + doc.getMob() +", " + doc.getHospital() + ", "+doc.getDate_join()
                    + ", " + doc.getGender() + ", " + doc.getSpecialization() + ", " + doc.getEmail() + ", " + doc.getPassword() + ", " + doc.getId() + ", " + doc.getSecurity_que() + ", " + doc.getSecurity_ans() + ", " + doc.getApproved());
        }
    }    

    @FXML
    private void dashboardButton(MouseEvent event) throws IOException {
        Parent fxml;
        fxml = FXMLLoader.load(getClass().getResource("/e_dashBoard/doctorDash.fxml"));
        Scene s = new Scene(fxml);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(s);
        window.show();
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

    @FXML
    private void problemsButton(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/e_dashBoard/doctorProb.fxml"));
        mainpane.getChildren().removeAll();
        mainpane.getChildren().addAll(fxml);
    }
    
}
