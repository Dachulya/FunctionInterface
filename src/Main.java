import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Predicate<Number> numberPredicate = new Predicate<Number>() {
            @Override
            public boolean test(Number number) {
                return number.doubleValue() > 0;
            }
        };
        int a = 5;
        System.out.println(numberPredicate.test(a));

        numberPredicate = number -> number.doubleValue() > 0;

        Consumer<String> stringConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Привет " + s);
            }
        };
        String t = "ТОП";
        stringConsumer.accept(t);

        stringConsumer = s -> System.out.println("Привет " + s);

        Function<Double, Long> doubleLongFunction = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        doubleLongFunction = Double::longValue;

        Supplier<Double> doubleSupplier = new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random() * 100;
            }
        };

        doubleSupplier = () -> Math.random() * 100;

        Function<Double, Long> function = d -> -d.longValue();
        Function<Double, Long> absAndRound = ternaryOperator(numberPredicate, doubleLongFunction, function);
        System.out.println(absAndRound.apply(-45.5));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);//двоеточие это else
    }

}