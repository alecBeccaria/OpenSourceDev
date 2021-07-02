public class Calculator {

    public void menu() {
        String operator = ConsoleIO.promptForString("Enter operator to apply to values\nex. +, -, *, /\nor enter anything else to exit program: ");
        int firstValue;
        int secondValue;

        int value;

        switch (operator) {
            case "+" -> {
                firstValue = ConsoleIO.promptForInt("Enter First Value: ", 0, 9999);
                secondValue = ConsoleIO.promptForInt("Enter Second Value: ", 0, 9999);
                value = addition(firstValue, secondValue);
                System.out.println(firstValue + " " + operator + " " + secondValue + " = " + value + "\n");
                menu();
            }
            case "-" -> {
                firstValue = ConsoleIO.promptForInt("Enter First Value: ", 0, 9999);
                secondValue = ConsoleIO.promptForInt("Enter Second Value: ", 0, 9999);
                value = subtraction(firstValue, secondValue);
                System.out.println(firstValue + " " + operator + " " + secondValue + " = " + value + "\n");
                menu();
            }
            case "*" -> {
                firstValue = ConsoleIO.promptForInt("Enter First Value: ", 0, 9999);
                secondValue = ConsoleIO.promptForInt("Enter Second Value: ", 0, 9999);
                value = multiplication(firstValue, secondValue);
                System.out.println(firstValue + " " + operator + " " + secondValue + " = " + value + "\n");
                menu();
            }
            case "/" -> {
                float firstFloat = ConsoleIO.promptForFloat("Enter First Value: ", 0, 9999);
                float secondFloat = ConsoleIO.promptForFloat("Enter Second Value: ", 0, 9999);
                float floatValue = division(firstFloat, secondFloat);
                System.out.println(firstFloat + " " + operator + " " + secondFloat + " = " + floatValue + "\n");
                menu();
            }
            default -> {
                System.out.println("Not a valid operator, exiting");
            }
        }
    }
    public int addition(int firstValue, int secondValue) {
        return firstValue + secondValue;

    }

    public int subtraction(int firstValue, int secondValue) {
        return firstValue - secondValue;
    }

    public int multiplication(int firstValue, int secondValue){
        return firstValue * secondValue;
    }

    public float division (float firstValue, float secondValue){
        return firstValue / secondValue;
    }
}

