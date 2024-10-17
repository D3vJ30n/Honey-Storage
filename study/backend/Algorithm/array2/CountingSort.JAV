import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class CountingSort {

    public static void countingSort(int[] arr) {
        // 방법 1: 일반 배열 사용
        countingSortUsingArray(arr);

        // 방법 2: HashMap 사용
        countingSortUsingHashMap(arr);
    }

    // 일반 배열을 사용한 계수 정렬
    private static void countingSortUsingArray(int[] arr) {
        // 배열에서 최대값을 찾아 카운트 배열의 크기 결정
        int max = Arrays.stream(arr).max().getAsInt();
        int[] countArr = new int[max + 1];

        // 각 요소의 출현 횟수를 카운트
        for (int num : arr) {
            countArr[num]++;
        }

        // 카운트 배열을 기반으로 원래 배열 재구성
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0) {
                arr[index++] = i;
                countArr[i]--;
            }
        }
    }

    // HashMap을 사용한 계수 정렬
    private static void countingSortUsingHashMap(int[] arr) {
        // 각 요소의 출현 횟수를 HashMap에 저장
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // HashMap의 키(정렬할 숫자들)를 정렬
        ArrayList<Integer> sortedKeys = new ArrayList<>(countMap.keySet());
        Collections.sort(sortedKeys);

        // 정렬된 키와 그 출현 횟수를 기반으로 원래 배열 재구성
        int index = 0;
        for (int key : sortedKeys) {
            int count = countMap.get(key);
            while (count > 0) {
                arr[index++] = key;
                count--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 32, 10, 27, 32, 17, 99, 56};
        System.out.println("정렬 전: " + Arrays.toString(arr));

        countingSort(arr);

        System.out.println("계수 정렬 후: " + Arrays.toString(arr));
    }
}