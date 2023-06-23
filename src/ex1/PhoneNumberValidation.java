package ex1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidation {
    public void validation() {
        Pattern pattern1 = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}");
        Pattern pattern2 = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        try (BufferedReader reader = new BufferedReader(new FileReader("text.txt"))) {
            String line;
            while ((line=reader.readLine()) != null ) {
                Matcher matcher1 = pattern1.matcher(line);
                Matcher matcher2 = pattern2.matcher(line);
                if (matcher1.find() || matcher2.find()) {
                    System.out.println(line);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
