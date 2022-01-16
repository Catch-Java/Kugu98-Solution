package JavaConcept;

public class LinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

    }
    private Node headNode;
    private int size;

    public LinkedList() {
        headNode = new Node();
        size = 0;
    }

    public void addFirst(Object data) {
        Node newNode = new Node(data);
        newNode.nextNode = headNode.nextNode;
        headNode.nextNode = newNode;
        size++;
    }

    public Object get(int index) {
        return getNode(index).data;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index : " + index + ", size : " + size);
        } else {
            Node node = headNode.nextNode;
            for (int i = 0; i < index; i++) {
                node = node.nextNode;
            }

            return node;
        }
    }

    public void add(int index, Object data) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index : " + index + ", size : " + size);

        Node newNode = new Node(data);
        Node prevNode = getNode(index - 1);
        newNode.nextNode = prevNode.nextNode;
        prevNode.nextNode = newNode;
        size++;
    }

    public Object removeFirst() {
        Node node = headNode.nextNode;
        headNode.nextNode = node.nextNode;
        Object result = node.data;
        size--;
        return result;
    }

    public Object removeNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index : " + index + ", size : " + size);
        else if (index == 0)
            return removeFirst();

        Node prevNode = getNode(index - 1);
        Node removeNode = prevNode.nextNode;
        Node postNode = removeNode.nextNode;
        prevNode.nextNode = postNode;
        Object result = removeNode.data;
        size--;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node node = headNode.nextNode;
        if (node == null) {
            result.append("데이터가 없습니다");
        } else {
            result.append(node.data);
            node = node.nextNode;
            while (node != null) {
                result.append(", ");
                result.append(node.data);
                node = node.nextNode;
            }
        }
        result.append("]");
        return result.toString();
    }

    class Node {
        private Node nextNode;
        private Object data;

        public Node() {}

        public Node(Object data) {
            this.nextNode = null;
            this.data = data;
        }
    }



}
