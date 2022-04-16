import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public static class Node {
        int data;

        Node left;
        Node right;

        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public boolean hasLeft() { return left != null; }

        public boolean hasRight() { return right != null; }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node (final int initData) {
            this.data = initData;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;
    private final Queue<Integer> insertQueue = new LinkedList<>();

    public BinaryTree(int[] values) {
        this.root = null;
        this.buildTree(values);
    }

    private void buildTree(int[] values) {
        for (int v : values) {
            insertQueue.offer(v);
        }

        Node node = this.insertQueue();
        if (node != null && this.root == null) {
            this.root = node;
        }
    }

    private Node insertQueue() {
        Integer value = this.insertQueue.poll();

        if (value == null || value < 0)  {
            return null;
        }

        Node node = new Node(value);

        node.setLeft(this.insertQueue());
        node.setRight(this.insertQueue());

        return node;
    }

    public Queue<Integer> getLevelOrder() {
        Queue<Integer> levelOrder = new LinkedList<>();
        Queue<Node> workingQueue = new LinkedList<>();
        workingQueue.offer(this.root);
        workingQueue.offer(null);

        while (!workingQueue.isEmpty()) {
            Node workingNode = workingQueue.peek();
            if (workingNode == null) {
                workingQueue.poll();
                if (!workingQueue.isEmpty()) {
                    workingQueue.offer(null);
                    levelOrder.offer(null);
                }
            }
            else {
                workingQueue.poll();
                levelOrder.offer(workingNode.getData());
                if (workingNode.hasLeft()) {
                    workingQueue.offer(workingNode.getLeft());
                }
                if (workingNode.hasRight()) {
                    workingQueue.offer(workingNode.getRight());
                }
            }
        }
        return levelOrder;
    }
}
