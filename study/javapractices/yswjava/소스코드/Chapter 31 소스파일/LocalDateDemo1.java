package study.javapractices.yswjava.소스코드.Chapter

import java.time.LocalDate;

class LocalDateDemo1 {
    public static void main(String[] args) {
        // ����
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);
    
        // �� ���� ũ��������
        LocalDate xmas = LocalDate.of(today.getYear(), 12, 25);
        System.out.println("Xmas: " + xmas);

        // �� ���� ũ�������� �̺�
        LocalDate eve = xmas.minusDays(1);
        System.out.println("Xmas Eve: " + eve);        
    }
}