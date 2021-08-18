public class Program {
    public static void main(String[] args) {
        TestprintArray();
        TestGeneric1Class();
        TestGeneric2Class();
    }

    public static <E> void printArray(E[] aryIn) {

        for (E element : aryIn)
        {
            System.out.printf("%s ", element);
        }
        System.out.println("");
    }

    public static void TestprintArray() {

        Integer[] intArray = {1,2,3,4,5};
        Double[] dblArray = {1.4, 4.6, 5.8};
        Character[] charArray = {'h', 'a', 'r', 'r', 'y'};

        printArray(intArray);
        printArray(dblArray);
        printArray(charArray);

    }

    public static void TestGeneric1Class() {
        Generic1<String> g1 = new Generic1<String>();
        g1.set("Luke");
        System.out.println(g1.get());

        Generic1<Integer> g2 = new Generic1<Integer>();
        g2.set(555);
        System.out.println(g2.get());

    }

    public static void TestGeneric2Class() {
        Generic2<String, Integer> g2 = new Generic2<String, Integer>("Stuff", 15);
        g2.print();
    }
}
