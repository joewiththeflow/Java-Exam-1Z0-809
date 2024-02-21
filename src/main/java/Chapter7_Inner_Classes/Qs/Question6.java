package Chapter7_Inner_Classes.Qs;

public abstract class Question6 {
    public int getNum() {
        return 45;
    }

    public abstract class Bar {
        public int getNum() {
            return 38;
        }
    }

    public static void main(String[] args) {
        Question6 t = new Question6() {
            @Override
            public int getNum() {
                return 22;
            }
        };
        Question6.Bar f = t.new Bar() {
            public int getNum() {
                return 57;
            }
        };
        System.out.println(f.getNum() + " " + t.getNum());
    }
}

// What is the result?

// A. 57 22                             --> CORRECT
// B. 45 38
// C. 45 57
// D. An exception occurs at runtime
// E. Compilation fails