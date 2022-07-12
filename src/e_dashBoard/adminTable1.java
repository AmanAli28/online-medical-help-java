/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e_dashBoard;

/**
 *
 * @author amana
 */
public class adminTable1 {
    String tdocid, tname, thospital, tdoj, tspec, tgender, tusername;

    public adminTable1(String tdocid, String tusername, String tname, String tspec, String thospital, String tdoj) {
        this.tdocid = tdocid;
        this.tname = tname;
        this.thospital = thospital;
        this.tdoj = tdoj;
        // this.tgender = tgender;
        this.tspec = tspec;
        this.tusername = tusername;
    }

    public void setTusername(String tusername) {
        this.tusername = tusername;
    }

    public String getTusername() {
        return tusername;
    }

    public String getTdocid() {
        return tdocid;
    }

    public String getTname() {
        return tname;
    }

    public String getThospital() {
        return thospital;
    }

    public String getTdoj() {
        return tdoj;
    }

    public String getTgender() {
        return tgender;
    }

    public String getTspec() {
        return tspec;
    }

    public void setTdocid(String tdocid) {
        this.tdocid = tdocid;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setThospital(String thospital) {
        this.thospital = thospital;
    }

    public void setTdoj(String tdoj) {
        this.tdoj = tdoj;
    }

    public void setTgender(String tgender) {
        this.tgender = tgender;
    }

    public void setTspec(String tspec) {
        this.tspec = tspec;
    }
    
    
    
}
