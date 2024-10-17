import java.util.Arrays;

public class QuickSort {

    // 퀵 정렬의 메인 함수
    public static void quickSort(int[] arr, int left, int right) {
        // 베이스 케이스: left가 right보다 크거나 같으면 정렬할 부분이 없음
        if (left >= right) {
            return;
        }
        
        // 파티션을 수행하고 피벗의 최종 위치를 얻음
        int pivot = partition(arr, left, right);
        
        // 피벗을 기준으로 왼쪽 부분 배열을 재귀적으로 정렬
        quickSort(arr, left, pivot - 1);
        // 피벗을 기준으로 오른쪽 부분 배열을 재귀적으로 정렬
        quickSort(arr, pivot + 1, right);
    }
    
    // 배열을 분할하고 피벗의 최종 위치를 반환하는 함수
    public static int partition(int[] arr, int left, int right) {
        // 가장 왼쪽 요소를 피벗으로 선택
        // 다른 피벗 선택 방법: 중간 요소 선택, 랜덤 선택, 또는 처음, 중간, 마지막 요소의 중앙값 사용
        int pivot = arr[left];
        int i = left;
        int j = right;
        
        while (i < j) {
            // 오른쪽에서 왼쪽으로 피벗보다 작거나 같은 요소를 찾음
            while (arr[j] > pivot && i < j) {
                j--;
            }
            
            // 왼쪽에서 오른쪽으로 피벗보다 큰 요소를 찾음
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            
            // 찾은 두 요소를 교환
            swap(arr, i, j);
        }
        
        // 피벗을 올바른 위치로 이동
        swap(arr, left, i);
        
        // 피벗의 최종 위치 반환
        return i;
    }
    
    // 배열의 두 요소를 교환하는 함수
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 9, 4, 5, 8};
        System.out.println("정렬 전: " + Arrays.toString(arr));
        
        quickSort(arr, 0, arr.length - 1);
        
        System.out.println("퀵 정렬 후: " + Arrays.toString(arr));
    }
}