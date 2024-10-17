package study.javapractices.yswjava.소스코드.Chapter

import java.util.List;
import java.util.Arrays;

class ListStream {
    public static void main(String[] args) {
        
        List<String> list = Arrays.asList("Toy", "Robot", "Box");
        
        list.stream()
          .forEach(s -> System.out.print(s + "\t"));

        System.out.println();
    }
}