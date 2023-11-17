public class Operand2 implements State {
    private Calculator calculator;

    public Operand2(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void processDigit(int digit) {
        calculator.setOperand2(calculator.getOperand2() * 10 + digit);
    }

    @Override
    public void processEqualOperator() {
        calculator.calculate();
        calculator.setState(new Start(calculator));
    }
}
