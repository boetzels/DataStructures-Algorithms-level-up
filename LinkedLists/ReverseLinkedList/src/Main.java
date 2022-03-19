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

        ReverseList(list, 0);

        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void ReverseList(LinkedList<Integer> list, int index) {
        int size = list.size();

        Integer newHead = list.get(index + 1);
        list.remove(index + 1);
        list.offerFirst(newHead);

        if (index < size - 2) {
            ReverseList(list, index + 1);
        }
    }
}


