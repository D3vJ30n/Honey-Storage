package study.javapractices.yswjava.소스코드.Chapter

class FallThroughWarnings {
 //   @SuppressWarnings("fallthrough")
    public static void main(String[] args) {
        int n = 3;
        
        switch(n) {
        case 1:
            System.out.println(n);            
        case 2:
            System.out.println(n);
        case 3:
            System.out.println(n);
        }
    }
}