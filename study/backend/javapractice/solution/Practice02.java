import java.util.Scanner;

public class Practice2 {
    /**
     * 알파벳 대소문자를 서로 변환하는 메소드
     * 소문자 입력 시 대문자로, 대문자 입력 시 소문자로 변환
     */
    public static void solution() {
        // Scanner 객체를 생성하여 사용자 입력을 받을 준비
        Scanner sc = new Scanner(System.in);
        System.out.print("알파벳 입력: ");
        
        // 입력받은 문자열의 첫 번째 문자만 가져옴
        // nextLine()으로 한 줄을 읽고, charAt(0)으로 첫 번째 문자를 추출
        char input = sc.nextLine().charAt(0);
        
        // 변환된 문자의 ASCII 코드를 저장할 변수
        int output = 0;
        
        // 대문자와 소문자의 ASCII 코드 차이를 계산
        // 'a'의 ASCII 코드에서 'A'의 ASCII 코드를 뺀 값 (= 32)
        // 예: 'a'(97) - 'A'(65) = 32
        int step = (int)'a' - (int)'A';
        
        // 입력된 문자 종류별로 처리
        if (input >= 'a' && input <= 'z') {
            // 소문자가 입력된 경우
            // step을 빼서 대문자로 변환
            // 예: 'a'(97) - 32 = 'A'(65)
            output = (int)input - step;
            System.out.println("대문자 변환: " + (char)output);
            
        } else if (input >= 'A' && input <= 'Z') {
            // 대문자가 입력된 경우
            // step을 더해서 소문자로 변환
            // 예: 'A'(65) + 32 = 'a'(97)
            output = (int)input + step;
            System.out.println("소문자 변환: " + (char)output);
            
        } else {
            // 알파벳이 아닌 다른 문자가 입력된 경우
            System.out.println("입력하신 값은 알파벳이 아닙니다.");
        }
    }
    
    /**
     * ASCII 코드 값을 참조하기 위한 메소드
     * 주요 문자들의 ASCII 코드 값을 출력
     */
    public static void reference() {
        // 소문자 'a'의 ASCII 코드 출력 (97)
        int a = (int)'a';
        System.out.println("a = " + a);
        
        // 소문자 'z'의 ASCII 코드 출력 (122)
        int z = (int)'z';
        System.out.println("z = " + z);
        
        // 대문자 'A'의 ASCII 코드 출력 (65)
        int A = (int)'A';
        System.out.println("A = " + A);
        
        // 대문자 'Z'의 ASCII 코드 출력 (90)
        int Z = (int)'Z';
        System.out.println("Z = " + Z);
        
        // 특수문자 '%'의 ASCII 코드 출력 (37)
        int etc = (int)'%';
        System.out.println("etc = " + etc);
    }
    
    public static void main(String[] args) {
        // ASCII 코드 참조값 출력
        reference();
        
        // 대소문자 변환 프로그램 실행
        solution();
    }
}