
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
    public static Connection connection;
    public static String url = "jdbc:mysql://localhost:3306/cafe";
    public static String login = "root";
    public static String pass = "root";

    public static Connection setConnection(String url, String login, String pass) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,login, pass);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        connection = setConnection(url, login, pass);
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







        System.out.println(clients);

        statement.close();
        resultSet.close();

        String query2 = "SELECT * FROM cafe.order WHERE id=1";
         statement = connection.createStatement();
         resultSet = statement.executeQuery(query2);
         Order order = new Order();
        while (resultSet.next()) {
            order.setId(resultSet.getInt(1));
            order.setName(resultSet.getString(2));
            order.setPrice(resultSet.getInt(3));
            int clientId = resultSet.getInt(4);
            Client client = clients.stream().filter(cl -> cl.getId() == clientId)
                    .findAny().get();
            order.setClient(client);
        }

        connection.close();


// POC   - proof of concept

    }


}
