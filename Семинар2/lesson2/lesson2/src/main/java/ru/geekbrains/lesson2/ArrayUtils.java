package ru.geekbrains.lesson2;

import java.util.Random;

/**
 * Утилиты для работы с массивом
 */
public class ArrayUtils {

    private static Random random = new Random();

    public static int[] prepareArray(){
        return prepareArray(random.nextInt(15, 20));
    }

    public static int[] prepareArray(int length){
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(-99, 100);
        }
        return array;
    }

    public static void printArray(int[] array){
        for (int element : array){
            System.out.printf("%d\t", element);
        }
        System.out.println();
    }

}
