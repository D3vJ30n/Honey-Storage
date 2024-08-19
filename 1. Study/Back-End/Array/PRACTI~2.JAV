// Practice2
// 배열 arr에서 target에 해당하는 값의 인덱스를 출력
// 해당 값이 여러 개인 경우 가장 큰 인덱스 출력

// 입출력 예시)
// 배열 arr: 1, 1, 100, 1, 1, 1, 100
// 결과: 6

public class Practice2 {
  public static void main(String[] args) {
    // 검색할 배열 초기화
    int[] arr = {1, 1, 100, 1, 1, 1, 100};
    
    // 찾고자 하는 대상 값 설정
    int target = 100;
    
    // 가장 큰 인덱스를 저장할 변수 초기화 (-1은 아직 찾지 못했음을 의미)
    int idxMax = -1;

    // 배열의 모든 요소를 순회
    for (int i = 0; i < arr.length; i++) {
      // 현재 요소가 target과 일치하는 경우
      if (arr[i] == target) {
        // 현재 인덱스가 지금까지 찾은 가장 큰 인덱스보다 크다면 갱신
        if (i > idxMax) {
          idxMax = i;
        }
      }
    }

    // target을 찾은 경우 (idxMax가 갱신되었다면)
    if (idxMax >= 0) {
      // 가장 큰 인덱스 출력
      System.out.println(idxMax);
    }
  }
}