package study.javapractices.yswjava.소스코드.Chapter

class Method2Param {
    public static void main(String[] args) {
        double myHeight = 175.9;

        hiEveryone(12, 12.5);
        hiEveryone(13, myHeight);

        byEveryone();
    }
	
    public static void hiEveryone(int age, double height) {
        System.out.println("�� ���̴� "+ age + "�� �Դϴ�.");
        System.out.println("���� Ű�� "+ height + "cm �Դϴ�.");	
    }
	
    public static void byEveryone() {
        System.out.println("������ �˰ڽ��ϴ�.");
    }
 }