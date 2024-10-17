package study.javapractices.yswjava.소스코드.Chapter

class Person {
    private int regiNum;     // �ֹε�� ��ȣ
    private int passNum;     // ���� ��ȣ
    
    Person(int rnum, int pnum) {
        regiNum = rnum;
        passNum = pnum;
    }
    
    Person(int rnum) {
        regiNum = rnum;
        passNum = 0;
    }
    
    void showPersonalInfo() {
        System.out.println("�ֹε�� ��ȣ: " + regiNum);
        
        if(passNum != 0)
            System.out.println("���� ��ȣ: " + passNum + '\n');
        else
            System.out.println("������ ������ ���� �ʽ��ϴ�. \n");
    }
}

class ConOverloading {
    public static void main(String[] args) {
        // ���� �ִ� ����� ������ ���� �ν��Ͻ� ����
        Person jung = new Person(335577, 112233);
        
        // ���� ���� ����� ������ ���� �ν��Ͻ� ����
        Person hong = new Person(775544);

        jung.showPersonalInfo();
        hong.showPersonalInfo();
    }
}