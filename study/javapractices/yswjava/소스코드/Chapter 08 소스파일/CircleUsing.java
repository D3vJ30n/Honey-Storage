package study.javapractices.yswjava.소스코드.Chapter

class CircleUsing {
    public static void main(String args[]) {
        com.wxfx.smart.Circle c1 = new com.wxfx.smart.Circle(3.5);
        System.out.println("������ 3.5 �� ����: " + c1.getArea());
        
        com.fxmx.simple.Circle c2 = new com.fxmx.simple.Circle(3.5);
        System.out.println("������ 3.5 �� �ѷ�: " + c2.getPerimeter());
    }
}