public class Util {
    public static void main(String args[]) {
        Pair<Integer, Integer> pair = new Pair<>(5, 5);
        System.out.println(compare(pair.getK(), pair.getV()));
    }

    private static <K, V> boolean compare(K k, V v) {
        return k.equals(v);
    }
}