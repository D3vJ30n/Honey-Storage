package study.javapractices.yswjava.소스코드.Chapter

import com.wxfx.smart.Circle;

class ImportCircle {
    public static void main(String args[]) {
        Circle c1 = new Circle(3.5);
        System.out.println("������ 3.5 �� ����: " + c1.getArea());
        
        Circle c2 = new Circle(5.5);
        System.out.println("������ 5.5 �� ����: " + c2.getArea());
    }
}