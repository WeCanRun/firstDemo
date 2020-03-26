
public class Test {

    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        swap(arr, 1,1);
        for(int a : arr)
            System.out.print(a + " ");
    }

    private static void swap(int[] arr, int i , int j) {
        if(i == j)
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[j] ^ arr[i];
        arr[i] = arr[j] ^ arr[i];
    }
}

