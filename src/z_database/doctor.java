package z_database;

public class doctor extends register{
  String approved;
  String prescription;
  String advise;
  String hospital;
  String date_join;
  String specialization;

    public String getApproved() {
        return approved;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getDate_join() {
        return date_join;
    }

    public void setDate_join(String date_join) {
        this.date_join = date_join;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getAdvise() {
        return advise;
    }

    public void setAdvise(String advise) {
        this.advise = advise;
    }
}
