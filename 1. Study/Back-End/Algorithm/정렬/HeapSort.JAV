import java.util.Arrays;

public class HeapSort {
    
    // 힙 정렬의 메인 함수
    public static void heapSort(int[] arr) {
        int n = arr.length;
        
        // 최대 힙(Max Heap) 구성
        // 마지막 비단말 노드부터 시작하여 루트까지 heapify 수행
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        // 힙에서 요소를 하나씩 꺼내어 배열의 뒤쪽부터 저장
        for (int i = n - 1; i > 0; i--) {
            // 현재 힙의 루트(최대값)를 배열의 마지막 요소와 교환
            swap(arr, 0, i);
            
            // 루트 노드에 대해 heapify를 수행하여 최대 힙 속성 유지
            heapify(arr, i, 0);
        }
    }
    
    // 주어진 루트 노드에 대해 힙 속성을 유지하도록 재구성하는 함수
    public static void heapify(int[] arr, int heapSize, int rootIndex) {
        int largest = rootIndex;  // 최대값을 루트로 초기화
        int leftChild = 2 * rootIndex + 1;  // 왼쪽 자식 노드 인덱스
        int rightChild = 2 * rootIndex + 2; // 오른쪽 자식 노드 인덱스
        
        // 왼쪽 자식이 루트보다 크면 largest 갱신
        if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        
        // 오른쪽 자식이 현재 largest보다 크면 largest 갱신
        if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }
        
        // largest가 루트가 아니라면 swap 후 재귀적으로 heapify 호출
        if (largest != rootIndex) {
            swap(arr, rootIndex, largest);
            heapify(arr, heapSize, largest);
        }
    }
    
    // 배열의 두 요소를 교환하는 함수
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        // 테스트 코드
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        System.out.println("정렬 전: " + Arrays.toString(arr));
        
        heapSort(arr);
        
        System.out.println("힙 정렬 후: " + Arrays.toString(arr));
    }
}