public class Practice10 {
    public static int solution(int[] ratings) {
        // 입력 검증: ratings 배열이 null이거나 비어있으면 0 반환
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int result = 1;  // 총 사탕 수 (첫 아이에게 1개 주고 시작)
        int upCnt = 1;   // 연속해서 증가하는 rating의 수
        int downCnt = 0; // 연속해서 감소하는 rating의 수
        int peak = 0;    // 최근 peak(최고점)에서의 사탕 수

        // 두 번째 아이부터 순회
        for (int i = 1; i < ratings.length; i++) {
            // 현재 아이의 rating이 이전 아이보다 높은 경우
            if (ratings[i] > ratings[i - 1]) {
                upCnt++;           // 증가 카운트 증가
                peak = upCnt;      // peak 갱신
                downCnt = 0;       // 감소 카운트 초기화
                result += upCnt;   // 현재 아이에게 upCnt개의 사탕 추가
            } 
            // 현재 아이의 rating이 이전 아이와 같은 경우
            else if (ratings[i] == ratings[i - 1]) {
                upCnt = 1;     // 증가 카운트 초기화
                downCnt = 0;   // 감소 카운트 초기화
                peak = 0;      // peak 초기화
                result += 1;   // 현재 아이에게 1개의 사탕 추가
            } 
            // 현재 아이의 rating이 이전 아이보다 낮은 경우
            else {
                downCnt++;         // 감소 카운트 증가
                upCnt = 1;         // 증가 카운트 초기화
                result += downCnt; // 현재 아이에게 downCnt개의 사탕 추가

                // 감소 구간이 이전 peak보다 길어진 경우, 추가 사탕 필요
                if (peak <= downCnt) {
                    result += 1;
                }
            }
        }

        return result; // 총 사탕 수 반환
    }

    public static void main(String[] args) {
        // 테스트 코드
        int[] ratings = {1, 2, 3};
        System.out.println(solution(ratings)); // 예상 출력: 6

        ratings = new int[]{3, 2, 1};
        System.out.println(solution(ratings)); // 예상 출력: 6

        ratings = new int[]{1, 0, 2};
        System.out.println(solution(ratings)); // 예상 출력: 5

        ratings = new int[]{1, 2, 2};
        System.out.println(solution(ratings)); // 예상 출력: 4

        ratings = new int[]{1, 3, 5, 3, 1, 3, 5, 7, 5, 3, 1, 0};
        System.out.println(solution(ratings)); // 예상 출력: 31
    }
}