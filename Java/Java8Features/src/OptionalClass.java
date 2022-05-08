import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {
        String Name=null;
        Optional<String> optional=Optional.empty();
        System.out.println(optional);
//        Optional<Object> optionalOf = Optional.of(Name);
//        System.out.println(optionalOf);
        Optional<String> stringOptional=Optional.ofNullable(Name);
        String result=stringOptional.orElseGet(()->"Tarun");
        String result1=stringOptional.orElse("Tarun");
        String no_name_is_present = stringOptional.orElseThrow(() -> new IllegalArgumentException("No Name is present"));

        System.out.println(result);
        System.out.println(result1);
        System.out.println(no_name_is_present);

    }
}
