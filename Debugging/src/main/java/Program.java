import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        DoIt();
    }

    public static void DoIt(){
        try{
            ArrayList<String> arrayList = new ArrayList<String>();
            int i = 0;

            arrayList.add("Don't PANIC 1");
            arrayList.add("Don't PANIC 2");
            arrayList.add("Don't PANIC 3");

            for (String s:arrayList) {
                i++;
                System.out.println(i);
                DoItInner();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void DoItInner(){

        int g = 5;
        StringBuilder sb = new StringBuilder("Yessir");
    }
}
