public class ComplexNumber {

    private final double real; // вещественная часть числа
    private final double imaginary; // мнимая часть числа
    //private ComplexNumber result;

    ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

       @Override
    public String toString() {
        return "ComplexNumber{" +
                "real=" + real +
                ", imaginary=" + imaginary +
                '}';
    }
}
