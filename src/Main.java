import Sort.MergeSort;

public class Main {
    public static void main(String[] args) {
       /* int[] arr = {105,104,101,106,108};
        int[] arr = {105,104,101,106,108};
        int[] arr = {105,104,101,106,108};
        int[] arr = {13,11,12,10,8,9,6,7,4,5,2,3,1};*/
        int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13};
        arr = MergeSort.sort(arr,true);

        for (int a : arr) {
            System.out.println(a);
        }
    }
}
