package study.javapractices.yswjava.소스코드.Chapter

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collections;

class Car {
    protected int disp;

    public Car(int d) { disp = d; }

    @Override
    public String toString() { 
        return "cc: " + disp; 
    }
}

// Car�� ������ ���� Ŭ���� 
class CarComp implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.disp - o2.disp;
    }
}

class ECar extends Car {
    private int battery;
    
    public ECar(int d, int b) {
        super(d);
        battery = b;
    }

    @Override
    public String toString() { 
        return "cc: " + disp + ", ba: " + battery; 
    }
}

class CarComparator {
    public static void main(String[] args) {
        List<Car> clist = new ArrayList<>();
        clist.add(new Car(1800));
        clist.add(new Car(1200));
        clist.add(new Car(3000));

        List<ECar> elist = new ArrayList<>();
        elist.add(new ECar(3000, 55));
        elist.add(new ECar(1800, 87));
        elist.add(new ECar(1200, 99));
  
        CarComp comp = new CarComp();

        // ���� ����
        Collections.sort(clist, comp);
        Collections.sort(elist, comp);
        

        // ���� ���
        for(Iterator<Car> itr = clist.iterator(); itr.hasNext(); )
            System.out.println(itr.next().toString() + '\t');
        System.out.println();

        for(Iterator<ECar> itr = elist.iterator(); itr.hasNext(); )
            System.out.println(itr.next().toString() + '\t');

    }
}