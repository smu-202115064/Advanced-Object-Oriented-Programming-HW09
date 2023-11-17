public class Calculator {
    private State state;
    private int operand1;
    private int operand2;
    private char operator;
    private int result;

    public Calculator() {
        state = new Start(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public int getResult() {
        return result;
    }

    void processDigit(int digit) {
        state.processDigit(digit);
    }

    void processArithmeticOperator(char ch) {
        state.processArithmeticOperator(ch);
    }

    void processEqualOperator() {
        state.processEqualOperator();
    }
}
