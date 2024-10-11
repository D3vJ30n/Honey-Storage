package Mission;
/*
백엔드 28기 전도명
*/

import java.util.Scanner;

public class Tax {
  // 과세표준 구간 (단위: 원)
  // 각 배열 요소는 해당 세율이 적용되는 소득의 상한선
  static long[] brackets = {0, 12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};
  
  // 세율 (단위: %)
  // brackets 배열의 각 구간에 대응되는 세율
  static int[] rates = {6, 15, 24, 35, 38, 40, 42, 45};
  
  // 누진공제액 (단위: 원)
  // 각 구간별 누진공제액. 세금 계산 시 공제되는 금액
  static long[] deductions = {0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000};

  public static void main(String[] args) {
    // 사용자 입력을 위한 Scanner 객체 생성
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("[과세금액 계산 프로그램]");
    System.out.print("연소득을 입력해 주세요.: ");
    // 사용자로부터 연소득 입력 받음
    long annualIncome = scanner.nextLong();

    // 세금 계산 및 결과 출력 메서드 호출
    printTaxDetails(annualIncome);

    // Scanner 객체 닫기 (리소스 해제)
    scanner.close();
  }

  // 세금 계산 및 결과 출력 메서드
  static void printTaxDetails(long income) {
    long totalTax = 0;
    long remainingIncome = income;

    // 각 과세 구간별 세금 계산
    for (int i = 1; i < brackets.length && remainingIncome > 0; i++) {
      // 현재 구간에 해당하는 과세 대상 소득 계산
      long taxableIncome = Math.min(remainingIncome, brackets[i] - brackets[i-1]);
      if (taxableIncome > 0) {
        // 해당 구간의 세율로 세금 계산
        long tax = taxableIncome * rates[i-1] / 100;
        totalTax += tax;
        
        // 계산 결과 출력
        System.out.printf("%10d * %2d%% = %10d\n", taxableIncome, rates[i-1], tax);
        
        // 남은 소득 갱신
        remainingIncome -= taxableIncome;
      }
    }

    // 세율에 의한 총 세금 출력
    System.out.printf("\n[세율에 의한 세금]: %d\n", totalTax);

    // 누진공제 적용한 세금 계산 및 출력
    long taxWithDeduction = calculateTaxWithDeduction(income);
    System.out.printf("[누진공제 계산에 의한 세금]: %d\n", taxWithDeduction);
  }

  // 누진공제 적용한 세금 계산 메서드
  static long calculateTaxWithDeduction(long income) {
    // 가장 높은 세율 구간부터 역순으로 확인
    for (int i = brackets.length - 1; i >= 0; i--) {
      if (income > brackets[i]) {
        // 해당 구간의 세율로 세금 계산 후 누진공제 적용
        long tax = income * rates[i] / 100;
        return tax - deductions[i];
      }
    }
    return 0; // 과세표준이 0 이하인 경우
  }
}