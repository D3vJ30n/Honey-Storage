package study.javapractices;// Practice2
// 아래 클래스와 상속 관계에서
// Test code를 수정하지 않고, 아래와 같이 출력될 수 있도록 오버라이딩 해보세요.
// 빵빵!
// 위이잉!
// 빵빵!
// 삐뽀삐보!

class Car {
    Car(){}
    public void horn() {
        System.out.println("빵빵!");
    }
}

class fireTruck extends Car {
    public void horn() {
        super.horn();
        System.out.println("위이잉!");
    }
}

class ambulance extends Car {
    public void horn() {
        super.horn();
        System.out.println("삐뽀삐뽀!");
    }
}

public class 상속2 {
    public static void main(String[] args) {
        // Test code
        fireTruck truck = new fireTruck();
        truck.horn();

        ambulance amb = new ambulance();
        amb.horn();
    }
}
