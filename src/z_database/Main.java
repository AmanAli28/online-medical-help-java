package z_database;

import z_database.database;
import z_database.doctor;
import z_database.patient;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String name,gender,username1,password,email,seq,spec,hospital,mob,add1,id,date_join,seqans,app,allergy,pre_med;

        database db = new database();

        Scanner s = new Scanner(System.in);
        boolean temp;


        boolean db_var = db.open();
        if (db_var)
            System.out.println("database open");
        else
            System.out.println("not open");

        System.out.println("\n Enter the name of the user:");
        name = s.nextLine();
        System.out.println("\n Enter the gender of the user");
        gender = s.nextLine();
        System.out.println("\n Enter the password ");
        password = s.nextLine();
        System.out.println("\n Enter the username");
        username1 = s.nextLine();
        System.out.println("\n Enter the email");
        email = s.nextLine();

        System.out.println("\n Enter mobile number");
        mob = s.nextLine();
        System.out.println("\n Enter hospital");
        hospital = s.nextLine();
        System.out.println("\n Enter doctorid");
        id = s.nextLine();
        System.out.println("\n Enter specialization");
        spec = s.nextLine();
        System.out.println("\n Enter date_join");
        date_join = s.nextLine();




        System.out.println("\n security ");
        seq = s.nextLine();
        System.out.println("\n seqans");
        seqans = s.nextLine();
        System.out.println("\n Enter allergy");
        allergy = s.nextLine();
        System.out.println("\n pre_med");
        pre_med = s.nextLine();
        System.out.println("\n address");
        add1 = s.nextLine();
        System.out.println("\n Enter adhar");
        String ad = s.nextLine();
        System.out.println("\n ENter date of birth ");
        String dob = s.nextLine();


        temp = db.register_patient(name,gender,password,email,username1,allergy,pre_med,mob,add1,seq,seqans,dob,ad);//patient registration
        if(temp)
            System.out.println("user registration successfully");
        else
            System.out.println("unable to register");
        boolean temp1 = db.register_doc(name,date_join,email,gender,id,hospital,spec,seq,username1,password,mob,seqans);//doc registration

        if(temp1)
            System.out.println("doc register");
        else
            System.out.println("doc not register");

        boolean temp2 = db.pt_login(password,username1);//login

        if(temp2)
            System.out.println("login success");
        else
            System.out.println("not login");

        boolean temp3 = db.admin(username1);// change to false to true
        if(temp3)
            System.out.println("worked");
        else
            System.out.println("not worked");



        String pass = db.forgot_pass(email,seq,seqans,"doc");//forgotpassword for patient
        System.out.println(pass);

        String pres,advise,pt_id,pt_field,pt_message,pt_symptoms;


        System.out.println("\n ENter  doc prescription");
        pres= s.nextLine();
        System.out.println("\n Enter doc advise");
        advise = s.nextLine();
        System.out.println("\n Enter patient id");
        pt_id = s.nextLine();
        System.out.println("\n Enter patient filed");
        pt_field = s.nextLine();
        System.out.println("\n ENter patient message");
        pt_message = s.nextLine();
        System.out.println("\n Enter patient symptoms");
        pt_symptoms = s.nextLine();




        boolean temp5 = db.register_doc_dashboard(id,name,pres,advise,username1);
        if(temp5)
            System.out.println("user registration successfully");
        else
            System.out.println("unable to register");
        boolean temp6 = db.registration_patient_dashboard(pt_id,name,username1,pt_field,pt_message,pt_symptoms);
        if(temp6)
            System.out.println("user registration successfully");
        else
            System.out.println("unable to register");

        boolean temp7 = db.resolve(pt_id);
        if(temp7)
            System.out.println(" successfully");
        else
            System.out.println("unable");


        int temp9 = db.count_patient();
        System.out.println(temp9);

        int temp10 = db.count_doc();
        System.out.println(temp10);


        
        ArrayList<patient> temp11 = db.patientuserinfo(username1);
        for(patient pt : temp11){
            System.out.println("Name = " + pt.getName()+" , Email = " + pt.getEmail() + " , DOB"+pt.getDob() + ", mobile" + pt.getMob());
        }

        
        ArrayList<patient> temp12 = db.patient_view(pt_id);// print patient using id
        for(patient pt : temp12){
            System.out.println("ID = " + pt.getId() + ", Name=" + pt.getName() + " Username= " + pt.getUsername() + " Fileld=" +
                    pt.getField() + " Message=" + pt.getMessage() + " Symptoms=" +pt.getSymptoms() + " Resolved =" + pt.getResolved());
        }

        ArrayList<patient> temp13 = db.patient_username(username1);//print patient data using username
        for(patient pt : temp13){
            System.out.println("ID = " + pt.getId() + ", Name=" + pt.getName() + " Username= " + pt.getUsername() + " Fileld=" +
                    pt.getField() + " Message=" + pt.getMessage() + " Symptoms=" +pt.getSymptoms() + " Resolved =" + pt.getResolved());
        }

        ArrayList<doctor> temp14 = db.print_doctor(id);
        for(doctor pt : temp14){
            System.out.println("ID = " + pt.getId() + ", Name=" + pt.getName() + " Username= " + pt.getUsername() + " prescription=" + pt.getPrescription() + " advise=" + pt.getUsername());
        }

        
        
        ArrayList<patient> temp15 = db.search_patient(pt_field);
        for(patient pt : temp15){
            System.out.println("ID = " + pt.getId() + ", Name=" + pt.getName() + " Username= " + pt.getUsername() + " Fileld=" +
                    pt.getField() + " Message=" + pt.getMessage() + " Symptoms=" +pt.getSymptoms() + " Resolved =" + pt.getResolved());
        }

        
        ArrayList<doctor>temp16= db.print_table();
        for (doctor doc : temp16){
            System.out.println(doc.getUsername() + ", " + doc.getName() + ", " + doc.getMob() +", " + doc.getHospital() + ", "+doc.getDate_join()
            + ", " + doc.getGender() + ", " + doc.getSpecialization() + ", " + doc.getEmail() + ", " + doc.getPassword() + ", " + doc.getId() + ", " + doc.getSecurity_que() + ", " + doc.getSecurity_ans() + ", " + doc.getApproved());
        }

        ArrayList<doctor>temp17 = db.print_doc_table();
        for (doctor doc : temp17){
            System.out.println(doc.getUsername() + ", " + doc.getName() + ", " + doc.getMob() +", " + doc.getHospital() + ", "+doc.getDate_join()
                    + ", " + doc.getGender() + ", " + doc.getSpecialization() + ", " + doc.getEmail() + ", " + doc.getPassword() + ", " + doc.getId() + ", " + doc.getSecurity_que() + ", " + doc.getSecurity_ans() + ", " + doc.getApproved());
        }

        ArrayList<doctor>temp18 = db.doc_print(username1);
        for (doctor doc : temp18){
            System.out.println(doc.getUsername() + ", " + doc.getName() + ", " + doc.getMob() +", " + doc.getHospital() + ", "+doc.getDate_join()
                    + ", " + doc.getGender() + ", " + doc.getSpecialization() + ", " + doc.getEmail() + ", " + doc.getPassword() + ", " + doc.getId() + ", " + doc.getSecurity_que() + ", " + doc.getSecurity_ans() + ", " + doc.getApproved());
        }

        ArrayList<patient>temp19 = db.print_patient();
        for(patient pt : temp19){
            System.out.println(pt.getUsername()+", " + pt.getPassword() + ", " + pt.getName()+", "+ pt.getGender() + ", " + pt.getAllergy() + ", " +
                    ", " + pt.getPre_med_history()+", "+pt.getAdd()+", " + pt.getDob() + ", "+ pt.getAdhar());
        }










    }
}
