import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class test {
    @Test
    public void testNumberSetterValid() {
        String validNum = "801-702-6650";
        Person person = new Person();
        boolean b = person.setPhone(validNum);
        if (b){
            System.out.println("Successful Valid Number Test");
        }
        assertTrue(b);

    }

    @Test
    public void testNumberSetterInvalid() {
        String invalidNum = "801-7026650";
        Person person = new Person();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->{
            person.setPhone(invalidNum);
        });
        String expectedMessage = "You must enter a valid # format\nex: 123-456-7890";
        String actual = exception.getMessage();
        if (actual.contains(expectedMessage)){
            System.out.println("Invalid Phone Number Test Successful");
        }
        assertTrue(actual.contains(expectedMessage));

    }
}
