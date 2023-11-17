public class Operand1 implements State {
    private Calculator calculator;

    public Operand1(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void processDigit(int digit) {
        calculator.setOperand1(calculator.getOperand1() * 10 + digit);
    }
}
