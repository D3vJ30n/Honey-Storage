package study.javapractices.yswjava.소스코드.Chapter

import java.time.Instant;
import java.time.Duration;

class InstantDemo {
    public static void main(String[] args) {
        Instant start = Instant.now();
        System.out.println("����: " + start.getEpochSecond());
        
        System.out.println("Time flies like an arrow.");

        Instant end = Instant.now();        
        System.out.println("��: " + end.getEpochSecond());    

        Duration between = Duration.between(start, end);
        System.out.println("�и� �� ���� ��: " + between.toMillis());
     }
}