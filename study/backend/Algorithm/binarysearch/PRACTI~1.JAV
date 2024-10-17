// study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards06.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards08.src.study.backend.javapractice.solution.lineards09.src.study.backend.javapractice.solution.lineards10.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards142.src.Practice1
// 이진 탐색 추가 구현
// target 값이 arr 내에 있으면 해당 인덱스 반환
// 없으면 해당 값이 있을 경우의 위치에 -1을 곱하고 1을 뺀 값을 반환

// 입출력 예시
// 입력 arr: 1, 2, 5, 10, 20, 30, 40, 50, 60

// target: 30
// 출력: 5

// target: 3
// 출력: -3
public class study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards06.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards08.src.study.backend.javapractice.solution.lineards09.src.study.backend.javapractice.solution.lineards10.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards142.src.Practice1 {
    public static int solution(int[] arr, int target) {
        // 배열이 null이거나 비어있으면 -1 반환
        if (arr == null || arr.length == 0) {
            return -1;
        }
        
        // 이진 탐색을 위한 left, right 포인터 초기화
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            // 중간 인덱스 계산
            int mid = (left + right) / 2;
            
            // 오버플로우 방지를 위한 대안적인 중간 인덱스 계산 방법
            // int mid = left + (right - left) / 2;
            
            // 오버플로우 예시
            // int a = Integer.MAX_VALUE;
            // int b = Integer.MAX_VALUE - 10;
            // int midAB = (a + b) / 2;  // 이 방식은 오버플로우 발생 가능
            // int midAB2 = a + (b - a) / 2;  // 이 방식은 오버플로우 방지
            
            if (target == arr[mid]) {  // 타겟 값을 찾은 경우
                return mid;  // 해당 인덱스 반환
            } else if (target < arr[mid]) {  // 타겟이 중간값보다 작은 경우
                right = mid - 1;  // 왼쪽 반을 탐색
            } else {  // 타겟이 중간값보다 큰 경우
                left = mid + 1;  // 오른쪽 반을 탐색
            }
        }
        
        // 타겟을 찾지 못한 경우, 타겟이 들어갈 위치에 -1을 곱하고 1을 뺀 값 반환
        return -left - 1;
    }
    
    public static void main(String[] args) {
        // 테스트 코드
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};
        System.out.println(solution(arr, 30));  // 5 출력 (30은 인덱스 5에 위치)
        System.out.println(solution(arr, 3));   // -3 출력 (3은 없지만, 인덱스 2에 위치해야 함)
        System.out.println(solution(arr, 11));  // -5 출력 (11은 없지만, 인덱스 4에 위치해야 함)
        System.out.println(solution(arr, 35));  // -7 출력 (35는 없지만, 인덱스 6에 위치해야 함)
    }
}