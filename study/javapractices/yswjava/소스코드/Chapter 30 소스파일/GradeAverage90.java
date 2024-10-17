package study.javapractices.yswjava.소스코드.Chapter

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.DoubleStream;

class ReportCard {
    private int kor;    // ���� ����
    private int eng;    // ���� ����
    private int math;    // ���� ����
    
    public ReportCard(int k, int e, int m) {
        kor = k;
        eng = e;
        math = m;    
    }
    public int getKor() { return kor; }
    public int getEng() { return eng; }
    public int getMath() { return math; }
}


class GradeAverage90 {
    public static void main(String[] args) {
        ReportCard[] cards = {
            new ReportCard(98, 84, 90),
            new ReportCard(92, 87, 95),
            new ReportCard(85, 99, 93)
        };       

        boolean b1 = Arrays.stream(cards)
              .mapToDouble(
                  r -> (r.getKor() + r.getEng() + r.getMath()) / 3.0)
              .anyMatch(avg -> avg >= 90.0);
        System.out.println("��� 90 �̻��� �� �� �̻� �����մϴ�. " + b1);

        if(b1 == true) {
            boolean b2 = Arrays.stream(cards)
                 .mapToDouble(
                     r -> (r.getKor() + r.getEng() + r.getMath()) / 3.0)
                 .allMatch(avg -> avg >= 90.0);
            System.out.println("��� ��� 90 �̻��Դϴ�. " + b2);
        }
    }
}