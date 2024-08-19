// Practice6
// 배열 arr에서 중복 값을 제거한 새 배열을 만드시오.

// 입출력 예시)
// arr: 1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5
// 결과: 1, 5, 3, 2, 4

public class Practice6 {
  public static void main(String[] args) {
    // 원본 배열 초기화
    int[] arr = {1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5};
    
    // 중복이 제거된 결과를 저장할 새 배열 생성 (최대 크기는 원본 배열의 크기)
    int[] arrResult = new int[arr.length];
    
    // 새 배열에 저장된 고유한 요소의 개수를 추적하는 변수
    int cnt = 0;

    // 원본 배열의 모든 요소를 순회
    for (int i = 0; i < arr.length; i++) {
      // 현재 요소의 중복 여부를 나타내는 플래그
      boolean dupFlag = false;
      
      // 결과 배열의 현재까지 저장된 요소들과 비교
      for (int j = 0; j < cnt; j++) {
        // 중복된 요소를 발견하면 플래그를 true로 설정
        if (arr[i] == arrResult[j]) {
          dupFlag = true;
        }
      }

      // 중복되지 않은 요소라면 결과 배열에 추가
      if (dupFlag == false) {
        arrResult[cnt++] = arr[i];
      }
    }

    // 중복이 제거된 배열의 요소들을 출력
    for (int i = 0; i < cnt; i++) {
      System.out.print(arrResult[i] + " ");
    }
    // 줄바꿈
    System.out.println();
  }
}