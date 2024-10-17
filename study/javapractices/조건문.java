package study.javapractices;

// Java 프로그래밍 - 조건문 예제
// 이 클래스는 if문과 switch문의 기본적인 사용법을 보여줍니다.
// 실제 프로그래밍에서 자주 사용되는 조건문의 다양한 활용 사례를 다룹니다.
public class 조건문 {
    public static void main(String[] args) {
        // 1. 조건문 - if
        // if문은 주어진 조건이 참일 때 특정 코드 블록을 실행합니다.
        // 프로그램의 흐름을 제어하는 가장 기본적이고 중요한 구문입니다.
        System.out.println("== if ==");
        
        // 물의 온도를 확인하는 예제
        // 실생활에서 자주 접하는 상황을 코드로 구현한 예시입니다.
        // 센서 등에서 받아온 온도 데이터를 처리할 때 이와 같은 조건문을 사용합니다.
        int waterTemperature = 99;
        
        // if-else문을 사용하여 물의 온도가 100도 이상인지 확인
        // 정확히 두 가지 경우로 나누어지는 상황에서 if-else 구문을 사용합니다.
        if (waterTemperature >= 100) {
            System.out.println("물이 끓습니다.");
        } else {
            System.out.println("물을 끓이는 중입니다.");
        }
        
        // 점수에 따른 등급 판단 예제
        // 학교나 시험 등에서 자주 사용되는 성적 산출 로직입니다.
        // 여러 구간으로 나누어진 조건을 처리할 때 if-else if 구문이 효과적입니다.
        int score = 90;
        char grade = 0;  // 등급을 저장할 변수 초기화
        
        // if-else if-else 구문을 사용한 다중 조건 처리
        // 조건을 위에서부터 순차적으로 검사하므로, 
        // 가장 높은 점수대부터 차례로 조건을 작성합니다.
        if (score >= 90) {         // 90점 이상이면 A
            grade = 'A';
        } else if (score >= 80) {  // 80점 이상이면 B
            grade = 'B';
        } else if (score >= 70) {  // 70점 이상이면 C
            grade = 'C';
        } else {                   // 그 외의 경우는 F
            grade = 'F';
        }
        System.out.println("grade = " + grade);
        
        // 2. 조건문 - switch
        // switch문은 하나의 변수를 여러 값과 비교할 때 사용합니다.
        // if-else if 구문이 많아질 때 switch문을 사용하면 코드가 더 깔끔해집니다.
        System.out.println("== switch ==");
        
        // 과일 가격을 확인하는 예제
        // 상품 관리, 메뉴 선택 등 정해진 값들 중에서 선택하는 상황에서 주로 사용됩니다.
        String fruit = "apple";
        switch (fruit) {
            case "apple":     // fruit이 "apple"일 경우
                System.out.println(fruit + "은 5000원 입니다.");
                break;        // break를 사용하여 다음 case로 진행되는 것을 방지합니다.
            case "blueberry": // fruit이 "blueberry"일 경우
                System.out.println(fruit + "은 10000원 입니다.");
                break;
            default:         // 위의 모든 case에 해당하지 않을 경우의 처리
                System.out.println("해당 과일이 없습니다.");
                break;
        }
        
        // Q1. 홀수/짝수 판단 예제
        // 숫자의 성질을 판단하는 가장 기본적인 예제입니다.
        // 나머지 연산자(%)를 사용하여 2로 나누었을 때의 나머지로 판단합니다.
        int number = 5;
        if (number % 2 == 0) {  // % 연산자는 나머지를 구합니다.
            System.out.println("짝수 입니다!");
        } else {
            System.out.println("홀수 입니다!");
        }
        
        // Q2. 점수에 따른 등급 판단을 switch문으로 구현
        // 위의 if-else if 구문을 switch문으로 변경한 예제입니다.
        // 점수를 10으로 나누어 십의 자리수만 사용함으로써 switch문 활용이 가능해집니다.
        int score1 = 90;
        char grade1 = 0;
        
        // score1을 10으로 나누어 십의 자리 수를 기준으로 판단
        // 나눗셈의 몫을 활용하여 범위를 그룹화하는 테크닉을 보여줍니다.
        switch (score1 / 10) {
            case 10:  // 100점
            case 9:   // 90-99점
                // case 10과 9를 연속으로 배치하여 동일한 처리를 하는 방법을 보여줍니다.
                grade1 = 'A';
                break;
            case 8:   // 80-89점
                grade1 = 'B';
                break;
            case 7:   // 70-79점
                grade1 = 'C';
                break;
            default:  // 70점 미만
                grade1 = 'F';
                break;
        }
        System.out.println("grade1 = " + grade1);
    }
}