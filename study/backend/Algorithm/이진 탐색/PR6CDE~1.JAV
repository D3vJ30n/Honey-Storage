// Practice5
// 정수형 배열 nums 와 정수 m 이 주어졌다.
// nums 에는 양의 정수 값들이 들어 있고, m 은 배열을 부분 배열로 분리할 수 있는 수이다.
// nums 배열을 m 개의 부분 배열로 분리할 때,
// 각 부분 배열의 합중 가장 큰 값이 최소가 되도록 분리했을 때의 합을 출력하세요.

// 입출력 예시
// nums: 7, 2, 5, 10, 8
// m: 2
// 출력: 18

// nums: 1, 2, 3, 4, 5
// m: 2
// 출력: 9

public class Practice5 {
    public static int solution(int[] nums, int m) {
        int left = 0;
        int right = 0;
        
        // left: 배열 내 가장 큰 수 (최소 가능한 최대 합)
        // right: 모든 수의 총합 (최대 가능한 최대 합)
        for (int num : nums) {
            left = Math.max(num, left);
            right += num;
        }
        
        // m이 1이면 분할할 필요가 없으므로 총합 반환
        if (m == 1) {
            return right;
        }
        
        // 이진 탐색 시작
        while (left <= right) {
            int mid = (left + right) / 2;  // 현재 검사할 최대 합
            int cnt = 1;  // 현재 분할 횟수
            int total = 0;  // 현재 부분 배열의 합
            
            // 배열을 순회하며 현재 최대 합(mid)으로 분할 가능한지 확인
            for (int num : nums) {
                total += num;
                if (total > mid) {  // 현재 합이 mid를 초과하면 분할
                    total = num;  // 새로운 부분 배열 시작
                    cnt++;  // 분할 횟수 증가
                }
            }
            
            // 분할 횟수가 m 이하면 최대 합을 줄여볼 수 있음
            if (cnt <= m) {
                right = mid - 1;
            } 
            // 분할 횟수가 m보다 크면 최대 합을 늘려야 함
            else {
                left = mid + 1;
            }
        }
        
        // 최종적으로 가능한 최소 최대 합 반환
        return left;
    }
    
    public static void main(String[] args) {
        // 테스트 코드
        int[] nums = {7, 2, 5, 10, 8};
        System.out.println(solution(nums, 2));  // 18 출력
        
        nums = new int[] {1, 2, 3, 4, 5};
        System.out.println(solution(nums, 2));  // 9 출력
        
        nums = new int[] {1, 4, 4};
        System.out.println(solution(nums, 3));  // 4 출력
    }
}