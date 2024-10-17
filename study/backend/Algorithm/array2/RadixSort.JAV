import java.util.ArrayList;
import java.util.Arrays;
import java.util.study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList;
import java.util.Queue;

public class RadixSort {

    // 기수 정렬의 메인 함수
    public static void radixSort(int[] arr) {
        // 0부터 9까지의 숫자를 저장할 큐 리스트 생성
        ArrayList<Queue<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList<>());
        }

        int maxLen = getMaxLen(arr);
        int div = 1;  // 현재 처리 중인 자릿수를 나타내는 제수

        // 가장 긴 숫자의 자릿수만큼 반복
        for (int digit = 0; digit < maxLen; digit++) {
            // 각 숫자를 해당 자릿수에 맞는 버킷에 분배
            for (int num : arr) {
                int bucketIndex = (num / div) % 10;
                buckets.get(bucketIndex).offer(num);
            }

            // 버킷에서 숫자를 순서대로 꺼내어 배열에 재배치
            int arrIndex = 0;
            for (Queue<Integer> bucket : buckets) {
                while (!bucket.isEmpty()) {
                    arr[arrIndex++] = bucket.poll();
                }
            }

            // 다음 자릿수로 이동
            div *= 10;
        }
    }

    // 배열에서 가장 긴 숫자의 자릿수를 반환하는 함수
    public static int getMaxLen(int[] arr) {
        int maxLen = 0;
        for (int num : arr) {
            int len = (int) Math.log10(num) + 1;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        System.out.println("정렬 전: " + Arrays.toString(arr));

        radixSort(arr);

        System.out.println("기수 정렬 후: " + Arrays.toString(arr));
    }
}