// java.util 패키지에서 필요한 클래스들을 가져옴. import 문은 다른 패키지의 클래스를 현재 파일에서 사용할 수 있게 해줌
import java.util.Random;  // Random 클래스: 난수 생성을 위해 사용됨
import java.util.Scanner;  // Scanner 클래스: 사용자 입력을 받기 위해 사용됨
import java.util.Arrays;  // Arrays 클래스: 배열 조작을 위한 유틸리티 메서드들을 제공함

// Lotto라는 이름의 public 클래스를 선언. public으로 선언되어 다른 패키지에서도 접근 가능
// 클래스명은 파일명과 동일해야 함 (Lotto.java)
public class Lotto {
    // main 메서드: 프로그램의 진입점. public으로 선언되어 JVM이 직접 호출할 수 있음
    // static: 객체 생성 없이 호출 가능. void: 반환값 없음
    // String[] args: 명령줄 인자를 받기 위한 매개변수
    public static void main(String[] args) {
        // Scanner 객체 생성. System.in을 인자로 전달하여 표준 입력(키보드)으로부터 입력을 받음
        // new 키워드로 객체를 동적 할당함
        Scanner scanner = new Scanner(System.in);
        
        // Random 객체 생성. 인자 없이 생성하면 현재 시스템 시간을 시드로 사용함
        // 이를 통해 매번 다른 난수 시퀀스를 생성할 수 있음
        Random random = new Random();

        // println 메서드를 사용하여 문자열을 출력하고 줄바꿈을 함
        // System.out은 표준 출력 스트림을 나타냄
        System.out.println("[로또 당첨 프로그램]");
        // print 메서드는 줄바꿈 없이 문자열을 출력함
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10): ");
        
        // scanner.nextInt()를 호출하여 사용자로부터 정수 입력을 받음
        // 입력받은 값을 count 변수에 저장. int는 32비트 정수형 데이터 타입
        int count = scanner.nextInt();

        // if 문을 사용하여 조건을 검사. 조건이 true일 때 중괄호 {} 내의 코드 블록이 실행됨
        // || 는 논리 OR 연산자. 두 조건 중 하나라도 true면 전체가 true가 됨
        if (count < 1 || count > 10) {
            // 조건이 true일 때 실행되는 코드 블록
            System.out.println("잘못된 입력입니다. 1에서 10 사이의 숫자를 입력해주세요.");
            // scanner 객체를 닫아 자원을 해제함. 이는 메모리 누수를 방지하기 위한 좋은 습관임
            scanner.close();
            // return 문을 사용하여 메서드를 즉시 종료함. 여기서는 프로그램을 끝내는 역할을 함
            return;
        }

        // 2차원 정수 배열을 선언하고 초기화함
        // 첫 번째 대괄호 [count]는 로또 티켓의 수, 두 번째 대괄호 [6]은 각 티켓의 번호 개수를 나타냄
        int[][] lottoNumbers = new int[count][6];
        // for 루프: 초기화식, 조건식, 증감식으로 구성됨
        // i는 0부터 시작하여 count-1까지 1씩 증가하며 반복함
        for (int i = 0; i < count; i++) {
            // generateLottoNumbers 메서드를 호출하여 새 로또 번호 세트를 생성하고 결과를 배열에 저장함
            // random 객체를 인자로 전달하여 동일한 난수 생성기를 사용함
            lottoNumbers[i] = generateLottoNumbers(random);
            
            // 문자열 연결 연산자 +를 사용하여 여러 부분을 하나의 문자열로 만듦
            // (char)('A' + i)는 A부터 시작하는 연속된 알파벳을 생성함. 'A'의 ASCII 값은 65
            // arrayToString 메서드를 호출하여 정수 배열을 보기 좋은 문자열로 변환함
            System.out.println((char)('A' + i) + " " + arrayToString(lottoNumbers[i]));
        }

        // 빈 줄을 출력하여 가독성을 높임
        System.out.println("\n[로또 발표]");
        // 당첨 번호를 생성하고 그 결과를 winningNumbers 배열에 저장함
        int[] winningNumbers = generateLottoNumbers(random);
        // 생성된 당첨 번호를 문자열로 변환하여 출력함
        System.out.println(arrayToString(winningNumbers));

        System.out.println("\n[내 로또 결과]");
        // 이전과 동일한 for 루프 구조를 사용하여 각 로또 티켓에 대해 반복함
        for (int i = 0; i < count; i++) {
            // countMatches 메서드를 호출하여 당첨 번호와 일치하는 숫자의 개수를 계산함
            int matches = countMatches(lottoNumbers[i], winningNumbers);
            // printf 메서드를 사용하여 형식화된 문자열을 출력함
            // %c는 문자, %s는 문자열, %d는 정수를 나타내는 형식 지정자임
            // 각 형식 지정자에 해당하는 값들이 순서대로 뒤에 나열됨
            System.out.printf("%c %s => %d개 일치\n", (char)('A' + i), arrayToString(lottoNumbers[i]), matches);
        }

        // 프로그램 종료 전 scanner 객체를 닫아 자원을 해제함
        scanner.close();
    }

    // 로또 번호 6개를 생성하는 메서드
    // public: 다른 클래스에서도 접근 가능. static: 객체 생성 없이 호출 가능
    // int[]: 정수 배열을 반환함을 나타냄
    public static int[] generateLottoNumbers(Random random) {
        // 6개의 정수를 저장할 수 있는 배열을 생성함
        int[] numbers = new int[6];
        // 6번 반복하여 각 번호를 생성함
        for (int i = 0; i < 6; i++) {
            int number;
            // do-while 루프: 최소한 한 번은 실행되고, 조건이 false일 때까지 반복함
            do {
                // nextInt(45)는 0 이상 44 미만의 난수를 생성함. 4가 최댓값인 이유는 0부터 시작하기 때문. 0을 포함하여 45개의 숫자를 표현하려면 44까지만 필요. 생성 가능한 난수의 범위는 0 이상 45 미만이기 때문
                // 여기에 1을 더해 1부터 45까지의 범위로 조정함
                number = random.nextInt(45) + 1;
            // 생성된 번호가 이미 배열에 있는지 확인. 중복이면 다시 생성함
            } while (contains(numbers, number, i));
            // 생성된 번호를 배열에 저장함
            numbers[i] = number;
        }
        // Arrays.sort() 메서드를 사용하여 배열을 오름차순으로 정렬함
        Arrays.sort(numbers);
        // 생성 및 정렬된 번호 배열을 반환함
        return numbers;
    }

    // 배열에 특정 숫자가 포함되어 있는지 확인하는 메서드
    // private: 이 클래스 내에서만 접근 가능
    // boolean: true 또는 false를 반환함
    private static boolean contains(int[] array, int number, int end) {
        // for 루프를 사용하여 배열의 요소를 순회함
        // 0부터 end-1까지의 인덱스만 확인함
        for (int i = 0; i < end; i++) {
            // 배열의 현재 요소와 찾고자 하는 숫자를 비교함
            if (array[i] == number) {
                // 숫자를 찾으면 true를 반환하고 메서드를 종료함
                return true;
            }
        }
        // 루프를 모두 돌았는데 숫자를 찾지 못했다면 false를 반환함
        return false;
    }

    // 정수 배열을 보기 좋은 문자열로 변환하는 메서드
    private static String arrayToString(int[] array) {
        // StringBuilder 객체를 생성함. 문자열 연결 작업을 효율적으로 수행하기 위해 사용함
        StringBuilder sb = new StringBuilder();
        // 배열의 모든 요소를 순회함
        for (int i = 0; i < array.length; i++) {
            // String.format 사용하여 각 숫자를 두 자리 문자열로 변환함
            // %02d는 2자리 정수를 나타내며, 한 자리 수의 경우 앞에 0을 붙임. 0을 빼면 한 자리 수가 되는 것이 아니라, 오히려 '0'을 붙임으로써 한 자리 수를 두 자리로 만드는 것. 이는 숫자의 자릿수를 일정하게 유지하여 출력의 정렬을 돕는 역할
            sb.append(String.format("%02d", array[i]));
            // 마지막 숫자가 아니라면 쉼표를 추가함
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        // 완성된 문자열을 반환함
        return sb.toString();
    }

    // 두 배열에서 일치하는 숫자의 개수를 세는 메서드
    private static int countMatches(int[] numbers, int[] winningNumbers) {
        // 일치하는 숫자의 개수를 저장할 변수를 초기화함
        int count = 0;
        // 향상된 for 루프(enhanced for loop)를 사용하여 numbers 배열의 각 요소에 대해 반복함
        // 이 문법은 배열이나 컬렉션의 모든 요소를 순회할 때 유용함
        for (int number : numbers) {
            // contains 메서드를 호출하여 현재 숫자가 당첨 번호에 포함되어 있는지 확인함
            // winningNumbers.length를 전달하여 배열의 모든 요소를 검사함
            if (contains(winningNumbers, number, winningNumbers.length)) {
                // 일치하는 숫자를 찾으면 카운트를 1 증가시킴
                count++;
            }
        }
        // 최종적으로 계산된 일치하는 숫자의 개수를 반환함
        return count;
    }
}