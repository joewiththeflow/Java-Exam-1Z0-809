package Chapter5_IO_and_NIO.Qs;

public class Question12 {

//    Give a partial directory tree:

//    dir x - |
//    -----------| - dir y
//    -----------| - file a

//    In what order can the following methods be called if walking the directory tree from x? (Choose all that apply)

//    I. preVisitDirectory x
//    II. preVisitDirectory x/y
//    III. postVisitDirectory x/y
//    IV: postVisitDirectory x
//    V: visitFile x/a

//    A. I, II, II, IV, V
//    B. I, II, III, V, IV      --> CORRECT
//    C. I, V, II, III, IV      --> CORRECT
//    D. I, V, II, IV, III
//    E. V, I, II, III, IV
//    F. V, I, II, IV, III
}
