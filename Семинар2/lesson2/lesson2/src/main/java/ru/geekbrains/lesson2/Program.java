package ru.geekbrains.lesson2;

import java.util.Arrays;

public class Program {

    public static void main(String[] args) {

        int[] array1 = ArrayUtils.prepareArray();
        ArrayUtils.printArray(array1);
        SortUtils.directSort(array1);
        ArrayUtils.printArray(array1);

        array1 = ArrayUtils.prepareArray();
        ArrayUtils.printArray(array1);
        SortUtils.quickSort(array1);
        ArrayUtils.printArray(array1);

        array1 = new int[] {5, 1, 2, 4};
        ArrayUtils.printArray(array1);
        SortUtils.quickSort(array1);
        ArrayUtils.printArray(array1);


        array1 = ArrayUtils.prepareArray(50000);

        long startTime = System.currentTimeMillis();
        SortUtils.directSort(array1.clone());
        long endTime = System.currentTimeMillis();
        System.out.printf("Время работы сортировки выбором: %d мс.\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        SortUtils.quickSort(array1.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время работы быстрой сортировки: %d мс.\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        SortUtils.quickSort(array1.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время работы быстрой сортировки: %d мс.\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        SortUtils.quickSort(array1.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время работы быстрой сортировки: %d мс.\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        SortUtils.quickSort(array1.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время работы быстрой сортировки: %d мс.\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        Arrays.sort(array1.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время работы системной сортировки: %d мс.\n", endTime - startTime);


        array1 = new int[] {12, -1, -12, 0, 99, 7, 4, 15};
        SortUtils.quickSort(array1);

        ArrayUtils.printArray(array1);
        int searchValue = 4;
        int res = Arrays.binarySearch(array1, searchValue);
        //int res = SearchUtils.binarySearch(array1, searchValue);

        System.out.printf("Элемент %d %s\n",
                searchValue, res >= 0 ? String.format("найден в массиве по индексу %d", res) :
                "не найден");


    }

}
