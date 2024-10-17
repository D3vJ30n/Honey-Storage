package study.javapractices.yswjava.소스코드.Chapter

import java.util.List;
import java.util.Arrays;

class ForEachDemo {

    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Box", "Robot");
        
        // ���ٽ� ���
        ls.forEach(s -> System.out.println(s));

        // �޼ҵ� ���� ���
        ls.forEach(System.out::println);
    }
}