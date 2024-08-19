// Practice4
// 배열 arr에서 peak 값 모두 출력
// peak 값: 자신의 좌우 이웃보다 큰 값 (배열의 양 끝은 한쪽만 비교)

// 입출력 예시)
// arr: 3, 1, 2, 6, 2, 2, 5, 1, 9, 10, 1, 11
// 결과: 3, 6, 5, 10, 11

public class Practice4 {
  public static void main(String[] args) {
    // peak 값을 찾을 배열 초기화
    int[] arr = {3, 1, 2, 6, 2, 2, 5, 1, 9, 10, 1, 11};

    // 배열의 모든 요소를 순회
    for (int i = 0; i < arr.length; i++) {
      // 배열의 첫 번째 요소 처리 (왼쪽 이웃이 없음)
      if (i == 0 && arr[i] > arr[i + 1]) {
        System.out.print(arr[i] + " ");
      } 
      // 배열의 마지막 요소 처리 (오른쪽 이웃이 없음)
      else if (i == arr.length - 1 && arr[i] > arr[i - 1]){
        System.out.print(arr[i] + " ");
      } 
      // 배열의 중간 요소들 처리
      else {
        // 현재 요소가 양쪽 이웃보다 큰 경우 (peak)
        if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
          System.out.print(arr[i] + " ");
        }
      }
    }
    // 줄바꿈
    System.out.println();
  }
}