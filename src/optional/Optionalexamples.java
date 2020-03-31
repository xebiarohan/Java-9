package optional;

import java.util.Optional;
import java.util.stream.Collectors;

public class Optionalexamples {
    public static void main(String[] args) {

        //till java8 we have orElse and orElseGet which gives value as output

        String val1 = null;

        Optional.ofNullable(val1).orElse(getDefaultValue());
                // here getDefaultvalue will be calculated even if val1 is notnull

        String s = Optional.ofNullable(val1).orElseGet(() -> getDefaultValue());
                // here getDefaultvalue will only be called when val1 is null;

        // 1. If in response we need another Optional value   : or

        Optional.ofNullable(val1).or(() -> Optional.of("beta"));


        // 2. ifPresentOrElse  1st parameter is supplier and 2nd is runnable

        Optional.ofNullable(val1).ifPresentOrElse(
                v -> print(v),
                Optionalexamples:: error
        );

        // 3. Stream() method
        Optional.ofNullable(val1).stream().map(String::toUpperCase).collect(Collectors.toList());

    }

    public static String getDefaultValue() {
        return "beta";
    }

    public static void print(String val) {
        System.out.println(val);
    }

    public static void error() {
        System.out.println("Error....");
    }
}
