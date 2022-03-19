import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        for (int i = 1; i < 21; i += 2) {
            list1.add(i);
        }
        for (int i = 4; i < 27; i += 4) {
            list2.add(i);
        }

        System.out.println(Arrays.toString(list1.toArray()));
        System.out.println(Arrays.toString(list2.toArray()));

        System.out.println(Arrays.toString(MergeLists(list1, list2).toArray()));
    }

    public static LinkedList<Integer> MergeLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        int i = 0;
        int j = 0;
        int size1 = list1.size();
        int size2 = list2.size();

        LinkedList<Integer> result = new LinkedList<>();

        while (!(i == size1 && j == size2)) {
            if (i == size1 || (j != size2 && list1.get(i) > list2.get(j))) {
                result.offerLast(list2.get(j++));
            }
            else {
                result.offerLast(list1.get(i++));
            }
        }

        return result;
    }
}
