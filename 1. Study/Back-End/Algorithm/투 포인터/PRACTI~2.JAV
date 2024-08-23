// Practice
// nums1 과 nums2 두 배열이 주어졌을 때
// 두 배열의 공통 원소를 배열로 반환하는 프로그램을 작성하세요.
// 결과 배열의 원소에는 중복 값이 없도록 하며 순서는 상관 없다.

// 입출력 예시
// nums1: 1, 2, 2, 1
// nums2: 2, 2
// 출력: 2

// nums1: 4, 9, 5
// nums2: 9, 4, 9, 8, 4
// 출력: 4, 9 (or 9, 4)

import java.util.Arrays;
import java.util.HashSet;

public class Practice2 {
    // 이 알고리즘의 시간 복잡도는 O(nlogn)입니다. 여기서 n은 더 긴 배열의 길이입니다.
    // 정렬에 O(nlogn)이 소요되고, 그 후의 순회는 O(n)입니다.
    public static int[] solution(int[] nums1, int[] nums2) {
        // HashSet을 사용하여 중복을 제거하고 교집합을 저장합니다.
        // HashSet의 추가, 검색, 삭제 연산은 평균적으로 O(1)의 시간 복잡도를 가집니다.
        HashSet<Integer> set = new HashSet<>();
        
        // Arrays.sort()는 기본적으로 퀵소트의 변형인 Dual-Pivot Quicksort를 사용합니다.
        // 평균 시간 복잡도는 O(nlogn)입니다.
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int p1 = 0;  // nums1의 포인터
        int p2 = 0;  // nums2의 포인터
        
        // 투 포인터 기법을 사용하여 두 배열을 동시에 순회합니다.
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                // nums1의 현재 원소가 작으면 nums1의 포인터만 증가
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                // nums2의 현재 원소가 작으면 nums2의 포인터만 증가
                p2++;
            } else {
                // 두 원소가 같으면 교집합에 해당하므로 HashSet에 추가
                set.add(nums1[p1]);
                // 양쪽 포인터 모두 증가
                p1++;
                p2++;
            }
        }
        
        // HashSet을 배열로 변환
        // 이 과정의 시간 복잡도는 O(n)입니다. 여기서 n은 교집합의 크기입니다.
        int[] result = new int[set.size()];
        int idx = 0;
        for (Integer n : set) {
            result[idx++] = n;
        }
        return result;
    }
    
    public static void main(String[] args) {
        // 테스트 코드
        // 각 테스트 케이스는 서로 다른 상황을 테스트합니다.
        
        // 케이스 1: 중복 원소가 있는 경우
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(solution(nums1, nums2)));  // [2] 출력 예상
        
        // 케이스 2: 한 배열이 다른 배열의 모든 원소를 포함하는 경우
        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(solution(nums1, nums2)));  // [4, 9] 출력 예상
        
        // 케이스 3: 교집합이 여러 개인 경우
        nums1 = new int[]{1, 7, 4, 9};
        nums2 = new int[]{7, 9};
        System.out.println(Arrays.toString(solution(nums1, nums2)));  // [7, 9] 출력 예상
    }
}