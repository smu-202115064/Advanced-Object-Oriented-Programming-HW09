public class Operator implements State {
    Calculator calc;

    public Operator(Calculator calc) {
        this.calc = calc;
    }
    public void processDigit(int digit) {
        calc.setOperand2(digit);
        calc.changeToOperand2();
    }

    public void processArithmeticOperator(char ch) {
        calc.setOperator(ch);
    }
}