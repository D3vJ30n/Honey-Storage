package study.javapractices.yswjava.소스코드.Chapter

class SuperCLS {
    public SuperCLS () {
        System.out.println("I'm Super Class");
    }
}

class SubCLS extends SuperCLS {
    public SubCLS () {
        System.out.println("I'm Sub Class");
    }
}

class SuperSubCon {
    public static void main(String[] args) {
        new SubCLS ();
    }
}