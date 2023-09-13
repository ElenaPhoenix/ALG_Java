package ru.geekbrains.lesson4.sample;

import java.util.HashMap;

public class Program {

    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<>();
        String ret = hashMap.put("+79001112233", "Андрей");
        ret = hashMap.put("+79001112232", "Василий");
        ret = hashMap.put("+79001112232", "Александр");


    }
}
