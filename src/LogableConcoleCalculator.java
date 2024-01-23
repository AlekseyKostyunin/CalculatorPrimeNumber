public class LogableConcoleCalculator implements Calculable {
    private final Calculable calculable;

    public LogableConcoleCalculator(Calculable calculable) {
        this.calculable = calculable;
    }

    @Override
    public void sum(ComplexNumber a, ComplexNumber b) {
        System.out.println(String.format("Суммирую %s и %s", a, b));
        calculable.sum(a, b);
    }

    @Override
    public void multiply(ComplexNumber a, ComplexNumber b) {
        System.out.println(String.format("Умножаю %s и %s", a, b));
        calculable.multiply(a, b);
    }

    @Override
    public void devide(ComplexNumber a, ComplexNumber b) {
        System.out.println(String.format("Делю %s и %s", a, b));
        calculable.devide(a, b);
    }

    @Override
    public void subtraction(ComplexNumber a, ComplexNumber b) {
        System.out.println(String.format("Отнимаю %s и %s", a, b));
        calculable.subtraction(a, b);
    }

    @Override
    public String result() {
        return calculable.result();
    }

}
