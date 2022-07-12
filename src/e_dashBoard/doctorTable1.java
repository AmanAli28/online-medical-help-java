
package e_dashBoard;

public class doctorTable1 {
    String mprobid, mname, mtype, mmessage, msymptoms;

    public doctorTable1(String mprobid, String mname, String mtype, String mmessage, String msymptoms) {
        this.mprobid = mprobid;
        this.mname = mname;
        this.mtype = mtype;
        this.mmessage = mmessage;
        this.msymptoms = msymptoms;
    }

    public String getMprobid() {
        return mprobid;
    }

    public void setMprobid(String mprobid) {
        this.mprobid = mprobid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getMmessage() {
        return mmessage;
    }

    public void setMmessage(String mmessage) {
        this.mmessage = mmessage;
    }

    public String getMsymptoms() {
        return msymptoms;
    }

    public void setMsymptoms(String msymptoms) {
        this.msymptoms = msymptoms;
    }
    
    
}
