package study.javapractices.yswjava.소스코드.Chapter

import java.util.Arrays;

class CopyOfArrays {
    public static void main(String[] args) {
        double[] arOrg = {1.1, 2.2, 3.3, 4.4, 5.5};
     
        // �迭 ��ü�� �����Ͽ� �迭 ����
        double[] arCpy1 = Arrays.copyOf(arOrg, arOrg.length);
        
        // �迭�� ����° ��ұ����� �����Ͽ� �迭 ���� 
        double[] arCpy2 = Arrays.copyOf(arOrg, 3);


        for(double d : arCpy1)
            System.out.print(d + "\t");
        System.out.println();


        for(double d : arCpy2)
            System.out.print(d + "\t");
        System.out.println();

    }
}