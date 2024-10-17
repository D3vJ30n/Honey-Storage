package study.javapractices.yswjava.소스코드.Chapter

import java.util.HashSet;

class Num {
    private int num;
    
    public Num(int n) {
        num = n;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}

class HashSetEqualityOne {
    public static void main(String[] args) {    
        HashSet<Num> set = new HashSet<>();
        set.add(new Num(7799));
        set.add(new Num(9955));
        set.add(new Num(7799));

        System.out.println("�ν��Ͻ� ��: " + set.size());

        for(Num n : set)
            System.out.print(n.toString() + '\t');

        System.out.println();
    }
}