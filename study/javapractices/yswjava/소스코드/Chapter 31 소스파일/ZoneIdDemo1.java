package study.javapractices.yswjava.소스코드.Chapter

import java.time.ZoneId;

class ZoneIdDemo1 {
    public static void main(String[] args) {
        ZoneId paris = ZoneId.of("Europe/Paris");
        System.out.println(paris);
    }
}