package Chapter5_IO_and_NIO.Qs;

public class Question16 {
//    Given a partial directory tree:

//    dir x - |
//    --------| - dir y
//    --------| - file a

//    and given that a valid Path object, dir, points to x, and given this snippet:

//    WatchKey key = dir.register(watcher, ENTRY_CREATE);

//     If a WatchService is set using the given WatchKey, what would be the result if a file is added to dir y?

//    A. No notice is given                                     --> CORRECT
//    B. A notice related to dir x is issued
//    C. A notice related to dir y is issued
//    D. Notices for both dir x and dir y are give
//    E. An exception is thrown
//    F. The behaviour depends on the underlying operating system

}
