package study.javapractices.yswjava.소스코드.Chapter

import java.time.ZoneId;

class ZoneIdDemo2 {
    public static void main(String[] args) {
        ZoneId.getAvailableZoneIds()
            .stream()
       //     .filter(s -> s.startsWith("Asia"))
            .sorted()
            .forEach(s -> System.out.println(s));
    }
}