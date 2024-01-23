/**
 Abstraction describing the behavior of computing objects.
 */
public interface Calculable {
    void sum(ComplexNumber a, ComplexNumber b);
    void subtraction(ComplexNumber a, ComplexNumber b);
    void multiply(ComplexNumber a, ComplexNumber b);
    void devide(ComplexNumber a, ComplexNumber b);
    String result();
}
