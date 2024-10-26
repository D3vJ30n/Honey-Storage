package practicecodingtest.zbct;

public class zbct_5_4 {
    public int solution(int n) {
        // 제곱근 계산
        double sqrt = Math.sqrt(n);

        // 제곱근이 정수인지 확인
        if (sqrt == (int) sqrt) {
            return (int) sqrt;
        } else {
            return 0;
        }
    }
}