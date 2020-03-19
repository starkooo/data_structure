public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(10);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(20);
        System.out.println(arr);

        System.out.println(arr.get(5));

        arr.removeFirst();
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);

        arr.remove(4);
        System.out.println(arr);

        arr.removeElement(6);
        System.out.println(arr);
    }
}
