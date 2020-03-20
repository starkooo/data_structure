public class Main {
    public static void main(String[] args) {
        DummyheadLinkedList<Integer> linkedList = new DummyheadLinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addLast(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.addFirst(123);
        System.out.println(linkedList);

        linkedList.remove(3);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
