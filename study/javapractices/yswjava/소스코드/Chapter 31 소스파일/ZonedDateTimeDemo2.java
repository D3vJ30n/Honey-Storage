package study.javapractices.yswjava.소스코드.Chapter

import java.time.Duration;
import java.time.ZoneId;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

class ZonedDateTimeDemo2 {
    public static void main(String[] args) {
        // �ѱ� ��� 2017-09-09  14:30
        ZonedDateTime departure = ZonedDateTime.of(
                LocalDateTime.of(2017, 12, 9, 14, 30), ZoneId.of("Asia/Seoul"));

        System.out.println("Departure : " + departure);

        // �ĸ� ���� 2017-09-09  17:25
        ZonedDateTime arrival = ZonedDateTime.of(
                LocalDateTime.of(2017, 12, 9, 17, 25), ZoneId.of("Europe/Paris"));

        System.out.println("Arrival : " + arrival);

        // ���� �ð�
        System.out.println("Flight Time : " + 
                Duration.between(departure, arrival));
    }
}
