// Practice5
// 배열 arr의 값을 오름차순으로 출력하는 프로그램

// 입출력 예시)
// arr: 5, 3, 1, 4, 6, 1
// 결과: 1, 1, 3, 4, 5, 6

public class Practice5 {
  public static void main(String[] args) {
    // 정렬할 배열 선언 및 초기화
    int[] arr = {5, 3, 1, 4, 6, 1}; // -> 1, 1, 3, 4, 5, 6
    
    // 방문 여부를 체크할 배열 선언 (0: 미방문, 1: 방문)
    int[] visited = new int[arr.length];
    
    // 방문한 요소의 개수를 카운트
    int visitCnt = 0;
    
    // 현재까지 찾은 최소값을 저장 (초기값: 정수의 최대값)
    int minVal = Integer.MAX_VALUE;
    
    // 현재까지 찾은 최소값의 인덱스를 저장
    int minIdx = -1;

    // 모든 요소를 방문할 때까지 반복
    while (visitCnt < arr.length) {
      // 배열의 모든 요소를 순회하며 최소값 찾기
      for (int i = 0; i < arr.length; i++) {
        // 현재 요소가 지금까지의 최소값보다 작고 아직 방문하지 않았다면
        if (arr[i] < minVal && visited[i] == 0) {
          // 최소값과 그 인덱스 갱신
          minVal = arr[i];
          minIdx = i;
        }
      }

      // 유효한 최소값을 찾았다면
      if (minIdx != -1) {
        // 찾은 최소값 출력
        System.out.print(minVal + " ");
        // 해당 요소를 방문했다고 표시
        visited[minIdx] = 1;
        // 방문한 요소 개수 증가
        visitCnt++;
      }

      // 다음 반복을 위해 최소값과 인덱스 초기화
      minVal = Integer.MAX_VALUE;
      minIdx = -1;
    }
    
    // 줄바꿈
    System.out.println();
  }
}