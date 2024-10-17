package study.javapractices.yswjava.소스코드.Chapter

import java.util.function.Consumer;

class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> c = s -> System.out.println(s);
        
        c.accept("Pineapple");    // ����̶�� ����� ����
        c.accept("Strawberry");
    }
}