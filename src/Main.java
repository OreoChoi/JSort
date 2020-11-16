import Sort.Heap;
import Sort.HeapList;

public class Main {
    public static void main(String[] args) {
        int[] arr = {-105, 104, 101, 106, 108};
        int[] arr1 = {105, -104, 101, 106, 108};
        int[] arr2 = {105, 104, -101, 106, 108};
        int[] arr3 = {13, 11, 12, -10, 8, 9, 6, 7, 4, 5, 2, 3, 1};
        int[] arr4 = {0, 1, 2, 3, -4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        HeapList heapList = new HeapList(arr, Heap.HEAP_TYPE_MAX);
        HeapList heapList1 = new HeapList(arr1,Heap.HEAP_TYPE_MIN);
        HeapList heapList2 = new HeapList(arr2,Heap.HEAP_TYPE_MIN);
        HeapList heapList3 = new HeapList(arr3,Heap.HEAP_TYPE_MAX);
        HeapList heapList4 = new HeapList(arr4,Heap.HEAP_TYPE_MAX);


        while (!heapList.isEmpty()) {
            System.out.print(heapList.pop() + " ");
        }
        System.out.println();

        while (!heapList1.isEmpty()) {
            System.out.print(heapList1.pop() + " ");
        }
        System.out.println();

        while (!heapList2.isEmpty()) {
            System.out.print(heapList2.pop() + " ");
        }
        System.out.println();

        while (!heapList3.isEmpty()) {
            System.out.print(heapList3.pop() + " ");
        }
        System.out.println();

        while (!heapList4.isEmpty()) {
            System.out.print(heapList4.pop() + " ");
        }
    }
}
