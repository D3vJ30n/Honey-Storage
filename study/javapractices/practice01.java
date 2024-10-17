package study.javapractices;

public class Practice1 {
    /**
     * 입력된 정수를 뒤집어서 출력하는 메소드
     * 예: 12345 -> 54321, -12345 -> -54321
     * @param num 뒤집을 정수
     */
    public static void solution(int num) {
        // 뒤집힌 숫자를 저장할 변수 초기화
        int numReverse = 0;

        // 입력된 숫자가 음수인지 체크하는 플래그 변수
        boolean isMinus = false;

        // 음수인 경우 처리
        if (num < 0) {
            isMinus = true;    // 음수 플래그를 true로 설정
            num *= -1;         // 숫자를 양수로 변환 (절대값)
        }

        // 숫자를 뒤집는 과정
        // num이 0보다 큰 동안 계속 반복
        while (num > 0) {
            // 현재 숫자의 마지막 자릿수 추출
            // 예: 12345 % 10 = 5
            int r = num % 10;

            // 기존 숫자에서 마지막 자릿수를 제거
            // 예: 12345 / 10 = 1234
            num /= 10;

            // 뒤집힌 숫자 만들기
            // numReverse에 10을 곱하고 현재 자릿수를 더함
            // 예: 0 * 10 + 5 = 5
            //     5 * 10 + 4 = 54
            //     54 * 10 + 3 = 543 ...
            numReverse = numReverse * 10 + r;
        }

        // 결과 출력
        // 삼항 연산자를 사용하여 원본 숫자가 음수였다면 결과도 음수로 출력
        // isMinus가 true면 numReverse에 -1을 곱하고, false면 그대로 출력
        System.out.println(isMinus ? numReverse * -1 : numReverse);
    }

    public static void main(String[] args) {
        // 테스트 코드
        solution(12345);   // 출력: 54321
        solution(-12345);  // 출력: -54321
        solution(100);     // 출력: 1
        solution(0);       // 출력: 0
    }
}