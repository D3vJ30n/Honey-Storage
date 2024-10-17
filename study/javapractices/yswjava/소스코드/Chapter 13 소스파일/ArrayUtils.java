package study.javapractices.yswjava.소스코드.Chapter

import java.util.Arrays;

class ArrayUtils {
    public static void main(String[] args) {
        int[] ar1 = new int[10];
        int[] ar2 = new int[10];
        
        // �迭 ar1�� 7�� �ʱ�ȭ
        Arrays.fill(ar1, 7);
        
        // �迭 ar1�� ar2�� �κ� ����
        System.arraycopy(ar1, 0, ar2, 3, 4);
        
        for(int i = 0; i < ar1.length; i++)
            System.out.print(ar1[i] + " ");
        
        System.out.println();    // �ܼ� �� �ٲ�

        for(int i = 0; i < ar2.length; i++)
            System.out.print(ar2[i] + " ");

    }
}