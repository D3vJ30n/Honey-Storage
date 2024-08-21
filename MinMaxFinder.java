import java.util.Scanner;

public class MinMaxFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 정수의 개수 N 입력 받기
        int N = sc.nextInt();
        
        // 첫 번째 숫자를 입력 받아 최솟값과 최댓값의 초기값으로 설정
        int min = sc.nextInt();
        int max = min;
        
        // 나머지 N-1개의 숫자를 처리
        for (int i = 1; i < N; i++) {
            int num = sc.nextInt();
            
            // 현재 숫자가 최솟값보다 작으면 최솟값 갱신
            if (num < min) {
                min = num;
            }
            
            // 현재 숫자가 최댓값보다 크면 최댓값 갱신
            if (num > max) {
                max = num;
            }
        }
        
        // 최솟값과 최댓값 출력
        System.out.println(min + " " + max);
        
        sc.close();
    }
}