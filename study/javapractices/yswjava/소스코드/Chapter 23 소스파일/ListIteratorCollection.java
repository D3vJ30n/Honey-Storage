package study.javapractices.yswjava.소스코드.Chapter

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Arrays;

class ListIteratorCollection {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Toy", "Box", "Robot", "Box");
        list = new ArrayList<>(list);
       
        ListIterator<String> litr = list.listIterator();
        String str; 

        // ���ʿ��� ���������� 
        while(litr.hasNext()) {
            str = litr.next();
            System.out.print(str + '\t');

            if(str.equals("Toy"))
                litr.add("Toy2");
        }
        System.out.println();
        
        // �����ʿ��� ��������

        while(litr.hasPrevious()) {
            str = litr.previous();
            System.out.print(str + '\t');

            if(str.equals("Robot"))
                litr.add("Robot2");
        }
        System.out.println();

        // �ٽ� ���ʿ��� ����������
        for(Iterator<String> itr = list.iterator(); itr.hasNext(); )
            System.out.print(itr.next() + '\t');
        System.out.println();
    }
}