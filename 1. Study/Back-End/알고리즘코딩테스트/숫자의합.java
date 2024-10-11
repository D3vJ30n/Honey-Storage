package 알고리즘코딩테스트;

import java.util.Scanner;  // 사용자 입력을 받기 위한 Scanner 클래스 import

// public: 이 클래스를 다른 패키지에서도 접근할 수 있게 함
// class: 자바 프로그램의 기본 구조 단위
public class 숫자의합 {
    // public: 메인 메소드는 JVM에 의해 호출되므로 public으로 선언
    // static: 객체 생성 없이 호출 가능하게 함 (JVM이 직접 호출)
    // void: 반환값이 없음을 나타냄
    // main: 자바 프로그램의 진입점
    // String[] args: 커맨드 라인 인자를 받기 위한 매개변수
    public static void main(String[] args) {
        // Scanner 객체 생성. System.in은 표준 입력(키보드)을 의미
        // Scanner: 다양한 타입의 입력을 받을 수 있는 클래스
        // System.in: 표준 입력 스트림 (키보드 입력)
        Scanner sc = new Scanner(System.in);

        // 숫자의 개수 N을 입력받음
        // nextInt(): 다음 정수를 읽어옴
        // int: 정수를 저장하기 위한 기본 데이터 타입
        int N = sc.nextInt();

        // N개의 숫자를 하나의 문자열로 입력받음
        // next(): 다음 토큰(공백으로 구분된 문자열)을 읽어옴
        // String: 문자열을 저장하는 참조 데이터 타입
        String sNum = sc.next();

        // 입력받은 문자열을 char 배열로 변환
        // 이렇게 하면 문자열의 각 문자에 쉽게 접근할 수 있음
        // toCharArray(): 문자열을 char 배열로 변환
        // char[]: 문자 배열, 각 문자에 인덱스로 접근 가능
        char[] cNum = sNum.toCharArray();
        
        // 숫자들의 합을 저장할 변수 초기화
        int sum = 0;
        
        // char 배열의 각 요소를 순회하면서 합 계산
        // for: 반복문, 배열의 모든 요소를 순회
        // i < cNum.length: 배열의 길이만큼 반복
        for (int i = 0; i < cNum.length; i++) {
            // char를 int로 변환하여 더함
            // ASCII 코드에서 '0'은 48이므로, 문자 '1'은 49, '2'는 50, ...
            // 따라서 '0'을 빼주면 실제 숫자 값을 얻을 수 있음
            // +=: 복합 대입 연산자, sum = sum + (cNum[i] - '0')와 동일
            // cNum[i]: 배열의 i번째 요소에 접근
            // - '0': char를 int로 변환하는 기법 (ASCII 값 차이 이용)
            sum += cNum[i] - '0';
        }
        
        // 계산된 합 출력
        // println: 콘솔에 출력하고 줄바꿈
        System.out.println(sum);
        
        // Scanner 객체 닫기 (리소스 해제)
        // close(): Scanner 객체가 사용한 시스템 리소스를 해제
        sc.close();
    }
}

/*
 * next() vs nextInt()

nextInt(): 다음 정수를 읽어옵니다. 입력 스트림에서 정수가 아닌 값을 만나면 거기서 읽기를 멈춥니다.
next(): 다음 완전한 토큰(공백으로 구분된 문자열)을 읽어옵니다. 이는 정수, 문자, 문자열 등 어떤 형태든 될 수 있습니다.


토큰(Token)의 의미

프로그래밍에서 토큰은 더 이상 나눌 수 없는 최소 단위의 데이터 조각을 의미합니다.
입력 스트림에서는 주로 공백(스페이스, 탭, 줄바꿈 등)으로 구분된 각각의 단어나 숫자를 토큰이라고 합니다.


이 코드에서 next()를 사용한 이유

문제에서 N개의 숫자를 하나의 문자열로 입력받도록 요구했기 때문입니다.
예를 들어, 입력이 "54321"과 같이 공백 없이 붙어있는 숫자들이라면, 이를 하나의 문자열로 읽어와야 합니다.
nextInt()를 사용하면 각 숫자를 개별적으로 읽게 되어, 의도한 대로 동작하지 않습니다.


예시
Copy입력: 5 54321

여기서 5는 N의 값으로 nextInt()로 읽습니다.
"54321"은 하나의 토큰으로 간주되어 next()로 한 번에 읽을 수 있습니다.


주의할 점

nextInt() 다음에 next()나 nextLine()을 사용할 때는 주의가 필요합니다. nextInt() 후 남은 줄바꿈 문자를 처리해야 할 수 있습니다.


따라서, 이 문제에서는 여러 숫자를 하나의 문자열로 입력받아야 하므로 next()를 사용하는 것이 적절합니다. 이렇게 하면 공백 없이 연속된 숫자들을 하나의 문자열로 쉽게 읽어올 수 있습니다.

char의 정의

char는 indeed 문자를 나타내는 자바의 기본 데이터 타입입니다.
하지만 자바에서 char는 단순히 문자만 나타내는 것이 아니라, 유니코드 문자를 표현합니다.


char와 숫자의 관계

각 char는 내부적으로 16비트 부호 없는 정수로 표현됩니다.
이는 0부터 65,535 사이의 값을 가질 수 있음을 의미합니다.
예를 들어, 문자 '0'은 내부적으로 정수 48로 표현됩니다.


toCharArray() 메소드

이 메소드는 String을 개별 문자(char)의 배열로 변환합니다.
예: "123"이라는 문자열은 {'1', '2', '3'}이라는 char 배열로 변환됩니다.


숫자 문자열 처리

숫자를 나타내는 문자('0'부터 '9')는 각각 고유한 유니코드 값을 가집니다.
'0'은 48, '1'은 49, ..., '9'는 57의 유니코드 값을 가집니다.


문자를 숫자로 변환

코드에서 cNum[i] - '0'를 사용하는 이유가 바로 이것입니다.
예: '5' - '0' = 53 - 48 = 5 (실제 정수 값)

따라서, toCharArray()는 문자열을 문자 배열로 변환하지만, 이 문자들은 숫자 문자일 경우 쉽게 실제 숫자 값으로 변환될 수 있습니다. 이 방법은 숫자 문자열을 처리할 때 자주 사용되는 효율적인 기법입니다.

 */