import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 문자열 입력받기
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase();
        char targetChar = sc.next().toUpperCase().charAt(0);

        // 문자의 개수를 저장할 변수
        int count = 0;

        // 문자열을 순회하며 targetChar의 개수를 셈
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == targetChar) {
                count++;
            }
        }
        System.out.println(targetChar + count);
    }
}