import java.util.ArrayList;

public interface MyInterfaceList<T> {
    void add(T val);
    void remove(T val);
    ArrayList get();
    int size();
}
