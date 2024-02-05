package Chapter12_JDBC;

import javax.xml.transform.Result;
import java.sql.*;

public class DBExample {

    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'classpath:books.sql';")) {
            System.out.println("connection.isValid(0) = " + connection.isValid(0));

            // Select
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM Book";
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("ISBN") +
                        " - " + resultSet.getString("Title") +
                        " - " + resultSet.getDate("PubDate") +
                        " - " + resultSet.getString("Format") +
                        " - " + resultSet.getDouble("Price"));
            }

            Statement stmt2 = connection.createStatement();
            query = "SELECT * FROM Customer";
            ResultSet resultSet2 = stmt2.executeQuery(query);
            while (resultSet2.next()) {
                System.out.println(resultSet2.getInt("CustomerID") +
                        " - " + resultSet2.getString("FirstName") +
                        " - " + resultSet2.getString("LastName") +
                        " - " + resultSet2.getString("Email") +
                        " - " + resultSet2.getString("Phone"));
            }

            // Update
            Statement stmt3 = connection.createStatement();
            query = "UPDATE Book SET Price=8.95 WHERE Price > 8.95 AND Format='Hardcover'";
            int numRows = stmt.executeUpdate(query);
            System.out.println("Number of rows updated: " + numRows);

            // execute
            ResultSet resultSet3;
            int numRows2;
            query = "Select * from Books_by_Author";      // gives a result set
//            query = "UPDATE Book SET Price=8.95 where Title='How to Train Your Dragon'";    // affects 1 row
            // Not quite sure how to get no results i.e. -1.
            // Select with no hits still reurns a resultSet which just happens to be empty
            // An Update which has no hits gives an updateCount of 0
            boolean status = stmt.execute(query);
            if (status) {
                resultSet3 = stmt.getResultSet();
                // Process the result set...
                while(resultSet3.next()) {
                    System.out.println(resultSet3.getInt("AuthorID") +
                            " - " + resultSet3.getString("ISBN"));
                }
            } else {
                numRows2 = stmt.getUpdateCount();
                if (numRows2 == -1) {
                    System.out.println("No Results");
                } else {
                    System.out.println(numRows2 + " rows affected.");
                }
            }


            query = "SELECT FirstName, LastName, Email FROM Customer WHERE LastName LIKE 'C%'";
            ResultSet resultSet4 = stmt.executeQuery(query);
            while(resultSet4.next()) {
                System.out.println(resultSet4.getString("FirstName") +
                        " - " + resultSet4.getString("LastName") +
                        " - " + resultSet4.getString("Email"));
            }


            query = "SELECT Title, PubDate, Price FROM Book";
            ResultSet resultSet5 = stmt.executeQuery(query);
            while (resultSet5.next()) {
                String title = resultSet5.getString(1);
                Date pubDate = resultSet5.getDate(2);
                float price = resultSet5.getFloat(3);
                System.out.println(title + " - " + pubDate + " - " + price);
            }


            query = "SELECT AuthorID FROM Author";
            ResultSet resultSet6 = stmt.executeQuery(query);
            ResultSetMetaData rsmd = resultSet6.getMetaData();
            resultSet6.next();
            int colCount = rsmd.getColumnCount();
            System.out.println("Column count: " + colCount);
            for (int i = 1; i <= colCount; i++) {
                System.out.println("Table Name: " + rsmd.getTableName(i));
                System.out.println("Column Name: " + rsmd.getColumnName(i));
                System.out.println("Column Size: " + rsmd.getColumnDisplaySize(i));
            }



            String colData;
            query = "SELECT * FROM Author";
            ResultSet resultSet7 = stmt.executeQuery(query);
            rsmd = resultSet7.getMetaData();
            int cols = rsmd.getColumnCount();
            for (int i = 1; i <= cols; i++) {
                System.out.print(rsmd.getColumnName(i) + " ");
            }
            System.out.println();
            while (resultSet7.next()) {
                for (int i = 1; i <= cols; i++) {
                    if (resultSet7.getObject(i) != null) {
                        colData = resultSet7.getObject(i).toString();
                    } else {
                        colData = "NULL";
                    }
                    System.out.print(colData);
                }
                System.out.println();
            }


            query = "SELECT Author.LastName, Book.Title FROM Author, Book, Books_by_Author" +
                    " WHERE Author.AuthorID = Books_by_Author.AuthorID AND Book.ISBN = Books_by_author.ISBN";
            ResultSet resultSet8 = stmt.executeQuery(query);
            rsmd = resultSet8.getMetaData();
            cols = rsmd.getColumnCount();
            for (int i = 1; i <= cols; i++) {
                System.out.print(rsmd.getTableName(i) + ":" + rsmd.getColumnName(i) + " ");
            }


            System.out.println("\nPRETTY PRINT\n");

            query = "SELECT * FROM Author";
            ResultSet resultSet9 = stmt.executeQuery(query);
            rsmd = resultSet9.getMetaData();
            cols = rsmd.getColumnCount();
            String col2, colData2;
            for (int i = 1; i <= cols; i++) {
                col2 = leftJustify(rsmd.getColumnName(i), rsmd.getColumnDisplaySize(i));
                System.out.print(col2);
            }
            System.out.println();
            while (resultSet9.next()) {
                for (int i = 1; i <= cols; i++) {
                    if (resultSet9.getObject(i) != null) {
                        colData2 = resultSet9.getObject(i).toString();
                    } else {
                        colData2 = "NULL";
                    }
                    col2 = leftJustify(colData2, rsmd.getColumnDisplaySize(i));
                    System.out.print(col2);
                }
                System.out.println();
            }


            // Moving around in result sets
            DatabaseMetaData dbmd = connection.getMetaData();
            if (dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                System.out.print("Supports TYPE_FORWARD_ONLY");
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" and supports CONCUR_UPDATABLE");
                }
            }

            if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                System.out.print("Supports TYPE_SCROLL_INSENSITIVE");
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" and supports CONCUR_UPDATABLE");
                }
            }

            if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                System.out.print("Supports TYPE_SCROLL_SENSITIVE");
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" and supports CONCUR_UPDATABLE");
                }
            }


            // Get number of rows
            Statement stmt4 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet resultSet10 = stmt4.executeQuery(query);
            if (resultSet10.last()) {                               // Move to the last row
                int rowCount = resultSet10.getRow();                // Get the row number i.e. the count
                System.out.println("Number of rows: " + rowCount);
                resultSet10.beforeFirst();                          // Move to before the first row
            }


            // Process every odd row
            ResultSet resultSet11 = stmt.executeQuery(query);
            for (int i = 1; ; i += 2) {
                if (resultSet11.absolute(i)) {
                    System.out.println(resultSet11.getInt(1) +
                            " - " + resultSet11.getString(2) +
                            " - " + resultSet11.getString(3));
                } else {
                    break;
                }
            }

            // Go backwards
            ResultSet resultSet12 = stmt4.executeQuery(query);
            resultSet12.afterLast();
            while(resultSet12.previous()) {
                System.out.println(resultSet12.getInt(1) +
                        " - " + resultSet12.getString(2) +
                        " - " + resultSet12.getString(3));
            }

            // Move to first row and print message if no rows
            if (!resultSet12.first()) {
                System.out.println("No rows in the result set");
            }

            // Move to last row and print message if no rows
            if (!resultSet12.last()) {
                System.out.println("No rows in the result set");
            }

            // Update
//            Statement stmt5 = connection.createStatement();
//            query = "UPDATE Book SET Price=11.95 WHERE Price=8.95 AND Format='Hardcover'";
//            int rowsUpdated = stmt5.executeUpdate(query);
//            System.out.println("Num rows updated: " + rowsUpdated);

            // Update using ResultSet
            Statement stmt6 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query2 = "SELECT * from Book " +
                    "WHERE Format='Hardcover'";
            ResultSet resultSet13 = stmt6.executeQuery(query2);
            while (resultSet13.next()) {
                if (resultSet13.getFloat("Price") == 8.95f) {
                    resultSet13.updateFloat("Price", 11.95f);
                    resultSet13.updateRow();
                }
            }

            // Update using Object  (each object type e.g. Integer, Float, etc. has a .valueOf method which can take a  String
            Statement stmt7 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query3 = "SELECT * FROM Book WHERE ISBN='142311339X'";
            ResultSet resultSet14 = stmt7.executeQuery(query3);
            resultSet14.next();
            System.out.println(resultSet14.getString(1) +
                    " - " + resultSet14.getString(2) +
                    " - " + resultSet14.getDate(3));
            resultSet14.updateObject("PubDate", "2005-04-23");
            System.out.println(resultSet14.getString(1) +
                    " - " + resultSet14.getString(2) +
                    " - " + resultSet14.getDate(3));
            resultSet14.updateRow();
            System.out.println(resultSet14.getString(1) +
                    " - " + resultSet14.getString(2) +
                    " - " + resultSet14.getDate(3));


            // Insert new author
            Statement stmt8 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet15 = stmt8.executeQuery("SELECT AuthorID, FirstName, LastName FROM Author");
            resultSet15.next();
            resultSet15.moveToInsertRow();                              // Move to special insert row
            resultSet15.updateInt("AuthorID", 1055);
            resultSet15.updateString("FirstName", "Tom");
            resultSet15.updateString("LastName", "McGinn");
            resultSet15.insertRow();
            resultSet15.moveToCurrentRow();                             // Move back to row you were on before insert

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }

    public static String leftJustify(String s, int n) {
        if (s.length() <= n) {      // Add an extra space if the length of String s is less than or equal to length of column n
            n++;
        }
        return String.format("%1$-" + n + "s", s);  // Pad to the right of the String by n spaces
    }

    public static int getRowCount(ResultSet rs) throws SQLException {
        int rowCount = -1;
        int currRow = 0;

        if (rs != null) {                       // mak sure the result set is not null
            currRow = rs.getRow();              // Save the current row position:
                                                    // zero indicates that there is no current row position
                                                    // could be beforeLast or afterLast
            if (rs.isAfterLast()) {             // afterLats, so set the currRow to -1
                currRow = -1;
            }
            if (rs.last()) {                    // move to the last row and get the position
                                                // if this method returns false, there are no results
                rowCount = rs.getRow();         // Get the row count

                if (currRow == -1) {                 // Return the cursor to the position it was in before the method was called
                    rs.afterLast();                 // If the currRow is negative, the cursor position was after the last row,
                                                    // so return the cursor to the last row
                } else if (currRow == 0) {      // if the currRow is 0, then move cursor to before first row
                    rs.beforeFirst();
                } else {
                    rs.absolute(currRow);    // else return the cursor to its last position
                }
            }
        }
        return rowCount;
    }

}
