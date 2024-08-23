// 필요한 Java 유틸리티 클래스들을 import.
import java.util.ArrayList;  // 동적 크기의 배열을 사용하기 위한 클래스
import java.util.List;       // List 인터페이스 (ArrayList의 상위 인터페이스)
import java.util.Scanner;    // 사용자 입력을 받기 위한 클래스

// JosephusProblem 클래스를 정의. 이 클래스는 요세푸스 문제를 해결하는 메소드들을 포함.
public class JosephusProblem {
    
    // 1부터 N까지의 정수로 리스트를 초기화하는 메소드.
    public static List<Integer> initializeList(int N) {
        // Integer 타입의 요소를 저장할 수 있는 ArrayList를 생성.
        List<Integer> list = new ArrayList<>();
        
        // 1부터 N까지의 정수를 리스트에 추가.
        for (int i = 1; i <= N; i++) {
            list.add(i);  // ArrayList의 add 메소드를 사용하여 요소를 추가.
        }
        
        // 완성된 리스트를 반환.
        return list;
    }

    // 요세푸스 순열을 생성하는 메소드.
    public static List<Integer> generateJosephusSequence(List<Integer> circle, int K) {
        // 요세푸스 순열을 저장할 새로운 ArrayList를 생성.
        List<Integer> sequence = new ArrayList<>();
        // 현재 위치를 나타내는 인덱스 변수를 초기화.
        int index = 0;

        // 원형 리스트(circle)가 비어있지 않은 동안 반복.
        while (!circle.isEmpty()) {
            // 다음 제거할 요소의 인덱스를 계산.
            // (현재 인덱스 + K - 1)을 원형 리스트의 크기로 나눈 나머지를 구한다.
            // 이렇게 하면 리스트의 끝에 도달했을 때 자동으로 처음으로 돌아간다.
            index = (index + K - 1) % circle.size();
            
            // 계산된 인덱스의 요소를 원형 리스트에서 제거하고, 
            // 그 요소를 요세푸스 순열에 추가.
            sequence.add(circle.remove(index));
        }

        // 완성된 요세푸스 순열을 반환.
        return sequence;
    }

    // 프로그램의 main 메소드입니다. 프로그램 실행의 시작점.
    public static void main(String[] args) {
        // 사용자 입력을 받기 위한 Scanner 객체를 생성.
        Scanner scanner = new Scanner(System.in);
        
        // 사용자에게 입력 안내 메시지를 출력.
        System.out.println("N과 K를 입력");
        
        // 사용자로부터 N과 K 값을 입력받는다.
        int N = scanner.nextInt();  // 첫 번째 정수를 N에 저장.
        int K = scanner.nextInt();  // 두 번째 정수를 K에 저장.

        // 입력받은 N과 K 값을 출력하여 확인.
        System.out.println("입력받은 N: " + N);
        System.out.println("입력받은 K: " + K);

        // 1부터 N까지의 정수로 초기화된 리스트를 생성.
        List<Integer> circle = initializeList(N);
        
        // 생성된 리스트와 K 값을 이용하여 요세푸스 순열을 생성.
        List<Integer> josephusSequence = generateJosephusSequence(circle, K);
        
        // 생성된 요세푸스 순열을 출력.
        System.out.println("요세푸스 순열: " + josephusSequence);

        // 사용이 끝난 Scanner 객체를 닫아 리소스를 해제.
        scanner.close();
    }
}