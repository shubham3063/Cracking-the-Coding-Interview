import java.util.ArrayList;

public class TestingClass {
    TestingClass() {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1,1);
        for (int i = 0; i < 0; i++) {
            System.out.println(a.get(i));
        }
    }
}
