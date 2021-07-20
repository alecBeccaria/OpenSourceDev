import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Phone Number (with hyphens): ");
            String input = br.readLine();
            Person person = new Person();
            person.setPhone(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
