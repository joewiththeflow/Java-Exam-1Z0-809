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
