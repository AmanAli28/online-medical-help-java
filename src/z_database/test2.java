/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_database;

import b_login.PatientLoginController;
import java.util.ArrayList;

/**
 *
 * @author amana
 */
public class test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        database db = new database();
        boolean db_var = db.open();
        if (db_var)
            System.out.println("database open");
        else
            System.out.println("not open");
        
        ArrayList<patient> temp13 = db.patient_username("gg");//print patient data using username
        for(patient pt : temp13){
            System.out.println("ID = " + pt.getId() + ", Name=" + pt.getName() + " Username= " + pt.getUsername() + " Fileld=" +
                    pt.getField() + " Message=" + pt.getMessage() + " Symptoms=" +pt.getSymptoms() + " Resolved =" + pt.getResolved());
        }
        
        

    }
}
