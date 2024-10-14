// java.util 패키지에서 Scanner 클래스를 가져옴. 사용자 입력을 받기 위해 필요
import java.util.Scanner;

// Tax라는 이름의 public 클래스 선언. 파일명도 Tax.java여야 함
public class Tax {
    // static 키워드: 이 변수들이 클래스 수준에서 공유됨을 의미
    // long[]: 큰 정수를 저장할 수 있는 배열 타입
    // 과세표준 구간을 나타내는 배열. 각 요소는 해당 세율이 적용되는 소득의 상한선
    static long[] brackets = {0, 12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};
  
    // int[]: 정수를 저장하는 배열 타입
    // 각 과세 구간에 대응되는 세율(%)을 저장하는 배열
    static int[] rates = {6, 15, 24, 35, 38, 40, 42, 45};
  
    // 각 과세 구간별 누진공제액을 저장하는 배열. 세금 계산 시 공제되는 금액
    static long[] deductions = {0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000};

    // 프로그램의 진입점. public으로 선언되어 JVM이 직접 호출할 수 있음
    public static void main(String[] args) {
        // Scanner 객체 생성. System.in을 인자로 전달하여 키보드 입력을 받음
        Scanner scanner = new Scanner(System.in);
    
        // 프로그램 타이틀 출력
        System.out.println("[과세금액 계산 프로그램]");
        // 사용자에게 연소득 입력 요청
        System.out.print("연소득을 입력해 주세요.: ");
        // nextLong() 메서드로 사용자의 입력을 long 타입으로 받아 annualIncome 변수에 저장
        long annualIncome = scanner.nextLong();

        // 세금 계산 및 결과 출력 메서드 호출. 입력받은 연소득을 인자로 전달
        printTaxDetails(annualIncome);

        // Scanner 객체를 닫아 시스템 리소스를 해제. 메모리 누수 방지를 위한 좋은 습관
        scanner.close();
    }

    // 세금 계산 및 결과 출력 메서드. static으로 선언되어 객체 생성 없이 호출 가능
    // void: 반환값이 없음을 의미
    static void printTaxDetails(long income) {
        long totalTax = 0;  // 총 세금을 저장할 변수 초기화
        long remainingIncome = income;  // 과세 대상 소득을 저장할 변수 초기화

        // for 루프: 각 과세 구간별 세금 계산
        // i는 1부터 시작함
        // 1) brackets[0]은 항상 0이므로 첫 번째 실제 과세 구간은 brackets[1]부터 시작
        // 2) 각 과세 구간의 상한선은 brackets[i]이고, 하한선은 brackets[i-1]이 됨
        // i < brackets.length 조건으로 모든 과세 구간을 순회
        // remainingIncome > 0 조건으로 과세할 소득이 남아있을 때만 계산 수행
        for (int i = 1; i < brackets.length && remainingIncome > 0; i++) {
            // 현재 구간에 해당하는 과세 대상 소득 계산
            // brackets[i] - brackets[i-1]: 현재 과세 구간의 범위
            // 예: i가 1일 때, 0원 ~ 12,000,000원 구간
            // Math.min 함수로 남은 소득과 현재 구간의 상한선 중 작은 값을 선택
            // 이를 통해 현재 구간에서 과세될 실제 소득을 계산
            long taxableIncome = Math.min(remainingIncome, brackets[i] - brackets[i-1]);
            
            // 과세 대상 소득이 있는 경우에만 세금 계산
            if (taxableIncome > 0) {
                // 해당 구간의 세율로 세금 계산
                // rates[i-1]을 사용하는 이유
                // 1) rates 배열은 0부터 시작하여 각 과세 구간의 세율을 저장
                // 2) i는 1부터 시작했으므로, 해당 구간의 세율을 가져오려면 i-1을 인덱스로 사용
                // 예: i가 1일 때, rates[0]인 6%가 적용됨
                long tax = taxableIncome * rates[i-1] / 100;
                totalTax += tax;  // 계산된 세금을 총 세금에 추가
                
                // 계산 결과 출력. printf로 형식화된 출력 수행
                // %10d: 10자리 정수, %2d: 2자리 정수, %%: % 문자 자체를 출력
                System.out.printf("%10d * %2d%% = %10d\n", taxableIncome, rates[i-1], tax);
                
                // 남은 소득 갱신. 현재 구간에서 과세된 소득을 차감
                remainingIncome -= taxableIncome;
            }
        }

        // 세율에 의한 총 세금 출력
        System.out.printf("\n[세율에 의한 세금]: %d\n", totalTax);

        // 누진공제 적용한 세금 계산 및 출력
        // calculateTaxWithDeduction 메서드를 호출하여 누진공제가 적용된 세금 계산
        // income을 인자로 전달하여 전체 소득에 대한 누진공제 세금을 계산
        long taxWithDeduction = calculateTaxWithDeduction(income);

        // 계산된 누진공제 세금을 출력
        // printf를 사용하여 형식화된 출력을 수행
        // %d는 정수(long)를 출력하기 위한 형식 지정자
        // \n은 줄바꿈을 위한 이스케이프 문자
        System.out.printf("[누진공제 계산에 의한 세금]: %d\n", taxWithDeduction);

        // 여기서 taxWithDeduction은 최종적으로 납부해야 할 세금을 나타냄
        // 이 값은 총소득에 대해 적용 가능한 최고 세율을 적용한 후,
        // 해당 구간의 누진공제액을 차감한 결과임
        // 이 방식은 단순히 구간별로 세금을 계산하여 합산하는 것보다
        // 계산이 간단하면서도 정확한 결과를 제공함
    }

    // 누진공제 적용한 세금 계산 메서드
    // static: 객체 생성 없이 호출 가능
    // long: 64비트 정수를 반환함을 나타냄
    static long calculateTaxWithDeduction(long income) {
			// 가장 높은 세율 구간부터 역순으로 확인
				
        // 이유:\
        // 1) 고소득자의 경우 빠르게 해당 구간을 찾을 수 있음 (성능 최적화)
				// 2) 세금 계산 시 항상 가장 높은 적용 가능한 세율을 먼저 찾아야 함
				
        // brackets.length - 1: 배열의 마지막 인덱스부터 시작
        // i >= 0: 0번 인덱스(최저 구간)까지 확인
        for (int i = brackets.length - 1; i >= 0; i--) {
            // 소득이 현재 구간의 하한선보다 크면 해당 구간의 세율 적용
            // brackets[i]는 현재 구간의 하한선을 나타냄
            // 예: i가 7일 때, income > 1,000,000,000원 여부 확인
            if (income > brackets[i]) {
							// 해당 구간의 세율로 세금 계산 후 누진공제 적용
								
                // rates[i]를 사용하는 이유
                // 1) 역순으로 순회하므로 i가 직접 rates 배열의 올바른 인덱스가 됨
                // 2) 예: i가 7이면 rates[7]은 45%(최고 세율)를 나타냄
                long tax = income * rates[i] / 100;
                
								// 계산된 세금에서 해당 구간의 누진공제액을 차감하여 반환
								
                // deductions[i]를 사용하는 이유
                // 1) 각 세율 구간별로 정해진 누진공제액이 있음
                // 2) i가 rates와 동일한 인덱스를 가리키므로 deductions에도 같은 인덱스 사용
                // 3) 예: i가 7이면 deductions[7]은 65,400,000원(최고 구간의 누진공제액)
                return tax - deductions[i];
            }
        }
        // 과세표준이 0 이하인 경우 0 반환
        // 모든 구간을 확인했는데도 해당되는 구간이 없는 경우 (0원 이하의 소득)
        return 0;
    }
}