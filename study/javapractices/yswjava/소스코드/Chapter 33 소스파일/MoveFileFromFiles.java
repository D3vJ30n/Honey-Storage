package study.javapractices.yswjava.소스코드.Chapter

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.IOException;

class MoveFileFromFiles {
    public static void main(String[] args) throws IOException {
        Path src = Paths.get("C:\\JavaStudy\\Dir1");
        Path dst = Paths.get("C:\\JavaStudy\\Dir2");
        
        // src�� �����ϴ� ���丮�� dst�� �����ϴ� ���丮�� �̵�
        Files.move(src, dst, StandardCopyOption.REPLACE_EXISTING);
    }
}

