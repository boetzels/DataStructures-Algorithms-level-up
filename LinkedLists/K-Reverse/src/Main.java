import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i < 11; i++) {
            list.add(i);
        }

        System.out.println(Arrays.toString(list.toArray()));

        KReverseList(list, 3, 0);

        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void KReverseList(LinkedList<Integer> list, int k, int index) {
        Integer newHead = list.get(index + 1);
        list.remove(index + 1);

        list.add((index + 1) / k * k, newHead);

        if (index < list.size() - 2) {
            KReverseList(list, k, index + 1);
        }
    }
}
