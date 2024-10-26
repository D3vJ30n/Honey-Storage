import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

class Main {
    public static String main(String s) throws IOException {
        String currentResult = s;
        String previousResult;

        // previousResult와 currentResult가 다를 때까지 반복
        do {
            previousResult = currentResult;
            BufferedReader br = new BufferedReader(new StringReader(currentResult));
            StringBuilder result = new StringBuilder();

            int value;
            for (value = br.read(); value != -1; value = br.read()) {
                char currentChar = (char) value;
                if (result.indexOf(String.valueOf(currentChar)) == -1) {
                    result.append(currentChar);
                }
            }
            currentResult = result.toString();

        } while (!previousResult.equals(currentResult));

        return currentResult;
    }
}