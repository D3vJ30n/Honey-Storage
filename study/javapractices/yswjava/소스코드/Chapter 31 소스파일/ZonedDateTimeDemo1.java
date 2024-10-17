package study.javapractices.yswjava.소스코드.Chapter

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

class ZonedDateTimeDemo1 {
    public static void main(String[] args) {
        // �̰��� ���� ��¥�� �ð�
        ZonedDateTime here = ZonedDateTime.now();
        System.out.println(here);

        // ������ ��¥�� �ð��� �ĸ�
        ZonedDateTime paris = ZonedDateTime.of(
                               here.toLocalDateTime(), ZoneId.of("Europe/Paris"));
        System.out.println(paris);

        // �̰��� �ĸ��� ���� 
        Duration diff = Duration.between(here, paris);
        System.out.println(diff);
    }
}