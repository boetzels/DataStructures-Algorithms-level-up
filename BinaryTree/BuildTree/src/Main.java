import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //int[] values = {1, 2, 4, -1, -1, 5, 7, -1, -1, 8, -1, -1, 3, -1, 6, 9, -1, -1, 10, -1, 11, -1, -1};
        int[] values = {1, 2, 4, -1, -1, 5, 7, -1, -1, -1, 3, -1, 6, -1, -1};


        BinaryTree btree = new BinaryTree(values);

        Queue<Integer> levelOrder = btree.getLevelOrder();

        while (!levelOrder.isEmpty()) {
            Integer value = levelOrder.poll();

            if (value == null) {
                System.out.println();
            }
            else {
                System.out.print(value+" ");
            }
        }
    }
}
