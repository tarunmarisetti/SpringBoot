import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

interface Printable{
    void print(String msg);
}
public class methodReference {
    public static int Addition(int a, int b) {
        return a + b;
    }
    public void display(String msg){
        System.out.println(msg.toUpperCase());
    }

    public static void main(String[] args) {
//        Type 1: method reference to a static method of a class

        BiFunction<Integer,Integer,Integer> add=(a,b)->methodReference.Addition(a,b);
        System.out.println(add.apply(10, 30));

//      MethodReference implementation
        BiFunction<Integer,Integer,Integer> addReferenceMethod=methodReference::Addition;
        System.out.println(addReferenceMethod.apply(10, 23));



//        Type 2:method reference to instanceof an object
        methodReference methodReference=new methodReference();
        Printable printable=(msg)->methodReference.display(msg);
        printable.print("Hello there!!");

//        methodReference implementation
        Printable printableMethodRef=methodReference::display;
        printableMethodRef.print("hey it's from the type:3 method reference");




//        Type 3:method reference for an instanceof arbitrary object

        Function<String, Integer> function=(string)->string.length();
        System.out.println(function.apply("Count Me"));
//        methodReference Implements
        Function<String ,Integer> functionMethodRef=String::length;
        System.out.println(function.apply("Count me too"));




//        Type 4:methodReference for constructor

        List<String> Fruits=new ArrayList<>();
        Fruits.add("Apple");
        Fruits.add("Apple");
        Fruits.add("Banana");
        Fruits.add("Mango");
        Function<List<String>, Set<String>> fruitsList=(fruits)->new HashSet<>(fruits);
        System.out.println(fruitsList.apply(Fruits));

//        type 4 methodReference implementation

        Function<List<String>,Set<String>> fruitList=HashSet::new;
        System.out.println(fruitList.apply(Fruits));

    }
}
