import org.sql2o.*;

public class Doctor {
  private String name;
  private int specialityId;
  private int id;

  public Doctor(String name, int sId) {
    this.name = name;
    this.specialityId = sId;
  }

  @Override
  public boolean equals(Object otherDoctor) {
    if (!(otherDoctor instanceof Doctor)) {
      return false;
    } else {
      Doctor newDoctor = (Doctor) otherDoctor;
      return this.getName().equals(newDoctor.getName()) && this.getId() == newDoctor.getId();
    }
  }

  public String getName() {
    return this.name;
  }

  public int getId() {
    return this.id;
  }
}
