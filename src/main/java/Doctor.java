import org.sql2o.*;

public class Doctor {
  private String name;
  private int specialityId;

  public Doctor(String name, int sId) {
    this.name = name;
    this.specialityId = sId;
  }
}
