// Practice
// 원형 정렬 상태 배열에서의 이진 탐색
// nums 배열에 원형 상태로 데이터가 정렬되어 있을 때,
// 이진 탐색으로 데이터를 찾는 프로그램을 작성하세요.
// O(log n) 유지
// 배열을 재 정렬하지 않고 풀기

// 입출력 예시
// arr: 4, 5, 6, 7, 8, 0, 1, 2

// target: 0
// 출력: 5

// target: 3
// 출력: -1

public class Practice2 {
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
            
            // 타겟 값을 찾은 경우 해당 인덱스 반환
            if (target == arr[mid]) {
                return mid;
            }
            
            // O(logN) 시간 복잡도로 해결해야 하므로 기존의 이진 탐색과 유사한 구조 사용
            
            // 왼쪽 절반이 정렬되어 있는 경우
            if (arr[left] <= arr[mid]) {
                // 타겟이 왼쪽 절반에 있는 경우
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;  // 왼쪽 절반을 탐색
                } else {
                    left = mid + 1;   // 오른쪽 절반을 탐색
                }
            } 
            // 오른쪽 절반이 정렬되어 있는 경우
            else {
                // 타겟이 오른쪽 절반에 있는 경우
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;   // 오른쪽 절반을 탐색
                } else {
                    right = mid - 1;  // 왼쪽 절반을 탐색
                }
            }
        }
        
        // 타겟을 찾지 못한 경우 -1 반환
        return -1;
    }
    
    public static void main(String[] args) {
        // 테스트 코드
        int[] nums = {4, 5, 6, 7, 8, 0, 1, 2};
        System.out.println(solution(nums, 0));  // 5 출력 (0은 인덱스 5에 위치)
        System.out.println(solution(nums, 3));  // -1 출력 (3은 배열에 없음)
    }
}
