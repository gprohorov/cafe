
/*
  @author   george
  @project   Default (Template) Project
  @class  ${NAME}
  @version  1.0.0 
  @since 20.09.23 - 19.24
*/

import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection connection;
        String url = "jdbc:mysql://localhost:3306/cafe";
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url,"root", "root");
        System.out.println(connection.isValid(2));
        String query = "SELECT * FROM client";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println(resultSet.getMetaData().getColumnLabel(2));

        List<Client> clients = new ArrayList<>();
        while (resultSet.next()) {
            clients.add(new Client(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3)
                    )
            );
        }

        while (resultSet.next()) {

        }
        System.out.println(clients);

        connection.close();



    }


}
