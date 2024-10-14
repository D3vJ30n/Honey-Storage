// Practice1
// 배열 arr의 모든 데이터에 대해서,
// 짝수 데이터들의 평균과 홀수 데이터들의 평균을 출력하는 프로그램

// 입출력 예시)
// 배열 arr: 1, 2, 3, 4, 5, 6, 7, 8, 9
// 결과:
// 짝수 평균: 5.0
// 홀수 평균: 5.0

public class Practice1 {
    public static void main(String[] args) {
        // 계산할 정수 배열 초기화
        // 1부터 9까지의 연속된 정수를 포함하는 배열 생성
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        // 짝수의 합과 홀수의 합을 저장할 변수 (float 타입 사용)
        // float 타입을 사용하여 평균 계산 시 소수점 결과를 얻을 수 있음
        float sumEven = 0;
        float sumOdd = 0;
        
        // 짝수의 개수와 홀수의 개수를 카운트할 변수
        // 평균 계산 시 분모로 사용됨
        int evenCnt = 0;
        int oddCnt = 0;

        // 배열의 모든 요소를 순회
        // 향상된 for문(enhanced for loop)을 사용하여 배열의 각 요소에 접근
        for (int item: arr) {
            if (item % 2 == 0) {  // 짝수인 경우
                                  // 2로 나누어 떨어지면 짝수
                sumEven += item;  // 짝수 합계에 추가
                evenCnt++;        // 짝수 개수 증가
            } else {              // 홀수인 경우
                                  // 2로 나누어 떨어지지 않으면 홀수
                sumOdd += item;   // 홀수 합계에 추가
                oddCnt++;         // 홀수 개수 증가
            }
        }

        // 짝수의 평균 계산 및 출력
        // sumEven을 evenCnt로 나누어 평균을 계산
        // float 타입끼리의 나눗셈이므로 결과도 float 타입
        System.out.println("짝수 평균: " + sumEven / evenCnt);
        
        // 홀수의 평균 계산 및 출력
        // sumOdd를 oddCnt로 나누어 평균을 계산
        // float 타입끼리의 나눗셈이므로 결과도 float 타입
        System.out.println("홀수 평균: " + sumOdd / oddCnt);
    }
}