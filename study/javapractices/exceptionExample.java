package study.javapractices;// Java 프로그래밍 - 예외 처리

class NotTenException extends RuntimeException { }


/**
 * 자바 예외처리 쉽게 설명하기
 * 
 * 예외(Exception)란?
 * - 프로그램 실행 중 발생하는 예상치 못한 문제상황
 * - 실생활로 비유하면: 
 *   - 식당에서 주문한 메뉴가 품절된 상황
 *   - 은행 ATM에서 잔액보다 많은 금액을 출금하려는 상황
 *   - 주차장에서 주차공간을 벗어나 주차하려는 상황
 */
public class exceptionExample {
    public static void main(String[] args) {
        System.out.println("==== 예외처리 배우기 ====\n");
        
        // 1. 가장 기본적인 예외처리
        basicException();
        
        // 2. 여러 예외를 한번에 처리하기
        multipleException();
        
        // 3. finally 사용하기
        finallyExample();
        
        // 4. 직접 예외 발생시키기
        throwExample();
    }
    
    // 1. 가장 기본적인 예외처리
    public static void basicException() {
        System.out.println("1. 기본 예외처리 배우기");
        
        // try: 예외가 발생할 수 있는 코드를 감싸는 부분
        try {
            // 배열의 크기는 3인데, 5번째 위치에 접근하려고 함 (에러 발생!)
            int[] numbers = new int[3];
            System.out.println("배열의 5번째 요소에 접근해볼게요");
            numbers[5] = 10;  // 여기서 에러가 발생합니다!
            
            // 위에서 에러가 발생하면 이 코드는 실행되지 않습니다
            System.out.println("이 메시지는 보이지 않을 거예요");
            
        } catch (ArrayIndexOutOfBoundsException e) {
            // catch: 에러가 발생했을 때 실행되는 부분
            System.out.println("⚠️ 에러 발생! 배열의 범위를 벗어났어요");
            System.out.println("- 자세한 에러 메시지: " + e.getMessage());
        }
        
        System.out.println("프로그램은 계속 실행됩니다!\n");
    }
    
    // 2. 여러 예외를 한번에 처리하기
    public static void multipleException() {
        System.out.println("2. 여러 예외 한번에 처리하기");
        
        try {
            String text = null;
            int number;
            
            // 상황에 따라 다른 에러를 발생시켜 봅시다
            if (Math.random() < 0.5) {
                // null인 상태에서 메소드를 호출하면 NullPointerException 발생
                System.out.println(text.length());
            } else {
                // 문자를 숫자로 변환하려고 하면 NumberFormatException 발생
                number = Integer.parseInt("숫자가아님");
            }
            
        } catch (NullPointerException e) {
            // null 객체를 사용하려고 할 때의 예외처리
            System.out.println("⚠️ null인 객체를 사용하려고 했어요!");
            System.out.println("- 자세한 에러 메시지: " + e.getMessage());
            
        } catch (NumberFormatException e) {
            // 숫자 변환 실패시의 예외처리
            System.out.println("⚠️ 문자를 숫자로 변환할 수 없어요!");
            System.out.println("- 자세한 에러 메시지: " + e.getMessage());
            
        } catch (Exception e) {
            // 위의 catch문에서 처리되지 않은 모든 예외를 처리
            // 마지막에 사용하는 것이 좋습니다
            System.out.println("⚠️ 알 수 없는 에러가 발생했어요!");
            System.out.println("- 자세한 에러 메시지: " + e.getMessage());
        }
        
        System.out.println("여러 예외처리 테스트 완료!\n");
    }
    
    // 3. finally 사용하기
    public static void finallyExample() {
        System.out.println("3. finally 사용하기");
        
        try {
            System.out.println("프로그램이 시작되었어요");
            // 일부러 예외를 발생시켜봅시다
            System.out.println(10 / 0);  // 0으로 나누면 에러!
            
        } catch (ArithmeticException e) {
            System.out.println("⚠️ 계산 중 에러가 발생했어요!");
            System.out.println("- 자세한 에러 메시지: " + e.getMessage());
            
        } finally {
            // finally: 에러 발생 여부와 관계없이 항상 실행되는 부분
            System.out.println("🔄 finally: 이 부분은 무조건 실행됩니다!");
        }
        
        System.out.println("finally 테스트 완료!\n");
    }
    
    // 4. 직접 예외 발생시키기
    public static void throwExample() {
        System.out.println("4. 직접 예외 발생시키기");
        
        try {
            int age = -5;  // 나이를 음수로 설정
            
            // 나이가 음수이면 안되므로, 직접 예외를 발생시킵니다
            if (age < 0) {
                throw new IllegalArgumentException("나이는 음수가 될 수 없어요!");
            }
            
            System.out.println("나이: " + age);
            
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ 잘못된 값이 입력되었어요!");
            System.out.println("- 자세한 에러 메시지: " + e.getMessage());
        }
        
        System.out.println("예외 발생시키기 테스트 완료!\n");
    }
}

/*

🌟 **예외처리 쉽게 이해하기**

1. **예외(Exception)가 뭔가요?**
   - 프로그램 실행 중 발생하는 예상치 못한 문제상황입니다.
   - 실생활의 예:
     - 식당에서 주문한 메뉴가 품절된 상황
     - ATM에서 잔액보다 많은 금액을 출금하려는 상황
     - 주차장에서 주차공간을 벗어나 주차하려는 상황

2. **예외처리가 왜 필요한가요?**
   - 프로그램이 갑자기 중단되는 것을 방지하기 위해
   - 문제가 생겼을 때 적절한 대응을 하기 위해
   - 사용자에게 친절한 메시지를 보여주기 위해

3. **예외처리 기본 구조**
   ```java
   try {
       // 문제가 생길 수 있는 코드
   } catch (예외종류 변수명) {
       // 문제가 생겼을 때 실행할 코드
   }
   ```

4. **주요 예외 종류**
   - NullPointerException: null인 객체를 사용하려고 할 때
   - ArrayIndexOutOfBoundsException: 배열의 범위를 벗어났을 때
   - NumberFormatException: 숫자가 아닌 것을 숫자로 변환하려 할 때
   - IllegalArgumentException: 잘못된 값을 사용했을 때

5. **실행 결과 예시**
```
==== 예외처리 배우기 ====

1. 기본 예외처리 배우기
배열의 5번째 요소에 접근해볼게요
⚠️ 에러 발생! 배열의 범위를 벗어났어요
- 자세한 에러 메시지: Index 5 out of bounds for length 3
프로그램은 계속 실행됩니다!

...
```

6. **예외처리 사용 팁**
   - try 블록은 최소한의 코드만 포함하기
   - 구체적인 예외부터 처리하기 (Exception은 마지막에)
   - 예외 메시지는 친절하고 명확하게 작성하기
   - finally는 꼭 필요할 때만 사용하기

*/

/**
 * 자바 예외처리 쉽게 설명하기
 * 
 * 예외(Exception)란?
 * - 프로그램 실행 중 발생하는 예상치 못한 문제상황
 * - 실생활로 비유하면: 
 *   - 식당에서 주문한 메뉴가 품절된 상황
 *   - 은행 ATM에서 잔액보다 많은 금액을 출금하려는 상황
 *   - 주차장에서 주차공간을 벗어나 주차하려는 상황
 */
class ExceptionExample {
    public static void main(String[] args) {
        System.out.println("==== 예외처리 배우기 ====\n");
        
        // 1. 가장 기본적인 예외처리
        basicException();
        
        // 2. 여러 예외를 한번에 처리하기
        multipleException();
        
        // 3. finally 사용하기
        finallyExample();
        
        // 4. 직접 예외 발생시키기
        throwExample();
    }
    
    // 1. 가장 기본적인 예외처리
    public static void basicException() {
        System.out.println("1. 기본 예외처리 배우기");
        
        // try: 예외가 발생할 수 있는 코드를 감싸는 부분
        try {
            // 배열의 크기는 3인데, 5번째 위치에 접근하려고 함 (에러 발생!)
            int[] numbers = new int[3];
            System.out.println("배열의 5번째 요소에 접근해볼게요");
            numbers[5] = 10;  // 여기서 에러가 발생합니다!
            
            // 위에서 에러가 발생하면 이 코드는 실행되지 않습니다
            System.out.println("이 메시지는 보이지 않을 거예요");
            
        } catch (ArrayIndexOutOfBoundsException e) {
            // catch: 에러가 발생했을 때 실행되는 부분
            System.out.println("⚠️ 에러 발생! 배열의 범위를 벗어났어요");
            System.out.println("- 자세한 에러 메시지: " + e.getMessage());
        }
        
        System.out.println("프로그램은 계속 실행됩니다!\n");
    }
    
    // 2. 여러 예외를 한번에 처리하기
    public static void multipleException() {
        System.out.println("2. 여러 예외 한번에 처리하기");
        
        try {
            String text = null;
            int number;
            
            // 상황에 따라 다른 에러를 발생시켜 봅시다
            if (Math.random() < 0.5) {
                // null인 상태에서 메소드를 호출하면 NullPointerException 발생
                System.out.println(text.length());
            } else {
                // 문자를 숫자로 변환하려고 하면 NumberFormatException 발생
                number = Integer.parseInt("숫자가아님");
            }
            
        } catch (NullPointerException e) {
            // null 객체를 사용하려고 할 때의 예외처리
            System.out.println("⚠️ null인 객체를 사용하려고 했어요!");
            System.out.println("- 자세한 에러 메시지: " + e.getMessage());
            
        } catch (NumberFormatException e) {
            // 숫자 변환 실패시의 예외처리
            System.out.println("⚠️ 문자를 숫자로 변환할 수 없어요!");
            System.out.println("- 자세한 에러 메시지: " + e.getMessage());
            
        } catch (Exception e) {
            // 위의 catch문에서 처리되지 않은 모든 예외를 처리
            // 마지막에 사용하는 것이 좋습니다
            System.out.println("⚠️ 알 수 없는 에러가 발생했어요!");
            System.out.println("- 자세한 에러 메시지: " + e.getMessage());
        }
        
        System.out.println("여러 예외처리 테스트 완료!\n");
    }
    
    // 3. finally 사용하기
    public static void finallyExample() {
        System.out.println("3. finally 사용하기");
        
        try {
            System.out.println("프로그램이 시작되었어요");
            // 일부러 예외를 발생시켜봅시다
            System.out.println(10 / 0);  // 0으로 나누면 에러!
            
        } catch (ArithmeticException e) {
            System.out.println("⚠️ 계산 중 에러가 발생했어요!");
            System.out.println("- 자세한 에러 메시지: " + e.getMessage());
            
        } finally {
            // finally: 에러 발생 여부와 관계없이 항상 실행되는 부분
            System.out.println("🔄 finally: 이 부분은 무조건 실행됩니다!");
        }
        
        System.out.println("finally 테스트 완료!\n");
    }
    
    // 4. 직접 예외 발생시키기
    public static void throwExample() {
        System.out.println("4. 직접 예외 발생시키기");
        
        try {
            int age = -5;  // 나이를 음수로 설정
            
            // 나이가 음수이면 안되므로, 직접 예외를 발생시킵니다
            if (age < 0) {
                throw new IllegalArgumentException("나이는 음수가 될 수 없어요!");
            }
            
            System.out.println("나이: " + age);
            
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ 잘못된 값이 입력되었어요!");
            System.out.println("- 자세한 에러 메시지: " + e.getMessage());
        }
        
        System.out.println("예외 발생시키기 테스트 완료!\n");
    }
}