package study.javapractices.yswjava.소스코드.Chapter

import java.util.function.Function;

class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Integer> f = s -> s.length();

        System.out.println(f.apply("Robot"));
        System.out.println(f.apply("System"));
    }
}