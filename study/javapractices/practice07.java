package study.javapractices;

public class Practice2 {
    public static String solution(int num) {
        // 결과 문자열을 저장할 변수 초기화
        // StringBuilder를 사용하면 더 효율적이지만, 예제의 단순성을 위해 String 사용
        String result = "";

        // 로마 숫자 표기법을 저장하는 배열
        // 큰 수부터 작은 수 순으로 정렬되어 있음
        // 특별한 경우인 빼기 표현(CM, CD, XC, XL, IX, IV)도 포함
        String[] roman = {
            "M",    // 1000
            "CM",   // 900
            "D",    // 500
            "CD",   // 400
            "C",    // 100
            "XC",   // 90
            "L",    // 50
            "XL",   // 40
            "X",    // 10
            "IX",   // 9
            "V",    // 5
            "IV",   // 4
            "I"     // 1
        };

        // 각 로마 숫자에 대응하는 정수값 배열
        // roman 배열의 각 요소와 1:1 매칭됨
        int[] values = {
            1000,   // M
            900,    // CM
            500,    // D
            400,    // CD
            100,    // C
            90,     // XC
            50,     // L
            40,     // XL
            10,     // X
            9,      // IX
            5,      // V
            4,      // IV
            1       // I
        };

        // 배열의 인덱스를 추적하는 변수
        int i = 0;

        // 입력받은 숫자가 0이 될 때까지 반복
        while (num > 0) {
            // 현재 숫자가 로마 숫자 값보다 크거나 같은 동안 반복
            // 가능한 많은 큰 단위의 로마 숫자를 사용
            while (num >= values[i]) {
                // 해당 로마 숫자 값을 뺌
                num -= values[i];
                // 결과 문자열에 해당 로마 숫자를 추가
                result += roman[i];
            }
            // 다음 로마 숫자로 이동
            i++;
        }

        // 최종 변환된 로마 숫자 문자열 반환
        return result;
    }

    public static void main(String[] args) {
        // 다양한 케이스에 대한 테스트 코드
        System.out.println(solution(3));    // III
        System.out.println(solution(4));    // IV
        System.out.println(solution(6));    // VI
        System.out.println(solution(13));   // XIII
        System.out.println(solution(26));   // XXVI
        System.out.println(solution(1994)); // MCMXCIV
    }
}