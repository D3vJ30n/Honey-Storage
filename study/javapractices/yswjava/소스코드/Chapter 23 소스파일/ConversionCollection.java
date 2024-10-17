package study.javapractices.yswjava.소스코드.Chapter

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Arrays;

class ConversionCollection {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Toy", "Box", "Robot", "Box");
        list = new ArrayList<>(list);

        // ArrayList<E> �ν��Ͻ��� ��ȯ
        for(Iterator<String> itr = list.iterator(); itr.hasNext(); )
            System.out.print(itr.next() + '\t');
        System.out.println();

        // ArrayList<E>�� LinkedList<E>�� ��ȯ
        list = new LinkedList<>(list);

        // LinkedList<E> �ν��Ͻ��� ��ȯ
        for(Iterator<String> itr = list.iterator(); itr.hasNext(); )
            System.out.print(itr.next() + '\t');
        System.out.println();
    }
}