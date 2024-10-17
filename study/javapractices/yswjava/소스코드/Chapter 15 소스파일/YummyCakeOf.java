package study.javapractices.yswjava.소스코드.Chapter

class Cake {
}
   
class CheeseCake extends Cake { 
}

class StrawberryCheeseCake extends CheeseCake{
}

class YummyCakeOf {
    public static void main(String[] args) {
        Cake cake = new StrawberryCheeseCake();
    
        if(cake instanceof Cake) {        
            System.out.println("���� �ν��Ͻ� or");
            System.out.println("���� ����ϴ� �ν��Ͻ� \n");
        }

        if(cake instanceof CheeseCake) {        
            System.out.println("ġ������ �ν��Ͻ� or");
            System.out.println("ġ������ ����ϴ� �ν��Ͻ� \n");
        }

        if(cake instanceof StrawberryCheeseCake) {        
            System.out.println("����ġ������ �ν��Ͻ� or");
            System.out.println("����ġ������ ����ϴ� �ν��Ͻ�");
        }
    }
}