package ru.geekbrains.lesson3;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Iterator;

public class Program {

    public static void main(String[] args) {
        /*ArrayList<Integer> arrayList = new ArrayList<>();
        MyCllection cllection = new MyCllection();
        for (Integer e: cllection) {

        }*/

        LinkedList<Employee> linkedList1 = new LinkedList<>();

        Employee searchEmployee = new Employee("EEEE", 18);

        linkedList1.addFirst(new Employee("AAAAA", 23));
        linkedList1.addFirst(new Employee("BB", 41));
        linkedList1.addFirst(new Employee("FFFF", 33));
        linkedList1.addFirst(new Employee("AAAAA", 27));
        linkedList1.addFirst(new Employee("AAAAA", 51));
        linkedList1.addFirst(new Employee("EEEE", 18));
        linkedList1.addFirst(new Employee("AAAAA", 23));
        linkedList1.addFirst(new Employee("MMMM", 32));

        System.out.println(linkedList1);

        linkedList1.sort(new EmployeeComparator(SortType.Ascending));

        System.out.println();
        System.out.println(linkedList1);

        linkedList1.sort(new EmployeeComparator(SortType.Descending));

        System.out.println();
        System.out.println(linkedList1);

        LinkedList<Employee>.Node resNode = linkedList1.contains(searchEmployee);
        if (resNode != null){
            System.out.println("Элемент найден");
            System.out.println(resNode.value);
        }
        else {
            System.out.println("Элемент не найден");
        }

        linkedList1.removeFirst();
        linkedList1.removeLast();

        System.out.println();
        System.out.println(linkedList1);

    }

}

class MyCllection implements Iterable<Integer>{

    @Override
    public Iterator<Integer> iterator() {
        return new MyCollectionIterator();
    }

    public class MyCollectionIterator implements Iterator<Integer>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Integer next() {
            return null;
        }
    }
}
