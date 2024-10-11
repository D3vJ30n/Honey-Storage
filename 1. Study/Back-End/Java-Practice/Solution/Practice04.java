/**
 * 다양한 유형의 별(*) 패턴을 출력하는 프로그램
 * 클래스명을 Practice4로 지정하여 연습문제임을 명시
 */
public class Practice4 {
    /**
     * solution 메소드: 패턴 타입을 구분하여 적절한 메소드 호출
     * @param n: 패턴의 크기를 결정하는 매개변수
     * @param type: 출력할 패턴의 종류를 지정하는 매개변수
     */
    public static void solution(int n, int type) {
        // if-else 구문을 사용하여 type 값에 따라 적절한 메소드 호출
        // switch 문을 사용할 수도 있지만, 여기서는 간단한 구분을 위해 if-else 사용
        if (type == 1) {
            type1(n);
        } else if (type == 2) {
            type2(n);
        } else if (type == 3) {
            type3(n);
        } else if (type == 4) {
            type4(n);
        } else if (type == 5) {
            type5(n);
        }
    }

    /**
     * type1 메소드: n x n 정사각형 모양의 별 패턴
     */
    public static void type1(int n) {
        System.out.println("== Type1 ==");  // 패턴 구분을 위한 헤더 출력
        
        // 외부 반복문: 행(row) 제어
        for (int i = 0; i < n; i++) {
            // 내부 반복문: 열(column) 제어
            for (int j = 0; j < n; j++) {
                System.out.print("*");  // println이 아닌 print 사용하여 같은 줄에 출력
            }
            System.out.println();  // 한 행이 끝날 때마다 줄바꿈
        }
        System.out.println();  // 패턴 간 구분을 위한 빈 줄 출력
    }

    /**
     * type2 메소드: 왼쪽 정렬 삼각형 패턴
     */
    public static void type2(int n) {
        System.out.println("== Type2 ==");
        
        // 외부 반복문: i값이 증가할수록
        for (int i = 0; i < n; i++) {
            // 내부 반복문: i+1만큼 별을 출력하여 삼각형 형태 생성
            // j < i + 1 조건으로 각 행마다 별이 1개씩 증가
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();  // 행 변경을 위한 줄바꿈
        }
        System.out.println();
    }

    /**
     * type3 메소드: 오른쪽 정렬 삼각형 패턴
     */
    public static void type3(int n) {
        System.out.println("== Type3 ==");
        
        // 외부 반복문: 전체 행 수 제어
        for (int i = 0; i < n; i++) {
            // 내부 반복문: 공백과 별을 적절히 배치
            for (int j = 0; j < n; j++) {
                // j < n - i - 1 조건으로 행이 증가할수록 공백이 감소하고 별이 증가
                if (j < n - i - 1) {
                    System.out.print(" ");  // 공백 출력
                } else {
                    System.out.print("*");  // 별 출력
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * type4 메소드: 피라미드 모양 패턴
     */
    public static void type4(int n) {
        System.out.println("== Type4 ==");
        
        // 외부 반복문: 행 수 제어
        for (int i = 0; i < n; i++) {
            // 첫 번째 내부 반복문: 행의 앞쪽 공백 출력
            // n - i - 1 만큼 공백을 출력하여 중앙 정렬 효과 생성
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            
            // 두 번째 내부 반복문: 별 출력
            // i * 2 + 1 공식으로 각 행의 별 개수 계산 (1, 3, 5, ...)
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * type5 메소드: 다이아몬드 모양 패턴
     */
    public static void type5(int n) {
        System.out.println("== Type5 ==");
        
        // 상단부 출력 (피라미드 모양)
        // i <= n/2 조건으로 다이아몬드의 중간까지만 반복
        for (int i = 0; i <= n / 2; i++) {
            // 공백 출력: 중앙으로 갈수록 감소
            for (int j = 0; j < n / 2 - i; j++) {
                System.out.print(" ");
            }
            
            // 별 출력: 중앙으로 갈수록 증가
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 하단부 출력 (역피라미드 모양)
        // i를 n/2부터 시작하여 감소시키며 역피라미드 형태 생성
        for (int i = n / 2; i > 0; i--) {
            // 공백 출력: 아래로 갈수록 증가
            for (int j = 0; j < n / 2 + 1 - i; j++) {
                System.out.print(" ");
            }
            
            // 별 출력: 아래로 갈수록 감소
            // i * 2 - 1 공식으로 별 개수 계산
            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        System.out.println();
    }

    /**
     * main 메소드: 각 패턴의 테스트를 위한 메소드
     */
    public static void main(String[] args) {
        // 다양한 크기와 타입으로 테스트
        solution(3, 1);  // 3x3 정사각형 테스트
        solution(3, 2);  // 3행 왼쪽 정렬 삼각형 테스트
        solution(3, 3);  // 3행 오른쪽 정렬 삼각형 테스트
        solution(3, 4);  // 3행 피라미드 테스트
        solution(7, 5);  // 7행 다이아몬드 테스트 (홀수 사용)
    }
}