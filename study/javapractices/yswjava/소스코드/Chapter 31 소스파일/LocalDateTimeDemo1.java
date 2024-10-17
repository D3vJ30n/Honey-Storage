package study.javapractices.yswjava.소스코드.Chapter

import java.time.LocalDateTime;

class LocalDateTimeDemo1 {
    public static void main(String[] args) {
        // ���� ��¥�� �ð�
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);

        // ���� ���̾�� 22�ð� 35�� �� ȭ�� ���� ����
        LocalDateTime mt = dt.plusHours(22);
        mt = mt.plusMinutes(35);

        // ���� ���̾�� ȭ�� ���� ��¥�� �ð�
        System.out.println(mt);
    }
}
