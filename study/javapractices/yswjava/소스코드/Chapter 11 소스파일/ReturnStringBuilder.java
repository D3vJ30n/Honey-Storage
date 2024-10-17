package study.javapractices.yswjava.소스코드.Chapter

class ReturnStringBuilder {
    public static void main(String[] args) {
        StringBuilder stb1 = new StringBuilder("123");
        StringBuilder stb2 = stb1.append(45678);
        
        System.out.println(stb1.toString());
        System.out.println(stb2.toString());

        stb2.delete(0, 5);

        System.out.println(stb1.toString());
        System.out.println(stb2.toString());

        if(stb1 == stb2)
            System.out.println("���� �ν��Ͻ� ����");
        else
            System.out.println("�ٸ� �ν��Ͻ� ����");
    }
}