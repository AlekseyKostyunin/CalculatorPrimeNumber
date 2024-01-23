public final class Calculator implements Calculable {
    private ComplexNumber result;

    @Override
    public void sum(ComplexNumber a, ComplexNumber b) {
        double a1 = a.getReal() + b.getReal();
        double b1 = a.getImaginary() + b.getImaginary();
        result = new ComplexNumber(a1, b1);
    }

    @Override
    public void subtraction(ComplexNumber a, ComplexNumber b) {
        double a1 = a.getReal() - b.getReal();
        double b1 = a.getImaginary() - b.getImaginary();
        result = new ComplexNumber(a1, b1);
    }

    @Override
    public void multiply(ComplexNumber a, ComplexNumber b) {
        double buf = a.getReal();
        double a1 = a.getReal() * b.getReal() - a.getImaginary() * b.getImaginary();
        double b1 = buf * b.getImaginary() + a.getImaginary() * b.getReal();
        result = new ComplexNumber(a1, b1);
    }

    @Override
    public void devide(ComplexNumber a, ComplexNumber b) {
        double a1 = (a.getReal() * b.getReal() + a.getImaginary() * b.getImaginary()) / b.getReal() * b.getReal() + b.getImaginary() * b.getImaginary();
        double b1 = (a.getImaginary() * b.getReal() - a.getReal() * b.getImaginary()) / b.getReal() * b.getReal() + b.getImaginary() * b.getImaginary();
        result = new ComplexNumber(a1, b1);
    }

    @Override
    public String result() {
        return "Результат: комплексное число: " + result.getReal() + "i " + "+ (" + result.getImaginary() + ")";
    }

}
