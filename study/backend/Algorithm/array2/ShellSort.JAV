import java.util.Arrays;

public class ShellSort {

    public static void shellSort(int[] arr) {
        int n = arr.length;
        
        // 초기 간격(gap)을 배열 길이의 절반으로 설정
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 각 간격별로 삽입 정렬 수행
            for (int i = gap; i < n; i++) {
                // 현재 요소를 임시 변수에 저장
                int temp = arr[i];
                int j;

                // gap 간격으로 떨어진 요소들을 비교하며 삽입 정렬 수행
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                // 적절한 위치에 현재 요소 삽입
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        System.out.println("정렬 전: " + Arrays.toString(arr));

        shellSort(arr);

        System.out.println("셸 정렬 후: " + Arrays.toString(arr));
    }
}