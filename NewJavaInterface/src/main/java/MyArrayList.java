import java.util.ArrayList;

public class MyArrayList<T> implements MyInterfaceList<T> {

    ArrayList<T> arrayList = new ArrayList<>();
    @Override

    public String toString() {
        return "MyArrayList(" + "arrayList= " + arrayList + ")";
    }


    @Override
    public void add(T val) {

    }

    @Override
    public void remove(T val) {

    }

    @Override
    public ArrayList get() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
