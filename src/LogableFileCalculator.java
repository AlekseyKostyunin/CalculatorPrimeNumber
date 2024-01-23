import util.LogConnector;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class LogableFileCalculator implements Calculable {
    private final Calculable calculable;

    public LogableFileCalculator(Calculable calculable) {
        this.calculable = calculable;
    }

    @Override
    public void sum(ComplexNumber a, ComplexNumber b) {
        calculable.sum(a, b);
        saveLog("Суммирую " + a.toString() + " " + b.toString() + "\n" + calculable.result());
    }

    @Override
    public void multiply(ComplexNumber a, ComplexNumber b) {
        calculable.multiply(a, b);
        saveLog("Умножаю " + a.toString() + " " + b.toString() + "\n" + calculable.result());
    }

    @Override
    public void subtraction(ComplexNumber a, ComplexNumber b) {
        calculable.subtraction(a, b);
        saveLog("Отнимаю " + a.toString() + " " + b.toString() + "\n" + calculable.result());
    }

    @Override
    public void devide(ComplexNumber a, ComplexNumber b) {
        calculable.devide(a, b);
        saveLog("Делю " + a.toString() + " " + b.toString() + "\n" + calculable.result());
    }

    @Override
    public String result() {
        return calculable.result();
    }

    public void saveLog(String data) {
        String time = new Date().toString();
        String string = time + ":\n" + data + "\n===========================================";
        try (FileWriter writer = new FileWriter(LogConnector.LOG_PATH, true)) {
            writer.write(string);
            writer.append('\n');
            //writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
