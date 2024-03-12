package Chapter10_Threads.Questions;

// This class is intended to allow users to write a series of messages so that each message is identified with a
// timestamp and the name of the thread that wrote the message:
public class Question8 {
    private StringBuilder contents = new StringBuilder();
    public void log(String message) {
        contents.append(System.currentTimeMillis());
        contents.append(": ");
        contents.append(Thread.currentThread().getName());
        contents.append(message);
        contents.append("\n");
    }
    public String getContents() { return contents.toString(); }
}

// How can we ensure that instances of this class can be safely used by multiple threads?

// A. This class is already thread safe
// B. Replacing StringBuilder with StringBuffer will make this class thread-safe    -- no, even though has synchronized methods
// C. Synchronize the log() method only
// D. Synchronize the getContents() method only
// E. Synchronize both log() and getContents()      --> CORRECT
// F. This class cannot be made thread-safe
