package main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import z_database.database;

public class Hospital extends Application {
    // public static Stage stage = null;
    public static database db = new database();
    private double xOffset = 0;
    private double yOffset = 0;
    private String startpage = "/a_frontPage/startPage.fxml";
    private String testpage = "/c_createAccount/patientCreateAccount.fxml";
    private String dash = "/e_dashBoard/adminDash.fxml";
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(startpage));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/main/style.css").toExternalForm());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        // this.stage = stage;
        stage.show();
        
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });
        
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }

    public static void main(String[] args) {
        
        boolean temp;
        boolean db_var = db.open();
        if (db_var)
            System.out.println("database open");
        else
            System.out.println("not open");
        launch(args);
    }
    
}
