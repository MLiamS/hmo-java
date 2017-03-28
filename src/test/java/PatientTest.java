import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PatientTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hmo_test", null, null);
  }

  @After
  public void tearDown() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM patients *;";
      con.createQuery(sql).executeUpdate();
    }
  }

  @Test
  public void patient_instantiates_true() {
    Patient patient = new Patient("Bub", "1986-08-18", 1);
    assertEquals(true, patient instanceof Patient);
  }
}
