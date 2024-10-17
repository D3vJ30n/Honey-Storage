package study.javapractices.yswjava.소스코드.Chapter

enum Animal { DOG, CAT }

enum Person { MAN, WOMAN }

class SafeEnum {
    public static void main(String[] args) {
        System.out.println(Animal.DOG);
        // �������� �޼ҵ� ȣ��
        who(Person.MAN);

        // �������� �޼ҵ� ȣ��
//	who(Animal.DOG);
    }
	
    public static void who(Person man) {
        switch(man) {
        case MAN:
            System.out.println("���� �մ��Դϴ�.");
            break;
        case WOMAN:
            System.out.println("���� �մ��Դϴ�.");
            break;
        }
    }
}
