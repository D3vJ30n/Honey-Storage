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
        // 향상된 for 루프를 사용하여 2차원 배열의 각 행(1차원 배열)에 접근
        for (int[] item1D: arr) {
            // 각 행의 모든 원소를 순회
            for (int item: item1D) {
                // 각 원소를 공백과 함께 출력 (줄바꿈 없음)
                System.out.print(item + " ");
            }
            // 한 행의 모든 원소를 출력한 후 줄바꿈
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 원본 2차원 배열 초기화
        // 3행 5열의 2차원 배열 생성
        int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};

        // 90도 회전된 배열을 저장할 새로운 2차원 배열 생성
        // 원본 배열의 열 수가 새 배열의 행 수가 되고, 원본 배열의 행 수가 새 배열의 열 수가 됨
        // 즉, 3x5 배열이 5x3 배열로 변환됨
        int[][] arr90 = new int[arr[0].length][arr.length];

        // 원본 배열 출력
        System.out.println("== Before ==");
        printArr(arr);

// 외부 for 루프
for (int i = 0; i < arr.length; i++) {
    // i는 원본 배열 arr의 행 인덱스
    // arr.length는 원본 배열의 행 수 (예: 3)
    // 이 루프는 0부터 2까지 반복 (arr.length - 1)

    // 내부 for 루프
    for (int j = 0; j < arr[i].length; j++) {
        // j는 원본 배열 arr의 열 인덱스
        // arr[i].length는 현재 행의 열 수 (예: 5)
        // 이 루프는 0부터 4까지 반복 (arr[i].length - 1)

        // 회전된 배열에서의 새로운 열 인덱스 계산
        int r = arr.length - 1 - i;
        // r은 회전된 배열 arr90에서의 새로운 열 인덱스
        // arr.length - 1은 원본 배열의 마지막 행 인덱스 (예: 2)
        // i를 빼는 이유는 행 순서를 뒤집기 위함
        // 예: i=0일 때 r=2, i=1일 때 r=1, i=2일 때 r=0

        // 원본 배열의 (i, j)가 회전된 배열의 (j, r)이 됨
        arr90[j][r] = arr[i][j];
        // arr[i][j]는 원본 배열의 현재 요소
        // arr90[j][r]은 회전된 배열에서의 새 위치
        // j가 새 배열의 행 인덱스가 되고, r이 열 인덱스가 됨
    }
}

        // 회전된 배열 출력
        System.out.println("== After ==");
        printArr(arr90);
    }
}