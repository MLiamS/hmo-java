import org.sql2o.*;

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

  public String getName() {
    return this.name;
  }

  public String getBirthday() {
    return this.birthday;
  }

  public int getDoctorId() {
    return doctorId;
  }
}
