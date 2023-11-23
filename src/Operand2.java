public class Operand2 implements State {
    Calculator calc;

    public Operand2(Calculator calc) {
        this.calc = calc;
    }
    public void processDigit(int digit) {
        calc.setOperand2(digit);
    }

    public void processEqualOperator() {
        calc.changeToStart();
    }
}