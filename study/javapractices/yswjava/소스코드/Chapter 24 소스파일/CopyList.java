package study.javapractices.yswjava.소스코드.Chapter

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class CopyList {
    public static void main(String[] args) {
        List<String> src = Arrays.asList("Box", "Apple", "Toy", "Robot");

        // ���纻�� ���� ���        
        List<String> dest = new ArrayList<>(src);

        // �����Ͽ� �� ����� ���
        Collections.sort(dest);
        System.out.println(dest);

        // ������ ���� ������ ���·� �ǵ����� ��
        Collections.copy(dest, src);

        // �ǵ��� Ȯ��
        System.out.println(dest);
    }
}