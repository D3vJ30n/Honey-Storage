# Practice5

## 문제 설명

n개의 데이터가 height 배열에 주어졌다.  
height 배열의 각각의 원소는 아래 그림과 같이 각 벽에 대한 높이를 의미한다.

이와 같이 높이 값들이 주어졌을 때,  
이 중에서 어떤 두 벽을 고르면 가장 많은 물을 담을 수 있는지를 확인하고  
그 때의 면적을 출력하세요.

![img_1.png](../imgs/img_1.png)

## 입출력 예시

| 입력                                     | 출력 |
| ---------------------------------------- | ---- |
| 1, 8, 6, 2, 5, 4, 8, 3, 7                | 49   |
| 5, 3, 9, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2 | 26   |

배열에서 `-1`이나 `+1`이 자주 등장하는 것은 배열의 인덱스 특성과 관련이 있습니다. 자세히 설명해드리겠습니다:

1. `int right = height.length - 1`에서 `-1`이 사용되는 이유:

   - 배열의 인덱스는 0부터 시작합니다
   - 배열의 길이가 n이면, 마지막 인덱스는 n-1입니다
   - 예시:
     ```java
     int[] arr = {1, 2, 3, 4, 5};  // 길이: 5
     // 인덱스:    0  1  2  3  4   // 마지막 인덱스: 4 (길이-1)
     ```
   - 따라서 마지막 요소에 접근하려면 `length-1`을 사용해야 합니다

2. 반복문에서 `+1`이 자주 사용되는 이유:

   - 길이나 개수를 계산할 때는 인덱스에 1을 더해야 함
   - 예시:
     ```java
     // 인덱스 3부터 7까지의 요소 개수
     int count = 7 - 3 + 1;  // 5개 요소
     // 인덱스: 3, 4, 5, 6, 7
     ```

3. 일반적인 사용 패턴:

   ```java
   // 배열의 처음부터 끝까지 순회
   for(int i = 0; i < arr.length; i++) {...}  // i는 0부터 length-1까지

   // 특정 범위의 요소 개수 계산
   int elements = endIndex - startIndex + 1;

   // 배열의 마지막 요소 접근
   int lastElement = arr[arr.length - 1];
   ```

4. 자주 발생하는 실수:

   ```java
   int[] arr = new int[5];

   // 잘못된 접근
   arr[arr.length];    // ArrayIndexOutOfBoundsException

   // 올바른 접근
   arr[arr.length-1];  // 마지막 요소
   ```

이러한 `+1`, `-1` 연산은 다음과 같은 상황에서 자주 사용됩니다:

1. 배열의 마지막 인덱스 접근
2. 범위 계산
3. 길이나 개수 계산
4. 인덱스 조정

이해를 돕기 위한 실제 예시를 보여드리겠습니다:

```java
/**
 * 배열의 인덱스 처리와 관련된 다양한 예시
 */
public class ArrayIndexExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};  // 길이: 5

        // 1. 마지막 요소 접근
        int lastElement = numbers[numbers.length - 1];  // 5
        System.out.println("마지막 요소: " + lastElement);

        // 2. 범위 내의 요소 개수 계산
        int startIdx = 1;
        int endIdx = 3;
        int elementCount = endIdx - startIdx + 1;  // 1부터 3까지: 3개
        System.out.println("요소 개수: " + elementCount);

        // 3. 배열의 중간 지점 찾기
        int midPoint = (numbers.length - 1) / 2;  // 인덱스 2
        System.out.println("중간 지점: " + midPoint);

        // 4. 양쪽에서 접근하는 투 포인터 예제
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            System.out.printf("left: %d, right: %d%n", numbers[left], numbers[right]);
            left++;
            right--;
        }

        // 5. 순환 인덱스 (circular index) 계산
        int currentIdx = 4;
        int nextIdx = (currentIdx + 1) % numbers.length;  // 4 -> 0
        System.out.println("다음 인덱스: " + nextIdx);
    }
}

```

이 코드는 다양한 상황에서 `-1`과 `+1`이 사용되는 경우를 보여줍니다:

1. 마지막 요소 접근 시 `length-1` 사용
2. 범위 계산 시 `+1` 사용
3. 중간 지점 계산 시 `length-1` 사용
4. 투 포인터 알고리즘에서의 인덱스 조정
5. 순환 인덱스 계산

이러한 패턴을 이해하고 있으면 배열 처리 시 발생할 수 있는 많은 실수를 방지할 수 있습니다.
