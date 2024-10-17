package study.javapractices.yswjava.소스코드.Chapter

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
 
import java.io.BufferedWriter;
import java.io.IOException;
 
class IOExceptionCase2 { 
    public static void main(String[] args) {
        Path file = Paths.get("C:\\javastudy\\Simple.txt");
        BufferedWriter writer = null;
        writer = Files.newBufferedWriter(file);     // IOException �߻� ����
        writer.write('A');     // IOException �߻� ����
        writer.write('Z');     // IOException �߻� ����

        if(writer != null)
            writer.close();     // IOException �߻� ����  
    }
}