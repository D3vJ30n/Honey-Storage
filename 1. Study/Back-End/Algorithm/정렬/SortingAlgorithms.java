import java.util.Arrays;  // 배열을 문자열로 변환하기 위해 Arrays 클래스를 임포트합니다.

public class SortingAlgorithms {
    
    // 버블 정렬 메서드
    public static void bubbleSort(int[] arr) {
        int n = arr.length;  // 배열의 길이를 n에 저장합니다.
        for (int i = 0; i < n - 1; i++) {  // 외부 루프: n-1번 반복합니다. (마지막 요소는 자동으로 정렬됨)
            for (int j = 0; j < n - i - 1; j++) {  // 내부 루프: 처리되지 않은 요소들을 순회합니다.
                if (arr[j] > arr[j + 1]) {  // 인접한 두 요소를 비교합니다.
                    // 순서가 잘못되었다면 두 요소를 교환합니다.
                    int temp = arr[j];  // 임시 변수에 첫 번째 요소를 저장합니다.
                    arr[j] = arr[j + 1];  // 두 번째 요소를 첫 번째 위치로 이동합니다.
                    arr[j + 1] = temp;  // 임시 변수의 값(원래 첫 번째 요소)을 두 번째 위치에 저장합니다.
                }
            }
        }
    }
    
    // 선택 정렬 메서드
    public static void selectionSort(int[] arr) {
        int n = arr.length;  // 배열의 길이를 n에 저장합니다.
        for (int i = 0; i < n - 1; i++) {  // 외부 루프: n-1번 반복합니다. (마지막 요소는 자동으로 정렬됨)
            int minIdx = i;  // 현재 인덱스를 최소값의 인덱스로 초기화합니다.
            for (int j = i + 1; j < n; j++) {  // 내부 루프: i 다음 위치부터 끝까지 순회합니다.
                if (arr[j] < arr[minIdx]) {  // 현재 최소값보다 작은 값을 찾으면
                    minIdx = j;  // 최소값의 인덱스를 업데이트합니다.
                }
            }
            // 찾은 최소값을 현재 위치(i)와 교환합니다.
            int temp = arr[minIdx];  // 최소값을 임시 변수에 저장합니다.
            arr[minIdx] = arr[i];  // 현재 위치의 값을 최소값 위치로 이동합니다.
            arr[i] = temp;  // 최소값을 현재 위치에 저장합니다.
        }
    }
    
    // 삽입 정렬 메서드
    public static void insertionSort(int[] arr) {
        int n = arr.length;  // 배열의 길이를 n에 저장합니다.
        for (int i = 1; i < n; ++i) {  // 두 번째 요소부터 시작하여 끝까지 반복합니다.
            int key = arr[i];  // 현재 삽입할 요소를 key로 저장합니다.
            int j = i - 1;  // key 이전의 인덱스부터 시작합니다.
            
            // key보다 큰 요소들을 오른쪽으로 이동시킵니다.
            while (j >= 0 && arr[j] > key) {  // 첫 요소까지 반복하며, key보다 큰 요소를 찾습니다.
                arr[j + 1] = arr[j];  // 큰 요소를 오른쪽으로 이동시킵니다.
                j = j - 1;  // 왼쪽으로 이동하여 다음 요소를 검사합니다.
            }
            arr[j + 1] = key;  // 적절한 위치에 key를 삽입합니다.
        }
    }
    
    public static void main(String[] args) {
        // 테스트할 배열을 생성합니다.
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("원본 배열: " + Arrays.toString(arr));  // 원본 배열을 출력합니다.
        
        // 버블 정렬 테스트
        int[] bubbleArr = arr.clone();  // 원본 배열을 복사합니다.
        bubbleSort(bubbleArr);  // 버블 정렬을 수행합니다.
        System.out.println("버블 정렬 결과: " + Arrays.toString(bubbleArr));  // 정렬된 배열을 출력합니다.
        
        // 선택 정렬 테스트
        int[] selectionArr = arr.clone();  // 원본 배열을 복사합니다.
        selectionSort(selectionArr);  // 선택 정렬을 수행합니다.
        System.out.println("선택 정렬 결과: " + Arrays.toString(selectionArr));  // 정렬된 배열을 출력합니다.
        
        // 삽입 정렬 테스트
        int[] insertionArr = arr.clone();  // 원본 배열을 복사합니다.
        insertionSort(insertionArr);  // 삽입 정렬을 수행합니다.
        System.out.println("삽입 정렬 결과: " + Arrays.toString(insertionArr));  // 정렬된 배열을 출력합니다.
    }
}