package study.javapractices.yswjava.소스코드.Chapter

class UseWrapperClass {
    public static void showData(Object obj) {
        System.out.println(obj);
    }

    public static void main(String[] args) {
        // ���� 3���� ä���� ���� �ν��Ͻ� ����
        Integer iInst = new Integer(3);
        showData(iInst);
        
        // �Ǽ� 7.15�� ä���� ���� �ν��Ͻ� ����
        showData(new Double(7.15));
    }
}