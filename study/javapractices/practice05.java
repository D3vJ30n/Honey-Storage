package study.javapractices;

/**
 * 두 개의 막대 사이에 담을 수 있는 최대 물의 양을 계산하는 프로그램
 * 투 포인터(Two Pointer) 알고리즘을 사용하여 해결
 */
public class Practice5 {
    /**
     * 주어진 높이 배열에서 최대 물 용량을 계산하는 메소드
     * @param height 각 막대의 높이가 저장된 배열
     * @return 담을 수 있는 최대 물의 양
     */
    public static int solution(int[] height) {
        // 왼쪽 포인터 초기화 (시작점)
        int left = 0;
        // 오른쪽 포인터 초기화 (끝점)
        int right = height.length - 1;
        // 최대 면적(물의 양)을 저장할 변수
        int maxArea = 0;

        // 두 포인터가 만날 때까지 반복
        while (left < right) {
            // 방법 1: 기본 연산자를 사용한 계산
            // 가로 길이 계산 (두 막대 사이의 거리)
            int x = (right - left);
            // 세로 길이 계산 (두 막대 중 더 낮은 높이)
            int y = height[left] < height[right] ? height[left] : height[right];
            // 현재 면적 계산
            int curArea = x * y;
            // 최대 면적 업데이트
            maxArea = maxArea > curArea ? maxArea : curArea;

            // 방법 2: Java 내장 함수를 사용한 계산 (주석 처리된 대체 코드)
            // curArea = (right - left) * Math.min(height[left], height[right]);
            // maxArea = Math.max(maxArea, curArea);

            // 더 낮은 높이를 가진 쪽의 포인터를 이동
            // 낮은 쪽을 이동시키는 이유: 높은 쪽을 이동시키면 면적이 항상 작아지기 때문
            if (height[left] < height[right]) {
                left++;  // 왼쪽이 더 낮으면 왼쪽 포인터를 오른쪽으로
            } else {
                right--;  // 오른쪽이 더 낮거나 같으면 오른쪽 포인터를 왼쪽으로
            }
        }

        return maxArea;  // 계산된 최대 면적 반환
    }

    /**
     * 메인 메소드: 테스트 케이스 실행
     */
    public static void main(String[] args) {
        // 테스트 케이스 1
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution(height));  // 예상 출력: 49 (8과 7 사이의 면적)

        // 테스트 케이스 2
        height = new int[]{5, 3, 9, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        System.out.println(solution(height));  // 두 번째 테스트 케이스의 결과 출력
    }
}
