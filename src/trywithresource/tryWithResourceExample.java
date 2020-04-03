package trywithresource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class tryWithResourceExample {

    // Scanner implements Closeable interface

    public static void main(String[] args) {

        Sample sample = new Sample();
        try(Scanner scanner = new Scanner(new File("txt"));sample) {
            while (scanner.hasNext()) {
                sample.print();
                System.out.println(scanner.next());

            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
