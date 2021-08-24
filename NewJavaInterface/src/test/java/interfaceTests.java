import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.annotation.Target;
import java.util.ArrayList;

public class interfaceTests {
    @Test
    public void testArrayListString() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Yes");
        list.add("No");
        System.out.println(list);
        list.remove("No");
        System.out.println(list);
        ArrayList<String> getArr = list.get();
        System.out.println(getArr);
        System.out.println(list.size());
        System.out.println(list);
        assertEquals(1, list.get().size() );
    }

    @Test
    public void testArrayListInt() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        ArrayList<Integer> getArr = list.get();
        System.out.println(getArr);
        System.out.println(list.size());
        System.out.println(list);
        assertEquals( 2, list.get().get(0));
    }
}
