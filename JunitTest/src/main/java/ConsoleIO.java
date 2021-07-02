import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleIO {

    public static String promptForString(String prompt) {
        return promptForString(prompt, false);
    }

    public static String promptForString(String prompt, boolean allowBlank) {
        if (prompt == null || prompt.isBlank()) {
            throw new IllegalArgumentException("The Prompt cannot be null, empty, or white");
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        boolean inputIsInvalid = true;

        do {
            System.out.print(prompt);
            try {
                input = br.readLine();
                inputIsInvalid = input == null || (!allowBlank && input.isBlank());
                if (inputIsInvalid) {
                    System.out.println("Your input was invalid.  Please try again.");

                }
            } catch (IOException ioe) {
                System.out.println("It broke");
            }
        } while (inputIsInvalid);

        return input;
    }

    public static float promptForFloat(String prompt, int min, int max){
        if(min > max){
            throw new IllegalArgumentException("The min cannot be greater than the max" + "min="
                    + min + "; max=" + max);
        }

        float num = -1;
        boolean numIsInvalid = true;

        do{
            String input = promptForString(prompt, false);
            try{
                num = Float.parseFloat(input);
                numIsInvalid = num < min || num > max;
            }catch(NumberFormatException nfe){

            }

            if(numIsInvalid){
                System.out.println("You must enter a whole number between " + min + " and "
                        + max + ".  Please, try again.");
            }
        }while (numIsInvalid);
        return num;
    }

    public static int promptForInt(String prompt, int min, int max){
        if(min > max){
            throw new IllegalArgumentException("The min cannot be greater than the max" + "min="
                    + min + "; max=" + max);
        }

        int num = -1;
        boolean numIsInvalid = true;

        do{
            String input = promptForString(prompt, false);
            try{
                num = Integer.parseInt(input);
                numIsInvalid = num < min || num > max;
            }catch(NumberFormatException nfe){

            }

            if(numIsInvalid){
                System.out.println("You must enter a whole number between " + min + " and "
                        + max + ".  Please, try again.");
            }
        }while (numIsInvalid);
        return num;
    }
}
