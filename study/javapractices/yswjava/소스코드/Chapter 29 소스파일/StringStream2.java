package study.javapractices.yswjava.소스코드.Chapter

import java.util.Arrays;

class StringStream2 {
    public static void main(String[] args) {
        String[] names = {"YOON", "LEE", "PARK"};
        
        Arrays.stream(names)
            .forEach(s -> System.out.println(s));
    }
}