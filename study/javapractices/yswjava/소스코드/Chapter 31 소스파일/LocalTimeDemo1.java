package study.javapractices.yswjava.소스코드.Chapter

import java.time.LocalTime;

class LocalTimeDemo1 {
    public static void main(String[] args) {
        // ���� �ð�
        LocalTime now = LocalTime.now();
        System.out.println("���� �ð�: " + now);

        // 2�ð� 10�� �� ȭ�� ���� ����
        LocalTime mt = now.plusHours(2);
        mt = mt.plusMinutes(10);

        // ȭ�� ���� �ð�
        System.out.println("ȭ�� ���� �ð�: " + mt);
    }
}
