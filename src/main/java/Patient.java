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

}
