package Chapter11_Concurrency.Questions;

public class Question12 {

//    Given

//    private Integer executeTask(ExecutorService service, Callable<Integer> task) {
    // insert here
//    }

//    Which set(s) of lines, when inserted, would correctly use the ExecutorService argument to execute the Callable
//    and return the Callable's result? (Choose all that apply)

//    A. try {
//          return service.submit(task);
//       } catch (Exception e) {
//          return null;
//       }
//    B. try {
//          return service.execute(task);
//       } catch (Exception e) {
//          return null;
//       }
//    C. try {
//          return Future<Integer> future = service.submit(task);   --> CORRECT
//          return future.get();
//       } catch (Exception e) {
//          return null;
//       }
//    D. try {
//          Result<Integer> result = return service.submit(task);
//          return result.get();
//       } catch (Exception e) {
//          return null;
//       }
}


// C is correct. When you submit a Callable to an ExecutorService for execution, you will receive a Future as the result.
// You can use the Future to check on the status of the Callable’s execution, or just use the get() method to block until
// the result is available.