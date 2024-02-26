package Chapter8_Lambda_Expressions.Questions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Question13 {
    public static void main(String[] args) {

        Map<String, String> todos = new HashMap<>();
        todos.put("monday", "wash dog");
        todos.put("tuesday", "weed yard");
        TodoList todoList = new TodoList();
        // L1


//        Which fragments inserted independently at // L1 display output consisting of the to-do item for Tuesday?

//        A. todoList.checkTodoDay(todos, (k) -> if (k.equals("tuesday") return true; else return false; ));
//        B. todoList.checkTodoDay(todos, (k,v) -> if (k.equals("tuesday")) System.out.println("You should really do this today! " + v); ));
//        C. todoList.checkTodoDay(todos, (k) -> k.equals("tuesday"));      --> CORRECT
//        D.  todoList.checkTodoDay(todos, (k) -> k.test("tuesday"));
    }
}

class TodoList {
    public void checkTodoDay(Map<String, String> todos, Predicate<String> isDay) {
        todos.forEach((d, t) -> {
            if (isDay.test(d)) {
                System.out.println("You really should do this today! " + t);
            }
        });
    }
}
