// Practice3
// 배열 arr의 데이터 순서를 거꾸로 변경하세요.
// 추가 배열을 사용하지 않고 구현

// 입출력 예시)
// arr: 1, 3, 5, 7, 9
// 결과: 9, 7, 5, 3, 1

import java.util.Arrays;

public class Practice3 {
  public static void main(String[] args) {
    // 뒤집을 배열 초기화
    int[] arr = {1, 3, 5, 7, 9};

    // 배열의 앞쪽 절반만 순회 (중간 요소는 자동으로 제자리에 남음)
    for (int i = 0; i < arr.length / 2; i++) {
      // 현재 요소를 임시 변수에 저장
      int tmp = arr[i];
      
      // 현재 요소에 대응되는 뒤쪽 요소를 현재 위치로 이동
      arr[i] = arr[arr.length - 1 - i];
      
      // 임시 저장한 원래 요소를 대응되는 뒤쪽 위치로 이동
      arr[arr.length - 1 - i] = tmp;
    }

    // 뒤집힌 배열 출력
    System.out.println(Arrays.toString(arr));
  }
}