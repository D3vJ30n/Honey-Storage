import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class Practicemission1 {
    public static void main(String[] args) {
        // 프로그램 제목 출력
        System.out.println("[달력 출력 프로그램]");

        // Scanner 객체 생성: 사용자로부터 입력을 받기 위해 사용
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 년도 입력 받기
        // print 메서드를 사용하여 줄바꿈 없이 프롬프트 출력
        System.out.print("달력의 년도를 입력해 주세요(yyyy): ");
        int year = scanner.nextInt(); // nextInt() 메서드로 정수 입력 받기

        // 사용자로부터 월 입력 받기
        System.out.print("달력의 월을 입력해 주세요(mm): ");
        int month = scanner.nextInt();

        System.out.println(); // 빈 줄 출력으로 가독성 향상

        // 3개월의 달력을 저장할 문자열 배열 생성 (이전 달, 현재 달, 다음 달)
        String[] calendars = new String[3];

        // 입력받은 월을 기준으로 이전 달, 현재 달, 다음 달의 달력 생성
        for (int i = -1; i <= 1; i++) {
            // YearMonth.of()로 년월 객체 생성, plusMonths()로 월 조정
            // 사용자가 입력한 년도(year)와 월(month)로 YearMonth 객체를 생성
            YearMonth yearMonth = YearMonth.of(year, month).plusMonths(i);
            // plusMonths(i)를 사용해 이전 달(-1), 현재 달(0), 다음 달(+1)의 YearMonth 객체를 만듦
            // generateCalendar 메서드를 호출하여 달력 문자열 생성 및 배열에 저장
            calendars[i + 1] = generateCalendar(yearMonth);
        }

        // 생성된 3개월 달력을 가로로 출력하는 메서드 호출
        printCalendarsHorizontally(calendars);

        // Scanner 객체 닫기 (리소스 해제)
        scanner.close();
    }

    public static String generateCalendar(YearMonth yearMonth) {
        // StringBuilder 객체 생성
        // 달력의 내용을 동적으로 구성하기 위해 사용
        // String 대신 StringBuilder 사용하여 문자열 조작의 효율성 증가
        StringBuilder calendar = new StringBuilder();

        // 이하 달력 생성 로직
        // 1. 달력 제목 (년월) 추가
        // 2. 요일 헤더 추가
        // 3. 날짜 채우기
        // 4. 달력 높이 조정

        // 달력 제목 (년도와 월) 추가
        // String.format 사용하여 서식화된 문자열 생성
        // 달력의 제목 (년도와 월) 추가

        // String.format 사용하여 서식화된 문자열 생성 후 StringBuilder에 추가
        calendar.append(String.format(" [%d년 %02d월]              \n", yearMonth.getYear(), yearMonth.getMonthValue()));

        // 1. String.format(): 지정된 형식에 따라 문자열을 생성
        //    - " [%d년 %02d월]              \n": 형식 문자열
        //      %d: 첫 번째 정수 인자 (년도)
        //      %02d: 두 번째 정수 인자, 2자리로 표시하고 필요시 앞에 0을 채움 (월)
        //      \n: 줄바꿈 문자
        //    - yearMonth.getYear(): 년도 값 반환
        //    - yearMonth.getMonthValue(): 월 값 반환 (1-12)
        //
        // 2. calendar.append(): 생성된 문자열을 StringBuilder 객체에 추가

        // 출력값 예시: " [2023년 10월]              "
        // 참고: 뒤의 여분의 공백은 달력의 전체 너비를 맞추기 위한 것

        // 요일 헤더 추가
        // 달력의 상단에 요일을 표시하는 행을 추가
        calendar.append("일 월 화 수 목 금 토        \n");

        // 1. "일 월 화 수 목 금 토": 각 요일을 나타내는 문자열
        // 2. 각 요일 사이에는 공백이 하나씩 있음 (날짜 칸과 일치시키기 위함)
        // 3. 마지막의 8개 공백: 달력의 전체 너비를 맞추기 위한 여백
        // 4. \n: 줄바꿈 문자 (요일 헤더 다음에 새 줄 시작)

        // 출력값 예시
        // "일 월 화 수 목 금 토        "
        // 그 다음 줄부터 날짜가 시작됨

        // 해당 월의 1일 날짜 객체 생성
        LocalDate date = yearMonth.atDay(1);

        // 1. yearMonth: YearMonth 타입의 객체로, 특정 년도와 월을 나타냄
        // 2. atDay(1): 해당 월의 1일을 나타내는 LocalDate 객체를 생성하는 메서드
        // 3. LocalDate: 날짜를 표현하는 Java 8 이후의 날짜/시간 API 클래스
        // 4. date: 생성된 LocalDate 객체를 저장하는 변수

        // 목적: 달력 생성을 위한 시작점(해당 월의 1일)을 설정

        // 1일의 요일 계산 (0: 일요일, 1: 월요일, ..., 6: 토요일)
        // getDayOfWeek()는 1(월요일)부터 7(일요일)을 반환하므로 7로 나눈 나머지를 사용
        // 해당 월의 1일이 무슨 요일인지 계산
        int firstDayOfWeek = date.getDayOfWeek().getValue() % 7;

        // 1. date.getDayOfWeek(): 해당 날짜의 요일을 반환 (DayOfWeek 열거형)
        // 2. getValue(): DayOfWeek 열거형의 숫자 값을 반환 (1: 월요일, ..., 7: 일요일)
        // 3. % 7: 7로 나눈 나머지를 계산 (0: 일요일, 1: 월요일, ..., 6: 토요일)
        // 4. firstDayOfWeek: 계산된 요일 값을 저장하는 변수 (0-6 사이의 값)

        // 목적: 달력에서 1일의 위치를 결정하기 위해 1일의 요일 정보를 얻음

        // 한 주를 나타내는 문자열 빌더 초기화
        StringBuilder weekBuilder = new StringBuilder("   ".repeat(7));

        // 1. StringBuilder: 문자열을 효율적으로 조작하기 위한 클래스
        // 2. "   ": 3개의 공백 문자
        // 3. repeat(7): 주어진 문자열을 7번 반복
        // 4. 결과: 21개의 공백으로 이루어진 문자열 (3 * 7 = 21)

        // 목적: 달력의 한 주를 표현하기 위한 기본 틀 생성

        // 첫 주의 시작 전 빈 칸 채우기
        for (int i = 0; i < firstDayOfWeek; i++) {
            weekBuilder.replace(i * 3, i * 3 + 2, "  ");
        }

        // 1. firstDayOfWeek: 해당 월의 1일이 무슨 요일인지를 나타내는 값 (0: 일요일, 1: 월요일, ..., 6: 토요일)
        // 2. weekBuilder: 한 주를 나타내는 StringBuilder 객체 (초기에 21개의 공백으로 채워져 있음)
        // 3. replace() 메서드: StringBuilder 특정 범위를 다른 문자열로 교체
        // 4. i * 3: 교체를 시작할 인덱스(현재 날짜 칸의 시작 위치)
        // 5. i * 3 + 2: 교체를 끝낼 인덱스(현재 날짜 칸의 끝낼 위치)
        // 6. "  ": 두 개의 공백 (날짜가 없는 빈 칸을 나타냄)

        // 목적: 달력의 첫 주에서 1일 이전의 날짜를 빈 칸으로 채움

        // 현재 월의 모든 날짜를 처리하는 루프
        while (date.getMonthValue() == yearMonth.getMonthValue()) {
            // 현재 날짜의 요일 계산 (0: 일요일, 1: 월요일, ..., 6: 토요일)
            int dayOfWeek = date.getDayOfWeek().getValue() % 7;

            // 1. while 조건: 현재 처리 중인 날짜(date)가 목표 월(yearMonth)에 속하는지 확인
            // 2. date.getMonthValue(): 현재 날짜의 월 반환
            // 3. yearMonth.getMonthValue(): 목표 월 반환
            // 4. dayOfWeek 계산: 현재 날짜의 요일을 0-6 사이의 값으로 변환

            // 해당 요일 위치에 날짜 삽입
            weekBuilder.replace(dayOfWeek * 3, dayOfWeek * 3 + 2, String.format("%02d", date.getDayOfMonth()));

            // 토요일이거나 월의 마지막 날인지 확인
            if (dayOfWeek == 6 || date.plusDays(1).getMonthValue() != yearMonth.getMonthValue()) {
                // 현재 주를 달력에 추가하고 줄바꿈
                calendar.append(weekBuilder).append("       \n");
                // calendar 현재 주의 날짜들(weekBuilder)을 추가하고,
                // 7개의 공백("       ")과 줄바꿈("\n")을 덧붙임
                // 이는 각 주의 끝에 일관된 형식을 유지하기 위함

                // 다음 주를 위해 weekBuilder 초기화 (7일 * 3칸 = 21칸의 공백)
                weekBuilder = new StringBuilder("   ".repeat(7));
                // 새로운 StringBuilder 객체를 생성하여 weekBuilder 초기화
                // "   "을 7번 반복하여 21개의 공백으로 채움
                // 이는 다음 주의 날짜를 채우기 위한 준비 작업
            }

            // 다음 날짜로 이동
            date = date.plusDays(1);
        }
        // LocalDate 객체인 date 다음 날로 업데이트
        // plusDays(1)는 현재 날짜에 1일을 더한 새 LocalDate 객체를 반환

        // while 루프 종료
        // 이 지점에서 월의 모든 날짜를 처리하는 while 루프가 종료

        // 달력의 높이를 일정하게 맞추기
        while (calendar.toString().split("\n").length < 8) {
            // 현재 달력의 줄 수가 8줄 미만이면 빈 줄 추가
            // 21개의 공백과 줄바꿈을 추가
            calendar.append("                     \n");
        }
        // calendar.toString()으로 현재 달력 문자열을 얻고,
        // split("\n")으로 줄바꿈을 기준으로 분할하여 줄 수를 계산
        // 줄 수가 8 미만이면 21개의 공백과 줄바꿈을 추가
        // 이는 달력의 높이를 항상 8줄(제목 1줄 + 요일 1줄 + 최대 6주)로 맞추기 위함

        // 완성된 달력 문자열 반환
        // StringBuilder 객체인 calendar String 변환하여 반환
        // 이것이 최종적으로 생성된 달력의 문자열 표현
        return calendar.toString();
    }

    public static void printCalendarsHorizontally(String[] calendars) {
        // 3개의 달력을 줄 단위로 분리하여 저장할 2차원 배열 선언
        // 첫 번째 차원은 3개의 달력을 나타내고, 두 번째 차원은 각 달력의 줄을 나타냄
        String[][] calendarLines = new String[3][];

        // 각 달력 문자열을 줄 단위로 분리
        for (int i = 0; i < 3; i++) {
            // split("\n")을 사용하여 줄바꿈 문자를 기준으로 문자열을 분리
            // 결과적으로 각 달력의 줄별 문자열 배열이 생성됨
            calendarLines[i] = calendars[i].split("\n");
        }

        // 3개의 달력을 가로로 나란히 출력
        // 각 달력은 8줄로 구성 (제목 1줄 + 요일 헤더 1줄 + 날짜 최대 6줄)
        for (int i = 0; i < 8; i++) {
            // 3개의 달력에 대해 반복
            for (int j = 0; j < 3; j++) {
                // calendarLines[j][i]는 j번째 달력의 i번째 줄을 의미
                // 현재 처리 중인 달력의 현재 줄을 출력
                System.out.print(calendarLines[j][i]);

                // 마지막 달력이 아닌 경우 (첫 번째, 두 번째 달력 출력 후)
                if (j < 2) {
                    // 달력 사이에 2칸의 공백을 추가하여 시각적으로 구분
                    System.out.print("  ");
                }
            }
            // 현재 줄의 3개 달력을 모두 출력한 후 줄바꿈
            // 이로써 다음 줄 출력 준비
            System.out.println();
        }
    }
}