import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DoctorTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hmo_test", null, null);
  }

  @After
  public void tearDown() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM doctors *;";
      con.createQuery(sql).executeUpdate();
    }
  }

  @Test
  public void doctor_instantiates_true() {
    Doctor doctor = new Doctor("Doc", 1);
    assertEquals(true, doctor instanceof Doctor);
  }

  @Test
  public void equals_returnsTrueIfNamesAreSame() {
    Doctor doctor = new Doctor("Doc", 1);
    Doctor doctor2 = new Doctor("Doc", 1);
    assertTrue(doctor.equals(doctor2));
  }
}
