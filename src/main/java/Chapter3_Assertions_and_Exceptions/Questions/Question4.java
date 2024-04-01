package Chapter3_Assertions_and_Exceptions.Questions;

import java.io.IOException;
import java.sql.SQLException;

public class Question4 {
    public static void main(String[] args) {
        Question4 a = new Question4();
        try {
            a.fileBlowUp();
            a.databaseBlowUp();
            System.out.println("a");
        } // INSERT CODE HERE
        catch (IOException e) { // Inserted to make sure it compiles
            System.out.println("b");
        } catch (Exception e) {
            System.out.println("c");
        }
    }
    void databaseBlowUp() throws SQLException {
        throw new SQLException();
    }
    void fileBlowUp() throws IOException {
        throw new IOException();
    }
}

// Which inserted independently at // INSERT CODE HERE will compile and produce the output b? (Choose all that apply)

// A. catch(Exception e) {
// B. catch(FileNotFoundException e) {
// C. catch(IOException e) {                    --> CORRECT
// D. catch(IOException | SQLException e) {     --> CORRECT
// E. catch(IOException e | SQLException e) {
// F. catch(SQLException e) {
// G. catch(SQLException | IOException e) {     --> CORRECT
// H. catch(SQLException e | IOException e) {