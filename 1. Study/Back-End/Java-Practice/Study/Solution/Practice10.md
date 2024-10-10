# Practice5

## 문제 설명

N 명의 아이들이 한 줄로 서있다.  
각각의 아이들은 점수 표를 가지고 있는데 점수 표에 따라 다음과 같은 규칙으로 사탕을 나누어 줘야 한다.

- 적어도 1개 이상의 사탕을 나누어줘야 한다.
- 점수가 높은 아이에게는 바로 옆의 아이 보다는 사탕을 많이 줘야 한다.

N 명의 아이들에 대한 점수 표가 ratings 배열에 주어질 때,  
나누어 줘야하는 최소한의 사탕 개수를 출력하세요.

## 입출력 예시

| 입력                               | 출력 |
| ---------------------------------- | ---- |
| 1 2 3                              | 6    |
| 3 2 1                              | 6    |
| 1 0 2                              | 5    |
| 1 2 2                              | 4    |
| 1, 3, 5, 3, 1, 3, 5, 7, 5, 3, 1, 0 | 29   |

이 코드는 아이들에게 사탕을 나누어주는 문제를 해결하는 알고리즘을 구현한 것으로 보입니다. 각 아이의 평가 점수(rating)에 따라 사탕을 분배하는 규칙을 따르고 있습니다. 상세한 설명을 제공하겠습니다.

```java
public class Practice5 {
    public static int solution(int[] ratings) {
        // 입력 검증: ratings 배열이 null이거나 비어있으면 0 반환
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int result = 1;  // 총 사탕 수 (첫 아이에게 1개 주고 시작)
        int upCnt = 1;   // 연속해서 증가하는 rating의 수
        int downCnt = 0; // 연속해서 감소하는 rating의 수
        int peak = 0;    // 최근 peak(최고점)에서의 사탕 수

        // 두 번째 아이부터 순회
        for (int i = 1; i < ratings.length; i++) {
            // 현재 아이의 rating이 이전 아이보다 높은 경우
            if (ratings[i] > ratings[i - 1]) {
                upCnt++;           // 증가 카운트 증가
                peak = upCnt;      // peak 갱신
                downCnt = 0;       // 감소 카운트 초기화
                result += upCnt;   // 현재 아이에게 upCnt개의 사탕 추가
            }
            // 현재 아이의 rating이 이전 아이와 같은 경우
            else if (ratings[i] == ratings[i - 1]) {
                upCnt = 1;     // 증가 카운트 초기화
                downCnt = 0;   // 감소 카운트 초기화
                peak = 0;      // peak 초기화
                result += 1;   // 현재 아이에게 1개의 사탕 추가
            }
            // 현재 아이의 rating이 이전 아이보다 낮은 경우
            else {
                downCnt++;         // 감소 카운트 증가
                upCnt = 1;         // 증가 카운트 초기화
                result += downCnt; // 현재 아이에게 downCnt개의 사탕 추가

                // 감소 구간이 이전 peak보다 길어진 경우, 추가 사탕 필요
                if (peak <= downCnt) {
                    result += 1;
                }
            }
        }

        return result; // 총 사탕 수 반환
    }

    public static void main(String[] args) {
        // 테스트 코드
        int[] ratings = {1, 2, 3};
        System.out.println(solution(ratings)); // 예상 출력: 6

        ratings = new int[]{3, 2, 1};
        System.out.println(solution(ratings)); // 예상 출력: 6

        ratings = new int[]{1, 0, 2};
        System.out.println(solution(ratings)); // 예상 출력: 5

        ratings = new int[]{1, 2, 2};
        System.out.println(solution(ratings)); // 예상 출력: 4

        ratings = new int[]{1, 3, 5, 3, 1, 3, 5, 7, 5, 3, 1, 0};
        System.out.println(solution(ratings)); // 예상 출력: 31
    }
}

```

이 코드는 다음과 같은 규칙에 따라 아이들에게 사탕을 분배하는 알고리즘을 구현합니다:

1. 각 아이는 최소 1개의 사탕을 받아야 함.
2. 평가 점수가 이웃보다 높은 아이는 더 많은 사탕을 받아야 함.

알고리즘의 주요 특징:

1. 한 번의 순회로 문제를 해결함 (시간 복잡도 O(n)).
2. 추가 배열을 사용하지 않고 변수만으로 상태를 관리함 (공간 복잡도 O(1)).
3. 연속해서 증가하는 구간, 감소하는 구간, 그리고 peak를 추적하며 사탕 수를 계산함.

주요 변수:

- result: 총 사탕 수
- upCnt: 연속해서 증가하는 rating의 수
- downCnt: 연속해서 감소하는 rating의 수
- peak: 최근 peak에서의 사탕 수

알고리즘 동작:

1. rating이 증가하는 경우:

   - upCnt를 증가시키고, 이 값을 현재 아이의 사탕 수로 사용.
   - peak를 upCnt로 갱신 (나중에 감소 구간에서 사용).
   - downCnt 초기화.

2. rating이 같은 경우:

   - 현재 아이에게 1개의 사탕만 줌.
   - upCnt, downCnt, peak 모두 초기화.

3. rating이 감소하는 경우:
   - downCnt를 증가시키고, 이 값을 현재 아이의 사탕 수로 사용.
   - 만약 downCnt가 이전 peak 이상이 되면, 추가로 1개의 사탕을 줌 (peak에 있는 아이가 더 많은 사탕을 받도록 하기 위함).

이 알고리즘은 효율적으로 문제를 해결하며, 다양한 rating 패턴에 대해 올바른 결과를 제공합니다. 테스트 케이스들은 다양한 시나리오를 커버하여 알고리즘의 정확성을 검증합니다.
