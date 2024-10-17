package study.javapractices.yswjava.소스코드.Chapter

enum Scale {
   DO, RE, MI, FA, SO, RA, TI
}

class SimpleEnum {
    public static void main(String[] args) {
        Scale sc = Scale.DO;
        System.out.println(sc);

        switch(sc) {
        case DO:
            System.out.println("��~ ");
            break;
        case RE:
            System.out.println("��~ ");
            break;
        case MI:
            System.out.println("��~ ");
            break;
        case FA:
            System.out.println("��~ ");
            break;
        default:
            System.out.println("��~ ��~ ��~ ");
        }
    }
}
