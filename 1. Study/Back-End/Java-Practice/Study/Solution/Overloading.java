// Calculator 클래스 정의
class Calculator {
    // 1. 정수형 매개변수 2개를 받는 sum 메소드
    public int sum(int a, int b) {
        return a + b;    // 정수형 덧셈 수행
    }
    
    // 2. 실수형 매개변수 2개를 받는 sum 메소드
    public double sum(double a, double b) {
        return a + b;    // 실수형 덧셈 수행
    }
    
    // 3. 문자열 매개변수 2개를 받는 sum 메소드
    public double sum(String a, String b) {
        // 문자열을 실수로 변환 후 덧셈
        return Double.parseDouble(a) + Double.parseDouble(b);
    }
    
    // 4. 정수형 매개변수 3개를 받는 sum 메소드
    public int sum(int a, int b, int c) {
        return a + b + c;    // 세 정수의 덧셈 수행
    }
}

public class Practice {
    public static void main(String[] args) {
        // Calculator 객체 생성
        Calculator c = new Calculator();
        
        // 다양한 방식으로 sum 메소드 호출
        System.out.println(c.sum(1, 2));       // 정수형 sum 호출
        System.out.println(c.sum(1.0, 2.0));   // 실수형 sum 호출
        System.out.println(c.sum("1", "2"));   // 문자열 sum 호출
        System.out.println(c.sum(1, 2, 3));    // 3개 매개변수 sum 호출
    }
}

/*
실행 결과:
3      (1 + 2)
3.0    (1.0 + 2.0)
3.0    ("1"과 "2"를 실수로 변환 후 덧셈)
6      (1 + 2 + 3)
*/
