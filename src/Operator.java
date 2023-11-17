public class Operator implements State {
    private Calculator calculator;

    public Operator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void processDigit(int digit) {
        calculator.setOperand2(digit);
        calculator.setState(new Operand2(calculator));
    }

    @Override
    public void processArithmeticOperator(char ch) {
        calculator.setOperator(ch);
    }
}
