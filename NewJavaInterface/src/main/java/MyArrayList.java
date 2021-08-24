import java.util.ArrayList;

public class MyArrayList<T> implements MyInterfaceList<T> {
    ArrayList<T> arrayList = new ArrayList<>();


    @Override
    public void add(T val) {
        arrayList.add(val);
    }

    @Override
    public void remove(T val) {
        arrayList.remove(val);
    }

    @Override
    public ArrayList get() {
        return arrayList;
    }

    @Override
    public int size() {
       return arrayList.size();
    }

    @Override
    public String toString() {
        return "arrayList=" + arrayList.toString();
    }
}
