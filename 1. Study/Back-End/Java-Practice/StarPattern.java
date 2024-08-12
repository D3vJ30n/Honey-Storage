public class StarPattern {
    public static void main(String[] args) {
        // 전체 패턴의 행 수 (항상 홀수여야 함)
        int rows = 7;
        // 첫 줄에서 시작할 공백의 수
        int spaces = 3;

        // 상단 부분 (증가하는 별)
        for (int i = 1; i <= rows / 2 + 1; i++) {
            // 현재 줄의 공백 출력
            printSpaces(spaces);
            // 현재 줄의 별 출력 (2 * i - 1 공식으로 홀수 개의 별 출력)
            printStars(2 * i - 1);
            // 줄 바꿈
            System.out.println();
            // 다음 줄을 위해 공백 수 감소
            spaces--;
        }

        // 하단 부분 (감소하는 별)
        // 공백 수 초기화 (두 번째 줄부터 시작)
        spaces = 1;
        for (int i = rows / 2; i >= 1; i--) {
            printSpaces(spaces);
            printStars(2 * i - 1);
            System.out.println();
            // 다음 줄을 위해 공백 수 증가
            spaces++;
        }
    }

    /**
     * 지정된 수만큼 공백을 출력하는 메소드
     * @param count 출력할 공백의 수
     */
    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    /**
     * 지정된 수만큼 별을 출력하는 메소드
     * @param count 출력할 별의 수
     */
    private static void printStars(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
    }
}