package trywithresource;

import java.io.Closeable;

public class Sample implements Closeable {

    public void print() {
        System.out.println("print Object");
    }
    @Override
    public void close() {
        System.out.println("Closing all Objects");
    }
}
