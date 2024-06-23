import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {

    public static void main(String[] args) {

        String fileName = "D:/JavaNew/file.txt";


        validateAndPrintPhoneNumbers(fileName);
    }

    public static void validateAndPrintPhoneNumbers(String fileName) {

        String pattern1 = "\\(\\d{3}\\) \\d{3}-\\d{4}";
        String pattern2 = "\\d{3}-\\d{3}-\\d{4}";


        String combinedPattern = "(" + pattern1 + ")|(" + pattern2 + ")";
        Pattern pattern = Pattern.compile(combinedPattern);

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {

                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла " + e.getMessage());
        }
    }
}
