import java.io.*;
import java.util.*;

public class Heap {
    // 전역 변수 선언
    static int[] A;          // 정렬할 배열
    static int N, K;         // N: 배열의 크기, K: 목표 교환 횟수
    static int exchangeCount = 0;  // 현재까지의 교환 횟수
    static boolean found = false;  // K번째 교환을 찾았는지 여부

    public static void main(String[] args) throws IOException {
        // 입력을 효율적으로 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N과 K 입력 받기
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // 배열 A 초기화 (1-based indexing 사용)
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // 힙 정렬 실행
        heapSort();
        
        // K번째 교환을 찾지 못한 경우 -1 출력
        if (!found) {
            System.out.println(-1);
        }
    }
    
    // 힙 정렬 메소드
    static void heapSort() {
        // 초기 최소 힙 구성
        buildMinHeap();
        // 힙에서 원소를 하나씩 꺼내어 배열의 뒤쪽부터 채우기
        for (int i = N; i >= 2; i--) {
            exchange(1, i);  // 루트와 마지막 원소 교환
            if (found) return;  // K번째 교환을 찾았다면 종료
            heapify(1, i - 1);  // 힙 속성 유지
        }
    }
    
    // 초기 최소 힙을 구성하는 메소드
    static void buildMinHeap() {
        // 마지막 비단말 노드부터 루트까지 heapify 수행
        for (int i = N / 2; i >= 1; i--) {
            heapify(i, N);
        }
    }
    
    // 주어진 노드를 루트로 하는 서브트리를 최소 힙 성질을 만족하도록 수정하는 메소드
    static void heapify(int k, int n) {
        int left = 2 * k;    // 왼쪽 자식 노드 인덱스
        int right = 2 * k + 1;  // 오른쪽 자식 노드 인덱스
        int smaller;  // 더 작은 값을 가진 자식 노드의 인덱스
        
        // 자식 노드 중 더 작은 값을 찾음
        if (right <= n) {  // 오른쪽 자식이 존재하는 경우
            if (A[left] < A[right]) smaller = left;
            else smaller = right;
        } else if (left <= n) {  // 왼쪽 자식만 존재하는 경우
            smaller = left;
        } else {  // 자식 노드가 없는 경우
            return;
        }
        
        // 현재 노드가 자식 노드보다 크다면 교환하고 재귀적으로 heapify 수행
        if (A[smaller] < A[k]) {
            exchange(k, smaller);
            if (found) return;  // K번째 교환을 찾았다면 종료
            heapify(smaller, n);
        }
    }
    
    // 두 원소를 교환하는 메소드
    static void exchange(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        exchangeCount++;  // 교환 횟수 증가
        
        // K번째 교환인 경우 배열 출력 및 found 플래그 설정
        if (exchangeCount == K) {
            printArray();
            found = true;
        }
    }
    
    // 현재 배열 상태를 출력하는 메소드
    static void printArray() {
        for (int i = 1; i <= N; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }
}