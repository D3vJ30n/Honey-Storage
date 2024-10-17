package study.javapractices.yswjava.소스코드.Chapter

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
 
import java.io.BufferedWriter;
import java.io.IOException;
 
class FinallyCase2 { 
    public static void main(String[] args) {
        Path file = Paths.get("C:\\javastudy\\Simple.txt");

        BufferedWriter writer = null;

        try {
            // �Ʒ� ���忡�� IOException �߻� ����
            writer = Files.newBufferedWriter(file);

            writer.write('A');     // IOException �߻� ����
            writer.write('Z');     // IOException �߻� ����
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(writer != null)
                    writer.close();     // IOException �߻� ����
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}