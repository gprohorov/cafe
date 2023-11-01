import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

/*
  @author   george
  @project   cafe
  @class  MainTest
  @version  1.0.0 
  @since 01.11.23 - 19.36
*/

class MainTest {
    private Connection connection;

    @Test
    void testConnection() throws SQLException, ClassNotFoundException {
        connection = Main.setConnection(Main.url, Main.login, Main.pass);
        assertNotNull(connection);
        assertTrue(connection.isValid(2));
        connection.close();
    }

    @Test
    void testQuery() throws SQLException, ClassNotFoundException {
        connection = Main.setConnection(Main.url, Main.login, Main.pass);
        String query = "SELECT * FROM client";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        assertNotNull(statement);
        assertNotNull(resultSet);

        assertEquals(1, resultSet.findColumn("id") );
        assertEquals(2, resultSet.findColumn("pib") );
        resultSet.next();
        assertEquals("john lennon", resultSet.getString("pib"));
        assertEquals("123", resultSet.getString(3));


    }
}
