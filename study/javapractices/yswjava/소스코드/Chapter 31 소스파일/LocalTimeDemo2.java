package study.javapractices.yswjava.소스코드.Chapter

import java.time.LocalTime;
import java.time.Duration;

class LocalTimeDemo2 {
    public static void main(String[] args) {
        // PC���� PC �̿� ���� �ð�
        LocalTime start = LocalTime.of(14, 24, 35);
        System.out.println("PC �̿� ���� �ð�: " + start);

        // PC���� PC �̿� ���� �ð�
        LocalTime end = LocalTime.of(17, 31, 19);
        System.out.println("PC �̿� ���� �ð�: " + end);

        // PC �̿� �ð� ���
        Duration between = Duration.between(start, end);
        System.out.println("�� PC �̿� �ð�: " + between);        
    }
}
