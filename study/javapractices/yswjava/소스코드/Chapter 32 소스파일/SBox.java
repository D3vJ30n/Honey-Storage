package study.javapractices.yswjava.소스코드.Chapter

public class SBox implements java.io.Serializable {
    String s;

    public SBox(String s) {
        this.s = s;
    }

    public String get() {
        return s;
    }
}