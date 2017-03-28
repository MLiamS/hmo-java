import org.sql2o.*;

public class Speciality {
  private String title;
  private int id;

  public Speciality(String title) {
    this.title = title;
  }

  public String getTitle() {
    return this.title;
  }

  public int getId() {
    return this.id;
  }

  @Override
  public boolean equals(Object otherSpeciality) {
    if (!(otherSpeciality instanceof Speciality)) {
      return false;
    } else {
      Speciality newSpeciality = (Speciality) otherSpeciality;
      return this.getName().equals(newSpeciality.getName()) && this.getId() == newSpeciality.getId();
    }
  }

  public void save()  {
    try(Connection con =  DB.sql2o.open()) {
      String sql = "INSERT INTO specialities (title) VALUES (:title)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("title", this.title)
        .executeUpdate().getKey();
    }
  }

  public static List<Speciality> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM specialities";
      return con.createQuery(sql)
      .executeAndFetch(Speciality.class);
    }
  }

  public static Speciality find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM specialities WHERE id = :id";
      Speciality speciality = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Speciality.class);
      return speciality;
    }
  }
}
