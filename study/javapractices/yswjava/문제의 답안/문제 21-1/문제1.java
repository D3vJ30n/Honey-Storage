package study.javapractices.yswjava.문제의

class DBox<L, R> {
    private L left;     // ���� ���� ����
    private R right;    // ������ ���� ����

    public void set(L o, R r) {
        left = o;
        right = r;
    } 
    
    @Override
    public String toString() {
        return left + " & " +right;
    }
}

class DDBox<U, D> {
    private U up;
    private D down;

    public void set(U u, D d) {
        up = u;
        down = d;
    }

    @Override
    public String toString() {
        return up.toString() + "\n" + down.toString();
    }
}

class DDBoxDemo {
    public static void main(String[] args) {
        DBox<String, Integer> box1 = new DBox<>();
        box1.set("Apple", 25);

        DBox<String, Integer> box2 = new DBox<>();
        box2.set("Orange", 33);
        
        DDBox<DBox<String, Integer>, DBox<String, Integer>> ddbox = new DDBox<>();
        ddbox.set(box1, box2);

        System.out.println(ddbox);
    }
}