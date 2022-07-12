package z_database;

import java.sql.*;
import java.util.ArrayList;


public class database {
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\amana\\OneDrive\\Desktop\\MySpace\\JavaProject\\Hospital\\src\\z_database\\gg.db";
    Connection connection;

    public static final String PT_REGISTRATION_TABLE = "registration";
    public static final String PT_COLUMN_NAME = "name";
    public static final String PT_COLUMN_PASSWORD = "password";
    public static final String PT_COLUMN_GENDER = "gender";
    public static final String PT_COLUMN_EMAIL = "email";
    public static final String PT_COLUMN_USER = "username1";
    public static final String PT_COLUMN_ADD = "add1";
    public static final String PT_ALLERGY = "allergy";
    public static final String PT_HISTORY = "pre_med_history";
    public static final String PT_mob = "mob";
    public static final String PT_SECQ = "security_que";
    public static final String PT_SECA = "security_ans";
    public static final String PT_DOB = "dob";
    public static final String PT_AADHAR = "aadhar";


    public static final String doc_registration_table = "doc_registration";
    public static final String doc_name = "fullname";
    public static final String doc_mob = "mobile_no";
    public static final String doc_hospital = "hospital";
    public static final String doc_datejoin = "Date";
    public static final String doc_gender = "gender";
    public static final String doc_spec = "specialization";
    public static final String doc_email = "email";
    public static final String doc_password = "password";
    public static final String doc_id = "id";
    public static final String doc_security = "security";
    public static final String doc_user = "username";
    public static final String doc_seqans = "security_ans";
    public static final String doc_approved = "approved";

    public static final String dashboard_table = "dashboard_doc";
    public static final String doc_prescription = "prescription";
    public static final String doc_advise = "advise";

    public static final String dashboard_patient = "dashboard_patient";
    public static final String PT_ID = "patient_id";
    public static final String PT_FIELD = "field";
    public static final String PT_MESSAGE = "message";
    public static final String PT_SYMPTOMS = "symptoms";
    public static final String PT_RESOLVED = "resolved";


    public static final String CREATE_REGISTRATION_TABLE = "create table if not exists " + PT_REGISTRATION_TABLE + " (" + PT_COLUMN_USER + " text primary key, " + PT_COLUMN_PASSWORD
            + " text not null," + PT_COLUMN_NAME + " text ," + PT_COLUMN_GENDER + " text ,"
            + PT_ALLERGY + " text ," + PT_HISTORY + " text, " + PT_COLUMN_EMAIL + " text ," + PT_mob + " text, " + PT_SECQ + " text, " + PT_SECA + " text, "
            + PT_COLUMN_ADD + " text ," + PT_DOB + " text ," + PT_AADHAR + " text)";

    public static final String REGISTER_TABLE = "Insert into " + PT_REGISTRATION_TABLE + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement REGISTER_TABLE_PREP;

    public static final String LOGIN_USER = "select " + PT_COLUMN_USER + "," + PT_COLUMN_PASSWORD + " from " + PT_REGISTRATION_TABLE + " where " + PT_COLUMN_USER + "=?";
    PreparedStatement LOGIN_USER_PREP;

    public static final String create_registration_table = "create table if not exists " + doc_registration_table + " (" + doc_user + " text primary key, " +
            doc_name + " text, " + doc_mob + " text, " + doc_hospital + " text, " + doc_datejoin + " text , " + doc_gender + " text, " + doc_spec + " text, " + doc_email + " text, " +
            doc_password + " text not null, " + doc_id + " text, " + doc_security + " text, " + doc_seqans + " text, " + doc_approved + " text)";

    public static final String registration_table = "Insert into " + doc_registration_table + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement registration_table_prep;

    public static final String login_doc = "select " + doc_user + "," + doc_approved + "," + doc_password + " from " + doc_registration_table + " where " + doc_user + "=?";
    PreparedStatement login_doc_prep;

    public static final String update_approved = "update " + doc_registration_table + " set " + doc_approved + " =\"true\" where " + doc_user + "=?";
    PreparedStatement update_approved_prep;

    public static String check_username = "select " + doc_user + " from " + doc_registration_table + " where " + doc_user + "=?";
    PreparedStatement check_username_prep;

    public static final String forgotpass_patient = "select " + PT_COLUMN_EMAIL + "," + PT_SECQ + "," + PT_SECA + "," + PT_COLUMN_PASSWORD + " from " + PT_REGISTRATION_TABLE + " where " + PT_COLUMN_EMAIL + "=? and " +
            PT_SECQ + "=? and " + PT_SECA + "=?";
    PreparedStatement forgotpass_patient_prep;

    public static final String forgotpass_doc = "select " + doc_email + "," + doc_security + "," + doc_seqans + "," + doc_approved + "," + doc_password + " from " + doc_registration_table + " where " +
            doc_email + "=? and " + doc_security + "=? and " + doc_seqans + "=?";
    PreparedStatement forgotpass_doc_prep;

    public static final String create_doc_dashboard = "create table if not exists " + dashboard_table + " (" + doc_id + " text primary key, " + doc_name + " text, " + doc_prescription + " text, " + doc_advise + " text, " + doc_user + " text)";

    public static final String registration_doc = "Insert into " + dashboard_table + " values(?,?,?,?,?)";
    PreparedStatement registration_doc_prep;

    public static final String create_patient_dashboard = "create table if not exists " + dashboard_patient + " (" + PT_ID + " text primary key, " + PT_COLUMN_NAME + " text, " + PT_COLUMN_USER + " text, " + PT_FIELD + " text, " + PT_MESSAGE + " text, " + PT_SYMPTOMS + " text, " +
            PT_RESOLVED + " text)";
    public static final String registration_patient = "Insert into " + dashboard_patient + " values(?,?,?,?,?,?,?)";
    PreparedStatement registration_patient_prep;

    public static final String update_resolve = "update " + dashboard_patient + " set " + PT_RESOLVED + " =\"true\" where " + PT_ID + "=?";
    PreparedStatement update_resolve_prep;

    public static final String check_patient_id = "select " + PT_ID + " from " + dashboard_patient + " where " + PT_ID + "=?";
    PreparedStatement check_patient_id_prep;

    public static final String count_patient = "select " + "count(*)" + " from " + PT_REGISTRATION_TABLE;
    PreparedStatement count_patient_prep;

    public static final String count_doc = "select " + "count(*)" + " from " + doc_registration_table + " where " + doc_approved + " =\"true\"";
    PreparedStatement count_doc_prep;

    public static final String print_info = "select " + PT_COLUMN_USER + "," + PT_COLUMN_NAME + "," + PT_COLUMN_EMAIL + "," + PT_DOB + "," + PT_mob + " from " + PT_REGISTRATION_TABLE + " where " + PT_COLUMN_USER + "=?";
    PreparedStatement print_info_prep;

    public static final String print_patient = "select * from " + dashboard_patient + " where " + PT_ID + "=?";
    PreparedStatement print_patient_prep;

    public static final String print_patient1 = "select * from " + dashboard_patient + " Where " + PT_COLUMN_USER + "=?";
    PreparedStatement print_patient1_prep;

    public static final String print_doc = "select * from " + dashboard_table + " where " + doc_id + "=?";
    PreparedStatement print_doc_prep;

    public static final String doc_search = "select * from " + dashboard_patient + " Where " + PT_FIELD + "=?";
    PreparedStatement doc_search_prep;

    public static final String table_doc = "select * from " + doc_registration_table + " where " + doc_approved + " =\"false\"";
    PreparedStatement table_doc_prep;

    public static final String table_doc1 = "select * from " + doc_registration_table;
    PreparedStatement table_doc1_prep;

    public static final String table_patient = "select * from " + PT_REGISTRATION_TABLE;
    PreparedStatement table_patient_prep;

    public static final String print_doc_table = "select * from " + doc_registration_table + " where " + doc_user + "=?";
    PreparedStatement print_doc_table_prep;


    public boolean open() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);


            return true;
        } catch (SQLException e) {
            System.out.println("Unable to open database : " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (connection != null)
                connection.close();
            if (REGISTER_TABLE_PREP != null)
                REGISTER_TABLE_PREP.close();
            if (LOGIN_USER_PREP != null)
                LOGIN_USER_PREP.close();
            if (registration_table_prep != null)
                registration_table_prep.close();
            if (login_doc_prep != null)
                login_doc_prep.close();

            if (check_username_prep != null)
                check_username_prep.close();
            if (update_approved_prep != null)
                update_approved_prep.close();
            if (forgotpass_doc_prep != null)
                forgotpass_doc_prep.close();
            if (forgotpass_patient_prep != null)
                forgotpass_patient_prep.close();
            if (registration_doc_prep != null)
                registration_doc_prep.close();
            if (registration_patient_prep != null)
                registration_patient_prep.close();
            if (update_resolve_prep != null)
                update_resolve_prep.close();
            if (check_patient_id_prep != null)
                check_patient_id_prep.close();
            if (count_patient_prep != null)
                count_patient_prep.close();
            if (count_doc_prep != null)
                count_doc_prep.close();
            if (print_info_prep != null)
                print_info_prep.close();
            if (print_patient_prep != null)
                print_patient_prep.close();
            if (print_patient1_prep != null)
                print_patient1_prep.close();
            if (print_doc_prep != null)
                print_doc_prep.close();
            if (doc_search_prep != null)
                doc_search_prep.close();
            if (table_doc_prep != null)
                table_doc_prep.close();
            if (table_doc1_prep != null)
                table_doc1_prep.close();
            if (table_patient_prep != null)
                table_patient_prep.close();
            if (print_doc_table_prep != null)
                print_doc_table_prep.close();


        } catch (SQLException e) {
            System.out.println("unable to close the database : " + e.getMessage());
        }
    }

    public boolean register_patient(String name, String gender, String password, String email, String username1, String allergy, String pre_med_history, String mob, String add1, String secq, String seca, String dob, String aadhar) {
        try {
            System.out.println(CREATE_REGISTRATION_TABLE);
            connection = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = connection.createStatement();
            statement.execute(CREATE_REGISTRATION_TABLE);
            REGISTER_TABLE_PREP = connection.prepareStatement(REGISTER_TABLE);
            REGISTER_TABLE_PREP.setString(1, username1);
            REGISTER_TABLE_PREP.setString(2, password);
            REGISTER_TABLE_PREP.setString(3, name);
            REGISTER_TABLE_PREP.setString(4, gender);
            REGISTER_TABLE_PREP.setString(5, allergy);
            REGISTER_TABLE_PREP.setString(6, pre_med_history);
            REGISTER_TABLE_PREP.setString(7, email);
            REGISTER_TABLE_PREP.setString(8, mob);
            REGISTER_TABLE_PREP.setString(9, secq);
            REGISTER_TABLE_PREP.setString(10, seca);
            REGISTER_TABLE_PREP.setString(11, add1);
            REGISTER_TABLE_PREP.setString(12, dob);
            REGISTER_TABLE_PREP.setString(13, aadhar);


            int result = REGISTER_TABLE_PREP.executeUpdate();

            if (result != 1)
                return false;
            else
                return true;

        } catch (SQLException e) {
            System.out.println("unable to register : " + e.getMessage());
            return false;
        }
    }

    public boolean pt_login(String password, String username1) {
        try {
            System.out.println(LOGIN_USER);

            Statement statement = connection.createStatement();
            LOGIN_USER_PREP = connection.prepareStatement(LOGIN_USER);
            LOGIN_USER_PREP.setString(1, username1);
            ResultSet result = LOGIN_USER_PREP.executeQuery();
            if (username1.equals(result.getString(1))) {
                if (password.equals(result.getString(2)))
                    return true;
                else
                    return false;
            } else
                return false;

        } catch (SQLException e) {
            System.out.println("Unable to login:" + e.getMessage());
            return false;
        }
    }

    public boolean register_doc(String doc_name, String doc_datejoin, String doc_email, String doc_gender, String doc_id,
                                String doc_hospital, String doc_spec, String doc_security, String doc_user, String doc_password,
                                String doc_mob, String doc_seqans) {
        try {
            System.out.println(create_registration_table);
            connection = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = connection.createStatement();
            statement.execute(create_registration_table);

            registration_table_prep = connection.prepareStatement(registration_table);

            registration_table_prep.setString(1, doc_user);
            registration_table_prep.setString(2, doc_name);
            registration_table_prep.setString(3, doc_mob);
            registration_table_prep.setString(4, doc_hospital);
            registration_table_prep.setString(5, doc_datejoin);
            registration_table_prep.setString(6, doc_gender);
            registration_table_prep.setString(7, doc_spec);
            registration_table_prep.setString(8, doc_email);
            registration_table_prep.setString(9, doc_password);
            registration_table_prep.setString(10, doc_id);
            registration_table_prep.setString(11, doc_security);
            registration_table_prep.setString(12, doc_seqans);
            registration_table_prep.setString(13, "false");


            int result = registration_table_prep.executeUpdate();
            if (result != 1)
                return false;
            else

                return true;


        } catch (SQLException e) {
            System.out.println("doc unable to login : " + e.getMessage());
            return false;


        }


    }

    public boolean doc_login(String password, String username) {
        try {
            String approved = "true";
            System.out.println(login_doc);

            Statement statement = connection.createStatement();
            login_doc_prep = connection.prepareStatement(login_doc);
            login_doc_prep.setString(1, username);

            ResultSet result = login_doc_prep.executeQuery();
            if (username.equals(result.getString(1))) {
                if (password.equals(result.getString(3)) && approved.equals(result.getString(2)))
                    return true;
                else
                    return false;
            } else
                return false;
        } catch (SQLException e) {
            System.out.println("doc unable to login : " + e.getMessage());
            return false;
        }
    }

    public boolean admin(String username) {
        try {
            check_username_prep = connection.prepareStatement(check_username);
            update_approved_prep = connection.prepareStatement(update_approved);
            check_username_prep.setString(1, username);
            ResultSet result = check_username_prep.executeQuery();
            if (result.next()) {
                update_approved_prep.setString(1, username);
                int aff = update_approved_prep.executeUpdate();
                if (aff == 1)
                    return true;
                else
                    return false;
            } else
                return false;


        } catch (SQLException e) {
            System.out.println(e.getMessage());

            return false;
        }
    }

    public String forgot_pass(String email, String secuq, String secua, String type) {
        try {
            String approved = "true";
            if (type == "Doctor") {
                System.out.println(forgotpass_doc);
                forgotpass_doc_prep = connection.prepareStatement(forgotpass_doc);

                forgotpass_doc_prep.setString(1, email);

                forgotpass_doc_prep.setString(2, secuq);

                forgotpass_doc_prep.setString(3, secua);

                ResultSet results = forgotpass_doc_prep.executeQuery();

                if (email.equals(results.getString(1)) && secuq.equals(results.getString(2)) && secua.equals(results.getString(3)) ) {
                    return results.getString(5);
                } else
                    return "null";

            } else
                System.out.println(forgotpass_patient);

            forgotpass_patient_prep = connection.prepareStatement(forgotpass_patient);

            forgotpass_patient_prep.setString(1, email);
            forgotpass_patient_prep.setString(2, secuq);
            forgotpass_patient_prep.setString(3, secua);
            ResultSet result = forgotpass_patient_prep.executeQuery();
            if (email.equals(result.getString(1)) && secuq.equals(result.getString(2)) && secua.equals(result.getString(3))) {
                return result.getString(4);
            } else
                return "null";


        } catch (SQLException e) {
            return ("enter proper data " + e.getMessage());


        }
    }

    public boolean register_doc_dashboard(String doc_id, String doc_name, String doc_prescription, String doc_advise, String doc_user) {
        try {

            Statement statement = connection.createStatement();
            statement.execute(create_doc_dashboard);
            registration_doc_prep = connection.prepareStatement(registration_doc);

            registration_doc_prep.setString(1, doc_id);
            registration_doc_prep.setString(2, doc_name);
            registration_doc_prep.setString(3, doc_prescription);
            registration_doc_prep.setString(4, doc_advise);
            registration_doc_prep.setString(5, doc_user);

            int result = registration_doc_prep.executeUpdate();
            if (result == 1)
                return true;
            else
                return false;
        } catch (SQLException e) {
            System.out.println("unable to register: " + e.getMessage());
            return false;
        }
    }

    public boolean registration_patient_dashboard(String patient_id, String patient_name, String patient_user, String patient_field, String patient_message, String patient_symptoms) {
        try {

            Statement statement = connection.createStatement();

            statement.execute(create_patient_dashboard);

            registration_patient_prep = connection.prepareStatement(registration_patient);

            registration_patient_prep.setString(1, patient_id);
            registration_patient_prep.setString(2, patient_name);
            registration_patient_prep.setString(3, patient_user);
            registration_patient_prep.setString(4, patient_field);
            registration_patient_prep.setString(5, patient_message);
            registration_patient_prep.setString(6, patient_symptoms);
            registration_patient_prep.setString(7, "false");
            int result = registration_patient_prep.executeUpdate();
            if (result == 1)
                return true;
            else
                return false;
        } catch (SQLException e) {
            System.out.println("unable to register : " + e.getMessage());
            return false;
        }
    }

    public boolean resolve(String PT_ID) {
        try {
            check_patient_id_prep = connection.prepareStatement(check_patient_id);
            update_resolve_prep = connection.prepareStatement(update_resolve);
            check_patient_id_prep.setString(1, PT_ID);
            ResultSet result = check_patient_id_prep.executeQuery();
            if (result.next()) {
                update_resolve_prep.setString(1, PT_ID);
                int aff = update_resolve_prep.executeUpdate();
                if (aff == 1)
                    return true;
                else
                    return false;
            } else
                return false;


        } catch (SQLException e) {
            System.out.println("no doc found");

            return false;
        }


    }

    public int count_patient() {
        try {
            count_patient_prep = connection.prepareStatement(count_patient);
            ResultSet result = count_patient_prep.executeQuery();
            int count = result.getInt(1);
            return count;

        } catch (SQLException e) {

            return -1;
        }
    }

    public int count_doc() {
        try {
            System.out.println(count_doc);
            count_doc_prep = connection.prepareStatement(count_doc);
            ResultSet result = count_doc_prep.executeQuery();
            int count1 = result.getInt(1);
            return count1;
        } catch (SQLException e) {
            return -1;
        }


    }


    public ArrayList<patient> patientuserinfo(String username) {
        try {

            print_info_prep = connection.prepareStatement(print_info);
            print_info_prep.setString(1, username);
            ResultSet result = print_info_prep.executeQuery();
            ArrayList<patient> users = new ArrayList<>();
            while (result.next()) {
                patient user = new patient();
                user.setName(result.getString(2));
                user.setEmail(result.getString(3));
                user.setDob(result.getString(4));
                user.setMob(result.getString(5));
                users.add(user);
            }

            return users;


        } catch (SQLException e) {
            System.out.println("Unable to retrive data : " + e.getMessage());
            return null;

        }
    }

    public ArrayList<patient> patient_view(String id) {
        try {
            print_patient_prep = connection.prepareStatement(print_patient);
            print_patient_prep.setString(1, id);
            ResultSet result = print_patient_prep.executeQuery();
            ArrayList<patient> Users = new ArrayList<>();
            while (result.next()) {
                patient user = new patient();
                user.setId(result.getString(1));
                user.setName(result.getString(2));
                user.setUsername(result.getString(3));
                user.setField(result.getString(4));
                user.setMessage(result.getString(5));
                user.setSymptoms(result.getString(6));
                user.setResolved(result.getString(7));
                Users.add(user);
            }
            return Users;
        } catch (SQLException e) {
            System.out.println("Unable to retrive data : " + e.getMessage());
            return null;

        }
    }

    public ArrayList<patient> patient_username(String username) {
        try {
            print_patient1_prep = connection.prepareStatement(print_patient1);
            print_patient1_prep.setString(1, username);
            ResultSet result = print_patient1_prep.executeQuery();
            ArrayList<patient> Users = new ArrayList<>();
            while (result.next()) {
                patient user = new patient();
                user.setId(result.getString(1));
                user.setName(result.getString(2));
                user.setUsername(result.getString(3));
                user.setField(result.getString(4));
                user.setMessage(result.getString(5));
                user.setSymptoms(result.getString(6));
                user.setResolved(result.getString(7));
                Users.add(user);

            }
            return Users;
        } catch (SQLException e) {
            System.out.println("Unable to retrive data : " + e.getMessage());
            return null;
        }
    }

    public ArrayList<doctor> print_doctor(String id) {
        try {
            print_doc_prep = connection.prepareStatement(print_doc);
            print_doc_prep.setString(1, id);
            ResultSet result = print_doc_prep.executeQuery();
            ArrayList<doctor> docs = new ArrayList<>();

            while (result.next()) {
                doctor doc = new doctor();
                doc.setId(result.getString(1));
                doc.setName(result.getString(2));
                doc.setPrescription(result.getString(3));
                doc.setAdvise(result.getString(4));
                doc.setUsername(result.getString(5));
                docs.add(doc);
            }
            return docs;

        } catch (SQLException e) {
            System.out.println("Unable to retrive data : " + e.getMessage());
            return null;
        }


    }

    public ArrayList<patient> search_patient(String field) {
        try {

            doc_search_prep = connection.prepareStatement(doc_search);
            doc_search_prep.setString(1, field);
            ResultSet result = doc_search_prep.executeQuery();

            ArrayList<patient> search = new ArrayList<>();

            while (result.next()) {
                patient pt = new patient();
                pt.setId(result.getString(1));
                pt.setName(result.getString(2));
                pt.setUsername(result.getString(3));
                pt.setField(result.getString(4));
                pt.setMessage(result.getString(5));
                pt.setSymptoms(result.getString(6));
                pt.setResolved(result.getString(7));
                search.add(pt);

            }
            return search;

        } catch (SQLException e) {
            System.out.println("Unable to retrive data : " + e.getMessage());
            return null;
        }


    }

    public ArrayList<doctor> print_table() {
        try {
            table_doc_prep = connection.prepareStatement(table_doc);
            ResultSet result = table_doc_prep.executeQuery();

            ArrayList<doctor> docs = new ArrayList<>();

            while (result.next()) {
                doctor doc = new doctor();

                doc.setUsername(result.getString(1));
                doc.setName(result.getString(2));
                doc.setMob(result.getString(3));
                doc.setHospital(result.getString(4));
                doc.setDate_join(result.getString(5));
                doc.setGender(result.getString(6));
                doc.setSpecialization(result.getString(7));
                doc.setEmail(result.getString(8));
                doc.setPassword(result.getString(9));
                doc.setId(result.getString(10));
                doc.setSecurity_que(result.getString(11));
                doc.setSecurity_ans(result.getString(12));
                doc.setApproved(result.getString(13));
                docs.add(doc);

            }
            return docs;
        } catch (SQLException e) {
            System.out.println(" Unable to retrive data : " + e.getMessage());
            return null;
        }

    }

    public ArrayList<doctor> print_doc_table() {
        try {
            table_doc1_prep = connection.prepareStatement(table_doc1);
            ResultSet result = table_doc1_prep.executeQuery();

            ArrayList<doctor> docs = new ArrayList<>();
            while (result.next()) {
                doctor doc = new doctor();

                doc.setUsername(result.getString(1));
                doc.setName(result.getString(2));
                doc.setMob(result.getString(3));
                doc.setHospital(result.getString(4));
                doc.setDate_join(result.getString(5));
                doc.setGender(result.getString(6));
                doc.setSpecialization(result.getString(7));
                doc.setEmail(result.getString(8));
                doc.setPassword(result.getString(9));
                doc.setId(result.getString(10));
                doc.setSecurity_que(result.getString(11));
                doc.setSecurity_ans(result.getString(12));
                doc.setApproved(result.getString(13));
                docs.add(doc);
            }
            return docs;

        } catch (SQLException e) {
            System.out.println(" Unable to retrive data : " + e.getMessage());
            return null;
        }

    }

    public ArrayList<patient> print_patient() {
        try {
            table_patient_prep = connection.prepareStatement(table_patient);
            ResultSet result = table_patient_prep.executeQuery();

            ArrayList<patient> pts = new ArrayList<>();

            while (result.next()) {
                patient pt = new patient();

                pt.setUsername(result.getString(1));
                pt.setPassword(result.getString(2));
                pt.setName(result.getString(3));
                pt.setGender(result.getString(4));
                pt.setAllergy(result.getString(5));
                pt.setPre_med_history(result.getString(6));
                pt.setEmail(result.getString(7));
                pt.setMob(result.getString(8));
                pt.setSecurity_que(result.getString(9));
                pt.setSecurity_ans(result.getString(10));
                pt.setAdd(result.getString(11));
                pt.setDob(result.getString(12));
                pt.setAdhar(result.getString(13));
                pts.add(pt);


            }
            return pts;

        } catch (SQLException e) {
            System.out.println(" Unable to retrive data : " + e.getMessage());
            return null;
        }

    }

    public ArrayList<doctor> doc_print(String username) {
        try {
            print_doc_table_prep = connection.prepareStatement(print_doc_table);
            print_doc_table_prep.setString(1,username);

            ResultSet result = print_doc_table_prep.executeQuery();

            ArrayList<doctor> docs = new ArrayList<>();
            while (result.next()) {
                doctor doc = new doctor();

                doc.setUsername(result.getString(1));
                doc.setName(result.getString(2));
                doc.setMob(result.getString(3));
                doc.setHospital(result.getString(4));
                doc.setDate_join(result.getString(5));
                doc.setGender(result.getString(6));
                doc.setSpecialization(result.getString(7));
                doc.setEmail(result.getString(8));
                doc.setPassword(result.getString(9));
                doc.setId(result.getString(10));
                doc.setSecurity_que(result.getString(11));
                doc.setSecurity_ans(result.getString(12));
                doc.setApproved(result.getString(13));
                docs.add(doc);
            }
            return docs;
        } catch (SQLException e) {
            System.out.println(" Unable to retrive data : " + e.getMessage());
            return null;
        }


    }
}

