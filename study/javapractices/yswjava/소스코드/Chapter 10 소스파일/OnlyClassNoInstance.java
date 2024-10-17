package study.javapractices.yswjava.소스코드.Chapter

class InstCnt {
    static int instNum = 100;

    InstCnt() {
        instNum++;
        System.out.println("�ν��Ͻ� ����: " + instNum);
    }
}

class OnlyClassNoInstance {
    public static void main(String[] args) {
        InstCnt.instNum -= 15;
        System.out.println(InstCnt.instNum);
    }
}
