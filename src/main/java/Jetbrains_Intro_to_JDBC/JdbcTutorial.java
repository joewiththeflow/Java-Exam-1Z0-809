package Jetbrains_Intro_to_JDBC;

// Following along with jdbc h2 tutorial https://www.jetbrains.com/guide/java/tutorials/marco-codes-jdbc/introduction/
// This should help to be able to run code examples for the exam Chapter 2 JDBC

import org.h2.command.Prepared;

import java.sql.*;

public class JdbcTutorial {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'classpath:users.sql';")) {
            System.out.println("connection.isValid(0) = " + connection.isValid(0));

            // CRUD

            // select
            PreparedStatement ps = connection.prepareStatement("select * from USERS where name = ?");
            ps.setString(1, "Marco");

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " - " + resultSet.getString("name"));
            }
            // inserts

            PreparedStatement insertPs = connection.prepareStatement("insert into USERS (name) values (?)");
            insertPs.setString(1, "John");
            int insertCount = insertPs.executeUpdate();
            System.out.println("insertCount = " + insertCount);

            // updates

            PreparedStatement updatePs = connection.prepareStatement("update USERS set name = ? where name = ?");
            updatePs.setString(1, "Johnny");
            updatePs.setString(2, "John");
            int updateCount = updatePs.executeUpdate();
            System.out.println("updateCount = " + updateCount);

            // deletes

            PreparedStatement deletePs = connection.prepareStatement("delete from USERS where name = ?");
            deletePs.setString(1, "Johnny");
            int deleteCount = deletePs.executeUpdate();
            System.out.println("deleteCount = " + deleteCount);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
