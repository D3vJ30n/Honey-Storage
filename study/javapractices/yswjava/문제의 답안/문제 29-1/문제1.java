package study.javapractices.yswjava.문제의

import java.util.List;
import java.util.Arrays;

class Box<T> {
    private T ob;
    public Box(T o) { ob = o; }
    public T get() { return ob; }
}

class BoxToString {
    public static void main(String[] args) {
        List<Box<String>> ls = 
             Arrays.asList(new Box<>("Robot"), new Box<>("Simple"));
        
        ls.stream()
          .map(s -> s.get())
          .forEach(n -> System.out.println(n));
    }
}