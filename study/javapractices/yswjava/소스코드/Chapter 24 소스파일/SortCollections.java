package study.javapractices.yswjava.소스코드.Chapter

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

class SortCollections {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Toy", "Box", "Robot", "Weapon");
        list = new ArrayList<>(list);

        // ���� ���� ���       
        for(Iterator<String> itr = list.iterator(); itr.hasNext(); )
            System.out.print(itr.next() + '\t');
        System.out.println();

        // ����
        Collections.sort(list);        

        // ���� ���� ���
        for(Iterator<String> itr = list.iterator(); itr.hasNext(); )
            System.out.print(itr.next() + '\t');
        System.out.println();
    }
}