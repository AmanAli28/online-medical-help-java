
package e_dashBoard;

public class patientTable1 {
    String mProbid, mName, mSpec, mSymp, mMessage;

    public patientTable1(String mProbid, String mName, String mSpec, String mSymp, String mMessage) {
        this.mProbid = mProbid;
        this.mName = mName;
        this.mSpec = mSpec;
        this.mSymp = mSymp;
        this.mMessage = mMessage;
    }

    public String getmProbid() {
        return mProbid;
    }

    public void setmProbid(String mProbid) {
        this.mProbid = mProbid;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSpec() {
        return mSpec;
    }

    public void setmSpec(String mSpec) {
        this.mSpec = mSpec;
    }

    public String getmSymp() {
        return mSymp;
    }

    public void setmSymp(String mSymp) {
        this.mSymp = mSymp;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }
    
}
