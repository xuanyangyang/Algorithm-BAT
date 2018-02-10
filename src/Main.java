import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> m = new HashMap<>();
        m.put(3, "three");
        System.out.println(m.get(3));
    }
}