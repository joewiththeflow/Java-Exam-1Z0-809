package Chapter3_Assertions_and_Exceptions.Questions;

public class Question5 {
    class RanOutOfTrack extends Exception {}
    class AnotherTrainComing extends Exception {}

    public static void main(String[] args) throws RanOutOfTrack, AnotherTrainComing {
        Question5 a = new Question5();
        try {
            a.drive();
            System.out.println("toot! toot!");
        } // INSERT CODE HERE
        catch (RanOutOfTrack e) {   // put in so that code compiles
            System.out.println("error locomoting");
            throw e;
        }
    }
    void drive() throws RanOutOfTrack, AnotherTrainComing {
        throw new RanOutOfTrack();
    }
}

//Which inserted independently at // INSERT CODE HERE will compile and produce the output error locomoting before throwing
//an exception? (Choose all that apply)

// A. catch(AnotherTrainComing e) {
// B. catch(AnotherTrainComing | RanOutOfTrack e) {     --> CORRECT
// C. catch(AnotherTrainComing e | RanOutOfTrack e) {
// D. catch(Exception e) {                              --> CORRECT
// E. catch(IllegalArgumentException e) {
// F. catch(RanOutOfTrack e) {                  --> CORRECT
// G. None of the above - code fails to compile