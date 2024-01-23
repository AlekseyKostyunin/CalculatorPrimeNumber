import java.util.Scanner;
import static util.LogConnector.createLogFile;

public class Start {
    public static void run(){
        int v = getTypeLogging();
        if(v == 1){
           View view = new View(new LogableConcoleCalculator(new Calculator()));
           view.run();
        }
        else {
            createLogFile();
            View view = new View(new LogableFileCalculator(new Calculator()));
            view.run();
        }
    }

    private static int getTypeLogging() {
        Scanner in = new Scanner(System.in);
        System.out.println("Выберите способ логирования операций:");
        System.out.println("1 - в консоль");
        System.out.println("2 - в файл logging.txt");
        int type = Integer.parseInt(in.nextLine());
        while (true) {
            if (type != 1 && type != 2 ) {
                System.err.println("Введен неверный способ. " + "Введите способ логирования операций из предложенных : 1 или 2");
                type = Integer.parseInt(in.nextLine());
            } else return type;
        }
    }
}
