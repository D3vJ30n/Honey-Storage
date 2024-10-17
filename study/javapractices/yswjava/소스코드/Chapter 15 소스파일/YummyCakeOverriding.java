package study.javapractices.yswjava.소스코드.Chapter

class Cake {
    public void yummy() { 
        System.out.println("Yummy Cake");
    }
}
   
class CheeseCake extends Cake { 
    // Cake�� yummy �޼ҵ带 �������̵� ��
    public void yummy() { 
        System.out.println("Yummy Cheese Cake");
    }
}

class YummyCakeOverriding {
    public static void main(String[] args) {
        Cake c1 = new CheeseCake();
        CheeseCake c2 = new CheeseCake();
        
        c1.yummy();
        c2.yummy();
    }
}