package study.javapractices.yswjava.소스코드.Chapter

import java.time.LocalDateTime;
import java.time.Period;
import java.time.Duration;


class LocalDateTimeDemo2 {
    public static void main(String[] args) {
        // ���� �ð�
        LocalDateTime today = 
                LocalDateTime.of(2020, 4, 25, 11, 20);

        // �װ���1�� ��� �ð�
        LocalDateTime flight1 = 
                LocalDateTime.of(2020, 5, 14, 11, 15);
        
        // �װ���2�� ��� �ð�
        LocalDateTime flight2 = 
                LocalDateTime.of(2020, 5, 13, 15, 30);


        // ���� �װ����� �����ϴ� ����
        LocalDateTime myFlight;
    
        if(flight1.isBefore(flight2))
            myFlight = flight1;
        else
            myFlight = flight2;

        // ���� �װ����� ���� ž�±��� ���� ��¥ ���
        Period day = Period.between(today.toLocalDate(), myFlight.toLocalDate());

        // ���� �װ����� ���� ž�±��� ���� �ð� ���
        Duration time = Duration.between(today.toLocalTime(), myFlight.toLocalTime());

        // ���� ž�±��� ���� ��¥�� �ð� ���
        System.out.println(day);
        System.out.println(time);
    }
}