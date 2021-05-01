package lambdaInfo;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        ISum summer = new ISum() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };

        //выхоит что то типа f(x1, x2) = a * x1 + b * x2 -как в матике было
        ISum summer2 = (a, b) -> a + b;

        //если нужна какая-то логика и лямбда получается не в одну строчку, то можно это указать в фигурных скобках:
        ISum summer3 = (a, b) -> {
            if (a == 0) return 0;
            return a + b;
        };
        //когда один аргумент, скобочки не обязательны:
        //  ISqrt sqrt = (x) -> Math.sqrt(x);
        ISqrt sqrt = x -> Math.sqrt(x);

        //про двойное :: вместо того что бы расписывать как выше, достаточно сделать как ниже, так как выше мы вызываем такую же функцию как и наша
        ISqrt sqrt1 = Math::sqrt;

        //// лямбда и анонимные классы

        final Consumer<String> printer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);

            }
        };
        printer.accept("hello");
    }

    //функц инте - содержит один не реализованный метод
    @FunctionalInterface
    public interface ISum {
        public int sum(int a, int b);
    }

    @FunctionalInterface
    public interface ISqrt {
        //по дефолту получается public, см выше, он серый
        double sqrt(double x);
    }
}
