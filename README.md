# 실습과제 #09

## 과제 설명

* 간단한 산술 연산이 가능한 계산기 프로그램을 스테이트 패턴을 이용해서 구현
  * 정수 범위 내에 있는 숫자는 계산 가능
  * 사칙 연산과 나머지 연산(+, -, *, /, %)

* State Machine

    ```mermaid
    flowchart

    Start((Start))
    Operand1((Operand1))
    Operand2((Operand2))
    Operator((Operator))
    
    Start --"digit<br>(0~9)"--> Operand1
    Operand1 --"operator<br>(+,-,*,/,%)"--> Operator
    Operator --"digit<br>(0~9)"--> Operand2
    Operand2 --"operator<br>(=)"--> Start
    
    Operand1 --"digit<br>(0~9)"--> Operand1
    Operator --"operator<br>(+,-,*,/,%)"--> Operator
    Operand2 --"digit<br>(0~9)"--> Operand2
    ```

* 상태에서 다른 상태로의 이동은 설명 내용에 해당되는 입력이 들어올 때 일어나며, 사용자는 숫자(들), 산술 연산자, 숫자(들), '=' 순서로 정확하게 입력한다고 가정할 것.

    | 상태 | 설명                                                              |
    | --- |-----------------------------------------------------------------|
    | Start | 시작 상태, 피연산자 2개를 저장하는 변수는 0으로 초기화                                |
    | Operand1 | 첫 번째 피연산자 입력 상태                                                 |
    | Operator | 연산자 입력 상태.<br>Operator 상태에서 다시 연산자가 입력되면 기존 연산자를 덮어 씀(overwrite) |
    | Operand2 | 두 번째 피연산자 입력 상태<br>'='가 입력되면 결과값을 계산해서 저장한 후 Start 상태로 이동       |

* State 인터페이스

    ```mermaid
    classDiagram

    class State {
        <<interface>>
        + void processDigit(int digit)
        + void processArithmeticOperator(char ch)
        + void processEqualOperator()
    }
    ```

* Main 클래스

  * 주어진 코드를 완성
  * 사용자로부터 한 글자씩 입력받고 숫자, 산술 연산자, '=', 'q', 'Q'가 아닌 다른 글자가 입력되면 "invalid input" 을 출력하고 계속 실행
  * 'q'나 'Q'를 입력하면 프로그램 중단
  * '='를 입력받으면 상태 기계를 이용해서 계산 후, 결과를 다음 형태로 출력한 후 계산기를 초기화(객체를 새로 생성하는 것이 아니라, Calculator 객체 내부의 피연산자나 결과값을 0으로 초기화하고 새로 계산할 수 있도록 함

    > 숫자 연산자 숫자 = 결과값

* 출력 예시
    ```text
    2
    3
    +
    3
    2
    4
    =
    23 + 324 = 347
    3
    2
    *
    3
    =
    32 * 3 = 96
    ```
