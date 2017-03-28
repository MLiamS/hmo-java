import org.sql2o.*;
import java.util.List;

public class Patient {
  private String name;
  private String birthday;
  private int doctorId;
  private int id;

  public Patient(String name, String birthday, int doctorId ) {
    this.name = name;
    this.birthday = birthday;
    this.doctorId = doctorId;
  }

  @Override
  public boolean equals(Object otherPatient) {
    if (!(otherPatient instanceof Patient)) {
      return false;
    } else {
      Patient newPatient = (Patient) otherPatient;
      return this.getName().equals(newPatient.getName()) && this.getId() == newPatient.getId();
    }
  }

  public String getName() {
    return this.name;
  }

  public String getBirthday() {
    return this.birthday;
  }

  public int getDoctorId() {
    return this.doctorId;
  }

  public int getId() {
    return this.id;
  }

  public void save()  {
    try(Connection con =  DB.sql2o.open()) {
      String sql = "INSERT INTO patients (name, birthday, doctor_id) VALUES (:name, :birthday, :doctor_id)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("birthday", this.birthday)
        .addParameter("doctor_id", this.doctorId)
        .executeUpdate().getKey();
    }
  }

  public static List<Patient> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM patients";
      return con.createQuery(sql)
      .addColumnMapping("doctor_id", "doctorId")
      .executeAndFetch(Patient.class);
    }
  }

  public static Patient find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM patients WHERE id = :id";
      Patient patient = con.createQuery(sql)
        .addParameter("id", id)
        .addColumnMapping("doctor_id", "doctorId")
        .executeAndFetchFirst(Patient.class);
      return patient;
    }
  }
}
