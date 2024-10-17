package study.javapractices.yswjava.소스코드.Chapter

class Apple {
    public String toString() {
        return "I am an apple.";
    }    
}

class Orange {
    public String toString() {
        return "I am an orange.";
    }
}

class Box {
    private Object ob;

    public void set(Object o) {
        ob = o;
    }
    public Object get() {
        return ob;
    }
}


class FruitAndBox2 {
    public static void main(String[] args) {
        Box aBox = new Box();
        Box oBox = new Box();

        // ������ �ڽ��� ��´�. 
        aBox.set(new Apple());
        oBox.set(new Orange());

        // �ڽ����� ������ ������.
        Apple ap = (Apple)aBox.get();
        Orange og = (Orange)oBox.get();

        System.out.println(ap);
        System.out.println(og);
    }
}