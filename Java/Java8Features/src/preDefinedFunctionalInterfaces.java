import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class function implements Function<String,Integer>{

    @Override
    public Integer apply(String s) {
        return s.length();
    }
}
class biFunctionInterface implements BiFunction<Integer,Integer,Integer>{

    @Override
    public Integer apply(Integer integer, Integer integer2) {
        return integer+integer2;
    }
}
class supplier implements Supplier<String>{

    @Override
    public String get() {
        return "Hello I'm Supplier\n";
    }
}
public class preDefinedFunctionalInterfaces {
    public static void main(String[] args) {
        Function<String,Integer> stringIntegerFunction=new function();
        System.out.println(stringIntegerFunction.apply("CountMe"));
//        lambdaExpression
        Function<String,Integer> stringIntegerFunctionLambda=(string)->string.length();
        System.out.println(stringIntegerFunctionLambda.apply("CountMe"));

        BiFunction<Integer,Integer,Integer> biFunction=new biFunctionInterface();
        System.out.println(biFunction.apply(10, 20));
//        lambdaExpression
        BiFunction<Integer,Integer,Integer> biFunctionLambdaExp=(a,b)->a+b;
        System.out.println(biFunctionLambdaExp.apply(10, 20));

        Supplier<String>supplier=new supplier();
        System.out.printf(supplier.get());
//        LambdaExpression
        Supplier<String> supplierLambdaExp=()-> "Hello I'm Lambda Supplier";
        System.out.println(supplierLambdaExp.get());

    }

}
