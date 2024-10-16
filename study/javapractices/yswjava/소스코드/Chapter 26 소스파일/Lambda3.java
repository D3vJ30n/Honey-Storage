package study.javapractices.yswjava.소스코드.Chapter

interface Printable {
    void print(String s);
}

class Lambda3 {
    public static void main(String[] args) {
        Printable prn = (s) -> { System.out.println(s); };
        prn.print("What is Lambda?");
    }
}