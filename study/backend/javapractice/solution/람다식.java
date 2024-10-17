/**
 * 람다식(Lambda Expression) 상세 예제
 * 파일명: LambdaExample.java
 * 
 * 이 예제는 다음 내용을 다룹니다:
 * 1. 함수형 인터페이스 정의
 * 2. 익명 클래스를 사용한 구현
 * 3. 람다식을 사용한 구현
 * 4. 람다식의 다양한 문법
 */

// @FunctionalInterface 어노테이션은 이 인터페이스가 함수형 인터페이스임을 명시합니다.
// 함수형 인터페이스는 반드시 하나의 추상 메서드만 가져야 합니다.
// 이 어노테이션을 사용하면 실수로 메서드를 추가하는 것을 컴파일러가 방지해줍니다.
@FunctionalInterface
interface CompareTool {
    // 추상 메서드 선언
    // 두 개의 int 매개변수를 받아서 더 큰 수를 반환하는 메서드
    public abstract int getMaxNum(int num1, int num2);
    
    // 만약 여기에 다른 추상 메서드를 추가하면 @FunctionalInterface 규칙에 위배되어 컴파일 에러가 발생합니다.
    // public abstract void anotherMethod(); // 이렇게 추가하면 에러!
}

public class LambdaExample {
    public static void main(String[] args) {
        // 1. 익명 클래스를 사용한 전통적인 방식
        // 익명 클래스란? 이름이 없는 클래스로, 인터페이스나 추상 클래스를 즉석에서 구현하는 방식입니다.
        CompareTool classicWay = new CompareTool() {
            @Override
            public int getMaxNum(int num1, int num2) {
                // 삼항 연산자를 사용하여 두 수를 비교
                // 조건 ? 참일 때 값 : 거짓일 때 값
                return num1 > num2 ? num1 : num2;
            }
        };
        
        // 익명 클래스 방식 테스트
        System.out.println("1. 익명 클래스 방식 결과: " + classicWay.getMaxNum(10, 11));

        // 2. 람다식을 사용한 기본 방식
        // 람다식 기본 문법: (매개변수) -> { 실행문 }
        CompareTool lambdaWay = (num1, num2) -> {
            // 익명 클래스와 동일한 로직
            return num1 > num2 ? num1 : num2;
        };
        
        // 람다식 방식 테스트
        System.out.println("2. 람다식 방식 결과: " + lambdaWay.getMaxNum(10, 11));

        // 3. 람다식 축약 방식
        // 실행문이 한 줄이고 return문만 있는 경우:
        // - 중괄호{} 생략 가능
        // - return 키워드 생략 가능
        // - 세미콜론(;) 생략 가능
        CompareTool shortLambda = (num1, num2) -> num1 > num2 ? num1 : num2;
        
        // 축약된 람다식 테스트
        System.out.println("3. 람다식 축약 방식 결과: " + shortLambda.getMaxNum(10, 11));

        // 4. 람다식의 다양한 활용
        // 매개변수가 하나일 경우 괄호 생략 가능 (다른 인터페이스 예시)
        // Runnable r = () -> System.out.println("실행");  // 매개변수가 없는 경우
        // Consumer<String> c = str -> System.out.println(str);  // 매개변수가 하나인 경우
        
        // 람다식 활용 테스트
        System.out.println("\n다양한 숫자 테스트:");
        testNumbers(shortLambda);
    }
    
    // 람다식으로 구현된 메서드를 다양하게 테스트하는 보조 메서드
    private static void testNumbers(CompareTool tool) {
        // 여러 가지 케이스를 테스트
        System.out.println("100과 200 중 큰 수: " + tool.getMaxNum(100, 200));
        System.out.println("같은 숫자(500) 비교: " + tool.getMaxNum(500, 500));
        System.out.println("-10과 -20 중 큰 수: " + tool.getMaxNum(-10, -20));
    }
}