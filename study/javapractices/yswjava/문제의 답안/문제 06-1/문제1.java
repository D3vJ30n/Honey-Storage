package study.javapractices.yswjava.문제의

class SimpleOperation {
    public static void main(String[] args) {
        simpleOpr(7, 3);
    }
    
    public static void simpleOpr(int n1, int n2) {
        System.out.println("���� ���: " + (n1 + n2));
        System.out.println("���� ���: " + (n1 - n2));
        System.out.println("���� ���: " + (n1 * n2));
        System.out.println("�������� ��: " + (n1 / n2));
        System.out.println("�������� ������: " + (n1 % n2));
    }
}
