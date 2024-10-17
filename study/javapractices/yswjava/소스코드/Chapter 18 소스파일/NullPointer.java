package study.javapractices.yswjava.소스코드.Chapter

class NullPointer {
    public static void main(String[] args) {
        String str = null;
        System.out.println(str);    // null ���
        int len = str.length();    // Exception! 
    }
}