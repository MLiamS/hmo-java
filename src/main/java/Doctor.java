import java.util.List;
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

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO doctors (name, speciality_id) VALUES (:name, :spec)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("spec", this.specialityId)
        .executeUpdate()
        .getKey();
    }
  }



  public static List<Doctor> all() {
    String sql = "SELECT * FROM doctors";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .addColumnMapping("speciality_id", "specialityId")
      .executeAndFetch(Doctor.class);
    }
  }
}
