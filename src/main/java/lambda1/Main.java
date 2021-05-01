package lambda1;

import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
    //    Calculator calc = new Calculator();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        //деление на ноль, так как b = 1 - 1, решение допилил в классе калькулятор через return
        int c = calc.devide.apply(a, b);

        calc.println.accept(c);

    }


}
