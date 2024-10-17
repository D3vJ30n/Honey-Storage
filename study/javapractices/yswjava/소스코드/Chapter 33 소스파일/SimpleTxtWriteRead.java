package study.javapractices.yswjava.소스코드.Chapter

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.util.Arrays;
import java.io.IOException;

class SimpleTxtWriteRead {
    public static void main(String[] args) throws IOException {
        Path fp = Paths.get("C:\\JavaStudy\\simple.txt");

        String st1 = "One Simple String";
        String st2 = "Two Simple String";
        List<String> lst1 = Arrays.asList(st1, st2);

        // ���Ͽ� ���� ������ ����
        Files.write(fp, lst1);
        
        // ���Ϸκ��� ���� ������ �б�
        List<String> lst2 = Files.readAllLines(fp);
        
        System.out.println(lst2);
    }
}

