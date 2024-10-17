package study.backend.javapractice.solution.lineards11.src;

import java.util.ArrayDeque;
import java.util.Deque;

public class Practice2 {
    public static boolean checkPalindrome(String str) {
        // ArrayDeque를 사용하여 Deque 생성
        // Deque: 양쪽 끝에서 요소를 추가하거나 제거할 수 있는 자료구조
        // 이를 통해 문자열의 앞뒤를 효율적으로 비교할 수 있음
        // Deque 사용 이유:
        // 1. 양쪽에서 효율적으로 요소를 추가/제거할 수 있어 Palindrome 체크에 적합
        // 2. ArrayList나 LinkedList보다 더 나은 성능을 제공
        Deque<String> deque = new ArrayDeque<>();

        // isPalindrome 변수: Palindrome 여부를 저장
        // 초기값을 true로 설정하고, 불일치 발견 시 false로 변경
        // 이 방식을 사용하면 모든 문자가 일치할 경우 true를 유지
        boolean isPalindrome = true;

        // 입력 문자열을 개별 문자로 분리하여 Deque의 앞쪽에 추가
        // split(""): 문자열을 개별 문자로 분리
        // addFirst(): Deque의 앞쪽에 요소 추가
        // 이렇게 하면 원래 문자열의 순서가 Deque에서 뒤집힘
        // 문자열 처리 방식:
        // 1. 문자열을 역순으로 저장하여 비교를 용이하게 함
        // 2. 양 끝에서 동시에 비교하는 방식으로 시간 복잡도를 O(n/2)로 줄임
        for (String s : str.split("")) {
            deque.addFirst(s);
        }

        // Deque가 비어있지 않은 동안 반복
        // Palindrome 체크 로직:
        // 1. Deque의 앞과 뒤에서 동시에 문자를 제거하며 비교
        // 2. 불일치 발견 시 즉시 반복 중단
        while (!deque.isEmpty()) {
            // pollFirst(): Deque의 앞에서 요소를 제거하고 반환
            // pollLast(): Deque의 뒤에서 요소를 제거하고 반환
            String s1 = deque.pollFirst();
            String s2 = deque.pollLast();

            // s1과 s2가 모두 null이 아니고 (Deque에 요소가 남아있음을 의미),
            // 두 문자가 다르다면 Palindrome이 아님
            // 예외 처리: 
            // 1. null 체크로 Deque가 비어있는 경우를 처리
            // 2. 불일치 발견 시 즉시 false 반환으로 불필요한 비교 방지
            if (s1 != null && s2 != null && !s1.equals(s2)) {
                isPalindrome = false;
                break;  // 불일치 발견 시 즉시 반복 중단
            }
        }

        // 최종 결과 반환
        // 모든 비교가 일치했다면 true, 하나라도 불일치했다면 false
        return isPalindrome;
    }

    public static void main(String[] args) {
        // 다양한 케이스에 대한 테스트 코드
        // 테스트 케이스:
        // 1. 다양한 길이(홀수/짝수)의 문자열 테스트
        // 2. Palindrome인 경우와 아닌 경우 모두 테스트
        // 3. 단일 문자에 대한 테스트 포함
        System.out.println(checkPalindrome("a"));       // true (단일 문자는 항상 Palindrome)
        System.out.println(checkPalindrome("aba"));     // true
        System.out.println(checkPalindrome("abba"));    // true
        System.out.println(checkPalindrome("abab"));    // false
        System.out.println(checkPalindrome("abcba"));   // true
        System.out.println(checkPalindrome("abccba"));  // true
        System.out.println(checkPalindrome("madam"));   // true
    }
}