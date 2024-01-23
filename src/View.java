import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {
    private final Calculable calculator;
    private final List<String> validOperators;

    public View(Calculable calculator) {
        this.calculator = calculator;
        this.validOperators = Arrays.stream(Operators.values())
                .map(Operators::operator)
                .collect(Collectors.toList());
    }

    public void run() {
        while (true) {
            prepare();
            String action = prompt();
            if (!action.equalsIgnoreCase("y")) {
                System.exit(0);
            }
        }
    }

    private void prepare() {
        double real1 = promptInt("Введите вещественную часть первого числа: ");
        double img1 = promptInt("Введите мнимую часть первого числа: ");
        ComplexNumber number1 = new ComplexNumber(real1, img1);
        String operator = getOperator();
        double real2 = promptInt("Введите вещественную часть второго числа: ");
        double img2 = promptInt("Введите мнимую часть второго числа: ");
        ComplexNumber number2 = new ComplexNumber(real2, img2);
        if (operator.equals("+")) {
            calculator.sum(number1, number2);
        }
        if (operator.equals("-")) {
            calculator.subtraction(number1, number2);
        }
        if (operator.equals("*")) {
            calculator.multiply(number1, number2);
        }
        if (operator.equals("/")) {
            calculator.devide(number1, number2);
        }
        System.out.println(calculator.result());
    }

    private String prompt() {
        Scanner in = new Scanner(System.in);
        System.err.println("Продолжить?... (y/n)");
        return in.nextLine();
    }

    private String getOperator() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите математический оператор (*, +, /, -) : ");
        String operator = in.nextLine();
        while (true) {
            if (isInvalidOperator(operator)) {
                System.err.println("Введен неверный оператор. " + "Введите математический оператор из предложенных (*, +, /, -) : ");
                operator = in.nextLine();
            } else return operator;
        }
    }

    private boolean isInvalidOperator(String operator) {
        return !validOperators.contains(operator);
    }

    private  int promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        int result = -1;
        try {
            result = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Не является числом. Пожалуйста, введите число.");
            promptInt(message);
        }
        return result;
    }
}
