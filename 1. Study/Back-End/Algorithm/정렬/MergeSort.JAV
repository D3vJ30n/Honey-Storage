import java.util.Arrays;

public class MergeSort {
    
    // 합병 정렬의 메인 함수
    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left < right) {
            // 배열의 중간 지점을 계산
            int mid = (left + right) / 2;
            
            // 왼쪽 절반에 대해 재귀적으로 정렬
            mergeSort(arr, tmp, left, mid);
            
            // 오른쪽 절반에 대해 재귀적으로 정렬
            mergeSort(arr, tmp, mid + 1, right);
            
            // 정렬된 두 절반을 합병
            merge(arr, tmp, left, right, mid);
        }
    }
    
    // 두 정렬된 부분 배열을 합병하는 함수
    public static void merge(int[] arr, int[] tmp, int left, int right, int mid) {
        int p = left;      // 왼쪽 부분 배열의 시작 인덱스
        int q = mid + 1;   // 오른쪽 부분 배열의 시작 인덱스
        int idx = p;       // 임시 배열에 저장할 위치의 인덱스
        
        // 왼쪽 또는 오른쪽 부분 배열 중 하나라도 원소가 남아있는 동안 반복
        while (p <= mid || q <= right) {
            if (p <= mid && q <= right) {   // 양쪽 부분 배열 모두에 원소가 남아있는 경우
                if (arr[p] <= arr[q]) {     // 왼쪽 원소가 오른쪽 원소보다 작거나 같은 경우
                    tmp[idx++] = arr[p++];  // 왼쪽 원소를 임시 배열에 저장하고 인덱스 증가
                } else {
                    tmp[idx++] = arr[q++];  // 오른쪽 원소를 임시 배열에 저장하고 인덱스 증가
                }
            } else if (p <= mid && q > right) { // 왼쪽 부분 배열에만 원소가 남아있는 경우
                tmp[idx++] = arr[p++];          // 남은 왼쪽 원소들을 임시 배열에 복사
            } else {                            // 오른쪽 부분 배열에만 원소가 남아있는 경우
                tmp[idx++] = arr[q++];          // 남은 오른쪽 원소들을 임시 배열에 복사
            }
        }
        
        // 임시 배열에 정렬된 결과를 원래 배열로 복사
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }
    
    public static void main(String[] args) {
        // 테스트 코드
        int[] arr = {3, 5, 2, 7, 1, 4, 6};  // 정렬할 배열
        int[] tmp = new int[arr.length];    // 합병 과정에서 사용할 임시 배열
        mergeSort(arr, tmp, 0, arr.length - 1);  // 합병 정렬 수행
        System.out.println("합병 정렬: " + Arrays.toString(arr));  // 정렬된 결과 출력
    }
}