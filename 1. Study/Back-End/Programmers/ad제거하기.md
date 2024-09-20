# 프로그래머스 ad제거하기 문제 해석 및 해결 과정

## 1. 문제 해석

- 입력: 문자열 배열 `strArr`
- 목표: "ad"를 포함하지 않는 문자열만 남기고, 순서를 유지하여 새 배열 반환
- 제한사항
  - 배열 길이: 1 ≤ `strArr`의 길이 ≤ 1,000
  - 문자열 길이: 1 ≤ `strArr`의 원소의 길이 ≤ 20
  - 문자열 구성: 알파벳 소문자만 사용

## 2. 접근 방법 구상

1. 입력 배열의 각 문자열을 순회.
2. 각 문자열에 "ad"가 포함되어 있는지 확인.
3. "ad"가 없는 문자열만 새로운 구조에 저장.
4. 저장된 문자열들을 배열로 변환하여 반환.

## 3. 자료구조 선택

- 결과를 저장할 구조로 `ArrayList`를 선택한다.
  - 이유: 최종 배열의 크기를 미리 알 수 없으므로, 동적으로 크기가 조절되는 자료구조가 필요하다.

## 4. 알고리즘 설계

1. `ArrayList<String>` 타입의 `result` 생성
2. `strArr`의 각 문자열에 대해:
   - `contains("ad")`로 "ad" 포함 여부 확인
   - "ad"가 없으면 `result`에 추가
3. `result`를 배열로 변환하여 반환

## 5. 코드 구현

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
public String[] solution(String[] strArr) {
// ArrayList를 사용하여 결과를 저장할 동적 리스트 생성
// ArrayList는 크기가 가변적이어서 요소를 쉽게 추가하거나 제거할 수 있음
List<String> result = new ArrayList<>();

        // 입력받은 문자열 배열의 각 요소를 순회
        for (String str : strArr) {
            // 현재 문자열이 "ad"를 포함하지 않는지 확인
            // contains() 메소드는 문자열에 특정 부분 문자열이 포함되어 있으면 true를 반환
            // '!'를 사용하여 이 조건을 뒤집어, "ad"를 포함하지 않을 때 true가 되도록 함
            if (!str.contains("ad")) {
                // "ad"를 포함하지 않는 문자열만 결과 리스트에 추가
                result.add(str);
            }
        }

        // ArrayList를 일반 배열로 변환하여 반환
        // toArray() 메소드를 사용하여 List를 배열로 변환
        // new String[0]을 인자로 전달하면 Java가 자동으로 적절한 크기의 배열을 생성
        // 이 방법은 리스트의 크기에 맞는 정확한 크기의 배열을 생성하므로 메모리 효율적
        return result.toArray(new String[0]);
    }

}
```

## 6. 코드 설명

- `ArrayList<String> result`: 필터링된 문자열을 저장할 동적 리스트
- `for (String str : strArr)`: 입력 배열의 각 문자열을 순회

기본 의미

: 기호는 "in"이라고 읽을 수 있다.
이 구문은 "strArr에 있는 각각의 String 요소에 대해"라고 해석할 수 있다.

구문 구조

for (요소의*타입 변수명 : 반복할*컬렉션*또는*배열) { ... }

작동 방식

이 루프는 strArr 배열의 각 요소를 순서대로 str 변수에 할당하면서 반복한다.
배열의 첫 번째 요소부터 마지막 요소까지 자동으로 순회한다.

```java
  // 향상된 for 루프
  for (String str : strArr) {
  // str을 사용한 코드
  }

// 같은 동작을 하는 일반 for 루프
for (int i = 0; i < strArr.length; i++) {
String str = strArr[i];
// str을 사용한 코드
}
```

- `if (!str.contains("ad"))`: "ad"를 포함하지 않는 문자열 확인
- `result.add(str)`: 조건을 만족하는 문자열을 리스트에 추가
- `return result.toArray(new String[0])`: 리스트를 배열로 변환하여 반환

## 7. 시간 복잡도 분석

- O(n), 여기서 n은 `strArr`의 길이
- 각 문자열을 한 번씩만 검사하므로 선형 시간 복잡도

## 8. 공간 복잡도 분석

- 최악의 경우 O(n), 모든 문자열이 "ad"를 포함하지 않을 때
- 평균적으로는 O(n)보다 작음, "ad"를 포함한 문자열이 제거되므로

## 9. 추가 고려사항

- 대소문자 구분: 현재 구현은 "ad"만 정확히 찾음. "AD", "Ad" 등은 걸러내지 않음
- 성능 최적화: 매우 큰 입력에 대해서는 병렬 처리 등을 고려할 수 있음
- 예외 처리: 입력이 null이거나 비어있는 경우에 대한 처리 추가 가능
