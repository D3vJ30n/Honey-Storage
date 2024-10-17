package study.javapractices.yswjava.소스코드.Chapter

import java.util.Scanner;

class ReadAgeException extends Exception {
    public ReadAgeException() {
        super("��ȿ���� ���� ���̰� �ԷµǾ����ϴ�.");
    }
}

class MyExceptionClass {
    public static void main(String[] args) {
        System.out.print("���� �Է�: ");
    
        try {
            int age = readAge();
            System.out.printf("�Էµ� ����: %d \n", age);
        }
        catch(ReadAgeException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static int readAge() throws ReadAgeException {
        Scanner kb = new Scanner(System.in);
        int age = kb.nextInt();
        
        if(age < 0)
            throw new ReadAgeException();

        return age;
    }
}