public class Start implements State {
    private Calculator calculator;

    public Start(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void processDigit(int digit) {
        calculator.setOperand1(digit);
        calculator.setState(new Operand1(calculator));
    }
}
