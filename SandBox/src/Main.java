import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> s = x -> x > 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
        arrayList.add(14);
        System.out.println(arrayList);
        System.out.println(arrayList.stream().filter(s).count());
    }
}