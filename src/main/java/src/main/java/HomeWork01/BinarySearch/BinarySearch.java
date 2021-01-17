package HomeWork01.BinarySearch;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] list = new int[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }
        System.out.println(binarySearch(list, 7));
    }

    public static boolean binarySearch(int[] list, int n) {
        Arrays.sort(list);
        int start = 0;
        int end = list.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (list[middle] == n) {
                return true; }
            else if (list[middle] < n) {
                start = middle + 1;
            }
            else if (list[middle] > n) {
                end = middle - 1;
            }
        }
        return false;
    }
}
