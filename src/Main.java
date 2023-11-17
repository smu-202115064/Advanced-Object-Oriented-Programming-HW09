import java.util.Scanner;

// 입력된 문자 ch가 0~9까지의 숫자를 나타내는 문자인 경우, ch - '0'으로 0~9까지의 정수로 변환 가능
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calculator calculator = new Calculator();

        char ch = sc.next().charAt(0);      // 키보드에서 한 글자 입력 받기
        while (ch != 'q' && ch != 'Q') {    // 종료 문자가 아니면 반복
            if (ch >= '0' && ch <= '9') {
                calculator.processDigit(ch - '0');
            }
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%') {
                calculator.processArithmeticOperator(ch);
            }
            else if (ch == '=') {
                calculator.processEqualOperator();
                System.out.printf("%d %c %d = %d\n", calculator.getOperand1(), calculator.getOperator(), calculator.getOperand2(), calculator.getResult());
                calculator.setOperand1(0);
                calculator.setOperand2(0);
            }
            else {
                System.out.println("invalid operation");
            }
            ch = sc.next().charAt(0);
        }
    }
}
