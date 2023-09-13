package ru.geekbrains.lesson2;

public class SearchUtils {


    public static int binarySearch(int[] array, int value){
        return binarySearch(array, value, 0, array.length - 1);
    }
    private static int binarySearch(int[] array, int value, int left, int right){

        if (right < left)
            return -1;

        int middle = (right - left) / 2 + left;
        if (array[middle] == value){
            return middle;
        }
        else if (array[middle] < value){
            return binarySearch(array, value, middle + 1, right);
        }
        else {
            return binarySearch(array, value, left, middle - 1);
        }

    }

}
