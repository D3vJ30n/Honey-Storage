package study.javapractices.yswjava.문제의

class Car {      // �⺻ ���� �ڵ���
    int gasolineGauge;
    
    public Car(int oil) {
        gasolineGauge = oil;
    }
}

class HybridCar extends Car {    // ���̺긮�� �ڵ���
    int electricGauge;
    
    public HybridCar(int oil, int ele) {
        super(oil);
        electricGauge = ele;
    }
}

class HybridWaterCar extends HybridCar {    // ���̺긮�� ����ī
    int waterGauge;
    
    public HybridWaterCar(int oil, int ele, int wat) {
        super(oil, ele);
        waterGauge = wat;
    }
    
    public void showCurrentGauge() {
        System.out.println("�ܿ� ���ָ�: " + gasolineGauge);
        System.out.println("�ܿ� ���ⷮ: " + electricGauge);
        System.out.println("�ܿ� ���ͷ�: " + waterGauge);
    }
}

class ConstructorAndSuper {
    public static void main(String[] args) {
        HybridWaterCar hwCar1 = new HybridWaterCar(4, 2, 3);
        hwCar1.showCurrentGauge();
        
        HybridWaterCar hwCar2 = new HybridWaterCar(9, 5, 7);
        hwCar2.showCurrentGauge();
    }
}
