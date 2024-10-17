// Java 프로그래밍 - 반복문
// 이 클래스는 for, while, do-while 등 다양한 반복문의 사용법을 설명합니다.
// 반복문은 같은 코드를 여러 번 실행해야 할 때 사용되며, 프로그래밍의 핵심 구문입니다.
public class 반복문 {
    public static void main(String[] args) {
        // 1. 반복문 - for
        // for문은 반복 횟수가 정해져 있을 때 주로 사용합니다.
        System.out.println("== for ==");

        // 1-1. 기본 사용 방법
        // for(초기화; 조건; 증감) 형태로 사용
        // 초기화는 한 번만 실행되고, 조건 검사 후 코드 실행, 그 다음 증감이 실행됩니다.
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        // 중첩 for문을 사용한 삼각형 별 패턴 출력
        // 외부 루프는 행을, 내부 루프는 각 행의 별 개수를 제어합니다.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();  // 줄바꿈
        }

        System.out.println();
        // continue를 사용한 특정 조건 건너뛰기
        // i가 2일 때는 별을 출력하지 않고 다음 반복으로 넘어갑니다.
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                continue;  // 현재 반복을 중단하고 다음 반복으로 진행
            }

            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        // break를 사용한 반복문 종료
        // i가 2가 되면 반복문을 완전히 종료합니다.
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                break;  // 반복문을 완전히 종료
            }

            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 1-2. for each
        // 배열이나 컬렉션의 모든 요소를 순회할 때 사용하는 향상된 for문
        System.out.println();
        int[] nums = {1, 2, 3, 4, 5};
        
        // 전통적인 인덱스 기반 접근
        for (int i = 0; i < 5; i++) {
            System.out.println(nums[i]);
        }

        // for-each를 사용한 더 간단한 접근
        // 배열의 각 요소를 자동으로 순회합니다.
        for (int num : nums) {
            System.out.println(num);
        }

        // 2. 반복문 - while
        // while문은 반복 횟수가 정해지지 않았을 때 주로 사용합니다.
        System.out.println("== while ==");
        
        // 2-1. while
        // 조건이 참인 동안 계속 실행됩니다.
        System.out.println();
        int i = 0;
        while (i < 5) {
            System.out.println(i++);
        }

        // continue를 사용한 while문
        System.out.println();
        i = 0;
        while (i < 5) {
            if (i == 2) {
                i++;
                continue;  // 2를 건너뛰고 계속 진행
            }
            System.out.println(i++);
        }

        // break를 사용한 while문
        System.out.println();
        i = 0;
        while (i < 5) {
            if (i == 2) {
                i++;
                break;  // i가 2일 때 반복문 종료
            }
            System.out.println(i++);
        }

        // 2-2. do-while
        // 조건 검사 전에 무조건 한 번은 실행하는 반복문
        // 최소 1회 실행이 필요한 경우에 사용합니다.
        boolean knock = false;
        do {
            System.out.println("knock");
        } while (knock);  // knock이 false여도 한 번은 실행됨

        // Q1. 홀수 줄에만 별을 출력하는 패턴
        // continue를 활용하여 짝수 줄은 건너뛰기, continue는 현재 반복문의 나머지 코드를 건너뛰고 다음 반복을 진행
        for (int m = 0; m < 8; m++) {
            if (m % 2 == 0) {  // 짝수 줄은 건너뛰기
                continue;
            }

            for (int n = 0; n < m; n++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Q2. 물 끓이기 시뮬레이션
        // while문을 사용하여 온도가 100도가 될 때까지 반복
        // 10도 단위로 현재 온도를 출력
        int waterTemperature = 0;
        while (waterTemperature < 100) {
            waterTemperature++;  // 온도를 1도씩 증가

            if (waterTemperature % 10 == 0) {  // 10도 단위일 때만 출력, 0은 나머지가 없는 상태를 의미, 25도일 때는 나머지가 5이므로 출력 안 함
                System.out.println(waterTemperature + "도 입니다.");
            }
        }
    }
}

// 별 찍기 패턴 상세 설명
/*
이중 for문을 사용한 삼각형 별 패턴의 동작 원리

외부 for문 (i)
- 전체 행의 수를 제어 (0부터 4까지, 총 5행)
- i는 현재 행 번호를 나타냄

내부 for문 (j)
- 각 행에서 출력할 별의 개수를 제어
- j는 0부터 i+1 미만까지 반복
- 각 행에서 i+1개의 별을 출력

실행 과정 분석:

1번째 행 (i = 0):
    - j는 0부터 0+1 미만 → 1회 반복
    - 출력: *
    - 줄바꿈

2번째 행 (i = 1):
    - j는 0부터 1+1 미만 → 2회 반복
    - 출력: **
    - 줄바꿈

3번째 행 (i = 2):
    - j는 0부터 2+1 미만 → 3회 반복
    - 출력: ***
    - 줄바꿈

4번째 행 (i = 3):
    - j는 0부터 3+1 미만 → 4회 반복
    - 출력: ****
    - 줄바꿈

5번째 행 (i = 4):
    - j는 0부터 4+1 미만 → 5회 반복
    - 출력: *****
    - 줄바꿈

최종 출력 결과:
*
**
***
****
*****

주요 포인트:
1. i+1을 사용하는 이유: 각 행의 별 개수가 행 번호보다 1개 많아야 함
2. System.out.print("*"): 별을 이어서 출력
3. System.out.println(): 행이 끝날 때 줄바꿈
*/

// 실제 코드 구현
public class StarPattern {
    public static void main(String[] args) {
        // 외부 for문: 행의 수 제어
        for (int i = 0; i < 5; i++) {
            // 내부 for문: 각 행의 별 개수 제어
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");  // 별을 옆으로 이어서 출력
            }
            System.out.println();  // 한 행이 끝나면 줄바꿈
        }
    }
}

// 변수 값 변화 추적
/*
반복 횟수    i    내부 for문 반복 횟수(i+1)    출력
1번째       0           1                   *
2번째       1           2                   **
3번째       2           3                   ***
4번째       3           4                   ****
5번째       4           5                   *****
*/

// continue를 사용한 별 찍기 패턴 상세 설명
/*
continue문이 포함된 별 찍기의 동작 원리

외부 for문 (i)
- 전체 행의 수를 제어 (0부터 4까지, 총 5행)
- i가 2일 때는 continue로 인해 해당 행을 건너뜀

continue문의 역할
- i가 2일 때 현재 반복을 즉시 중단하고 다음 반복으로 넘어감
- 내부 for문이 실행되지 않아 별이 출력되지 않음

실행 과정 분석:

1번째 행 (i = 0):
    - i != 2 이므로 continue 미실행
    - j는 0부터 0+1 미만 → 1회 반복
    - 출력: *
    - 줄바꿈

2번째 행 (i = 1):
    - i != 2 이므로 continue 미실행
    - j는 0부터 1+1 미만 → 2회 반복
    - 출력: **
    - 줄바꿈

3번째 행 (i = 2):
    - i == 2 이므로 continue 실행
    - 내부 for문 실행하지 않고 다음 반복으로 이동
    - 아무것도 출력하지 않음

4번째 행 (i = 3):
    - i != 2 이므로 continue 미실행
    - j는 0부터 3+1 미만 → 4회 반복
    - 출력: ****
    - 줄바꿈

5번째 행 (i = 4):
    - i != 2 이므로 continue 미실행
    - j는 0부터 4+1 미만 → 5회 반복
    - 출력: *****
    - 줄바꿈

최종 출력 결과:
*
**
****
*****

주목할 점:
1. continue문으로 인해 3번째 행(i=2)이 출력되지 않음
2. 나머지 행은 정상적으로 별이 출력됨
3. 전체적인 패턴에서 3번째 행만 비어있음
*/

// 실제 코드 구현
public class ContinueStarPattern {
    public static void main(String[] args) {
        // 외부 for문: 행의 수 제어
        for (int i = 0; i < 5; i++) {
            // i가 2일 때 현재 반복을 건너뛰기
            if (i == 2) {
                continue;  // 현재 반복을 중단하고 다음 반복으로 진행
            }

            // 내부 for문: 각 행의 별 개수 제어
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();  // 한 행이 끝나면 줄바꿈
        }
    }
}

// 변수 값 변화 추적
/*
반복 횟수    i    continue 실행    내부 for문 반복 횟수    출력
1번째       0        X               1                *
2번째       1        X               2                **
3번째       2        O               0                (건너뜀)
4번째       3        X               4                ****
5번째       4        X               5                *****
*/