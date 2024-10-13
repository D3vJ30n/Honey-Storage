// Practice7
// 2차원 배열 arr을 시계방향 90도 회전시킨 결과를 출력하는 프로그램

// 입출력 예시:
// arr:
// 1 2 3 4 5
// 6 7 8 9 10
// 11 12 13 14 15
// 결과:
// 11 6 1
// 12 7 2
// 13 8 3
// 14 9 4
// 15 10 5

public class Practice7 {
  // 2차원 배열을 출력하는 메서드
  static void printArr(int[][] arr) {
    for (int[] item1D: arr) {
      for (int item: item1D) {
        System.out.print(item + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    // 원본 2차원 배열 초기화
    int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};

    // 90도 회전된 배열을 저장할 새로운 2차원 배열 생성
    // 원본 배열의 열 수가 새 배열의 행 수가 되고, 원본 배열의 행 수가 새 배열의 열 수가 됨
    int[][] arr90 = new int[arr[0].length][arr.length];

    // 원본 배열 출력
    System.out.println("== Before ==");
    printArr(arr);

    // 배열 회전 로직
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        // 회전된 배열에서의 새로운 열 인덱스 계산
        int r = arr.length - 1 - i;
        // 원본 배열의 (i, j)가 회전된 배열의 (j, r)이 됨
        arr90[j][r] = arr[i][j];
      }
    }

    // 회전된 배열 출력
    System.out.println("== After ==");
    printArr(arr90);
  }
}