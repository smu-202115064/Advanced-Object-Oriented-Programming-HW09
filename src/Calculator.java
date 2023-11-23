public class Calculator {
    State state;
    State operand1;
    State operand2;
    State operator;
    State start;
    String operand1Str;
    String operand2Str;
    char op;
    int op1, op2, result;

    public Calculator() {
        start = new Start(this);
        operand1 = new Operand1(this);
        operand2 = new Operand2(this);
        operator = new Operator(this);
        state = start;
        init();
    }

    public void processDigit(int digit) {
        state.processDigit(digit);
    }

    public void processArithmeticOperator(char ch) {
        state.processArithmeticOperator(ch);
    }

    public void processEqualOperator() {
        state.processEqualOperator();
    }

    public void setOperand1(int digit) {
        operand1Str += digit;
    }

    public void setOperand2(int digit) {
        operand2Str += digit;
    }

    public void changeToOperand1() {
        state = operand1;
    }

    public void changeToOperand2() {
        state = operand2;
    }

    public void changeToOperator() {
        state = operator;
    }

    public void changeToStart() {
        op1 = Integer.parseInt(operand1Str);
        op2 = Integer.parseInt(operand2Str);
        switch (op) {
            case '+':
                result = op1 + op2;
                break;
            case '-':
                result = op1 - op2;
                break;
            case '*':
                result = op1 * op2;
                break;
            case '/':
                result = op1 / op2;
                break;
            case '%':
                result = op1 % op2;
                break;
        }
        state = start;
        init();
    }

    public void setOperator(char ch) {
        this.op = ch;
    }

    public int getResult() {
        return result;
    }

    public int getOp1() {
        return op1;
    }

    public int getOp2() {
        return op2;
    }

    public int getOp() {
        return op;
    }

    private void init() {
        operand1Str = "";
        operand2Str = "";
    }
}
