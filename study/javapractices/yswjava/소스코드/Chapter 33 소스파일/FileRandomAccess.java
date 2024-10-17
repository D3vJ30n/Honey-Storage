package study.javapractices.yswjava.소스코드.Chapter

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

class FileRandomAccess {
    public static void main(String[] args) {
        Path fp = Paths.get("data.dat");

        // ���� ����
        ByteBuffer wb = ByteBuffer.allocate(1024);

        // ���ۿ� ������ ����
        wb.putInt(120);
        wb.putInt(240);
        wb.putDouble(0.94);
        wb.putDouble(0.75);

        // �ϳ��� ä�� ���� 
        try(FileChannel fc = FileChannel.open(fp, 
                               StandardOpenOption.CREATE, 
                               StandardOpenOption.READ, 
                               StandardOpenOption.WRITE)) {
            // ���Ͽ� ����
            wb.flip(); 
            fc.write(wb);   

            // ���Ϸκ��� �б�
            ByteBuffer rb = ByteBuffer.allocate(1024);
            fc.position(0);    // ä���� �������� �� ������ �̵�
            fc.read(rb);
            
            // ���� ���۷κ��� ������ �б�
            rb.flip();
            System.out.println(rb.getInt());
            rb.position(Integer.BYTES * 2);    // ������ ������ �̵�

            System.out.println(rb.getDouble());
            System.out.println(rb.getDouble());

            rb.position(Integer.BYTES);    // ������ ������ �̵�
            System.out.println(rb.getInt()); 
        } catch(IOException e) {
            e.printStackTrace();       
        }
    }
}