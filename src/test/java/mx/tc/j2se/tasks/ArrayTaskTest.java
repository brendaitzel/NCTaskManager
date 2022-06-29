package mx.tc.j2se.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ArrayTaskTest {

    @Test
    public void GetSize(){
        Task task = new TaskImpl();
        //Task task = new TaskImpl();
        ArrayTaskList array1 = new ArrayTaskListImpl();
        task.setTitle("Tarea1");
        task.setTime(5);
        array1.add(task);//1
        task.setTitle("Tarea2");
        task.setTime(2,10,1);
        array1.add(task);//2
        array1.add(task);//3
        array1.add(task);//4
        array1.add(task);//5
        //arrayTaskList.size();
        assertEquals(5,array1.size());

    }
    @Test
    public void StTest(){
        Task arr[]= new Task[10];
        Task task = new TaskImpl();
        Task task2 = new TaskImpl();
        Task task3 = new TaskImpl();
        Task task4 = new TaskImpl();
        Task task5 = new TaskImpl();
        task.setTitle("Tarea 1");
        task.setTime(1,10,2);
        task2.setTitle("Tarea2");
        task2.setTime(4);
        task3.setTitle("Tarea 3");
        task3.setTime(5,20,3);
        task4.setTitle("Tarea 4");
        task4.setTime(22);
        task5.setTitle("Tarea 5");
        task5.setTime(10);
        ArrayTaskList array1 = new ArrayTaskListImpl();
        array1.add(task);
        array1.add(task2);
        array1.add(task3);
        array1.add(task4);
        array1.add(task5);
        arr[0]=task;
        arr[1]=task2;
        arr[2]=task3;
        arr[3]=task4;
        arr[4]=task5;
        assertEquals(arr[5],array1.getTask(5));


    }
    @Test
    public void removeTest(){
        Task arr[]= new Task[10];
        Task task = new TaskImpl();
        Task task2 = new TaskImpl();
        Task task3 = new TaskImpl();
        Task task4 = new TaskImpl();
        Task task5 = new TaskImpl();
        Task task6= new TaskImpl();
        Task task7 = new TaskImpl();
        Task task8 = new TaskImpl();
        Task task9 = new TaskImpl();
        Task task10 = new TaskImpl();
        task.setTitle("Tarea 1");
        task.setTime(1,10,2);
        task2.setTitle("Tarea2");
        task2.setTime(4);
        task3.setTitle("Tarea 3");
        task3.setTime(5,20,3);
        task4.setTitle("Tarea 4");
        task4.setTime(22);
        task5.setTitle("Tarea 5");
        task5.setTime(2);
        task6.setTitle("Tarea 6");
        task6.setTime(1);
        task7.setTitle("Tarea 7");
        task7.setTime(14);
        task8.setTitle("Tarea 8");
        task9.setTime(15);
        task9.setTitle("Tarea 9");
        task5.setTime(3);
        task10.setTitle("Tarea 10");
        task10.setTime(8);
        ArrayTaskList array1 = new ArrayTaskListImpl();
       // array1.add(task);
        array1.add(task2);
        array1.add(task3);
        array1.add(task4);
        array1.add(task5);
        array1.add(task6);
        array1.add(task7);
        array1.add(task8);
        array1.add(task9);
        array1.add(task10);
        array1.remove(task7);
        array1.remove(task);
        array1.remove(task4);
        array1.remove(task3);
        array1.remove(task2);
        //assertEquals(9,array1.size());
        array1.remove(task8);
        array1.remove(task9);

        //assertEquals(3,array1.size());
        //assertEquals(false, array1.remove(task7));
        assertEquals(false, array1.remove(task));
        //assertEquals(false, array1.remove(task4));
        //assertEquals(false, array1.remove(task3));
        //assertEquals(false, array1.remove(task2));
        //assertEquals(false, array1.remove(task8));
        //assertEquals(false, array1.remove(task9));
    }
    @Test
    public void incomeTest(){
        ArrayTaskList array1 = new ArrayTaskListImpl();
        ArrayTaskList array2 = new ArrayTaskListImpl();
        ArrayTaskList aux = new ArrayTaskListImpl();
        Task task = new TaskImpl();
        Task task2 = new TaskImpl();
        Task task3 = new TaskImpl();
        Task task4 = new TaskImpl();
        Task task5 = new TaskImpl();
        Task task6= new TaskImpl();
        Task task7 = new TaskImpl();
        Task task8 = new TaskImpl();
        Task task9 = new TaskImpl();
        Task task10 = new TaskImpl();
        task.setTitle("Tarea 1");
        task.setTime(1,10,2);
        task2.setTitle("Tarea2");
        task2.setTime(4);
        task3.setTitle("Tarea 3");
        task3.setTime(5,20,3);
        task4.setTitle("Tarea 4");
        task4.setTime(22);
        task5.setTitle("Tarea 5");
        task5.setTime(2);
        task6.setTitle("Tarea 6");
        task6.setTime(1);
        task7.setTitle("Tarea 7");
        task7.setTime(14);
        task8.setTitle("Tarea 8");
        task8.setTime(10);
        task9.setTitle("Tarea 9");
        task9.setTime(6,12,1);
        task10.setTitle("Tarea 10");
        task10.setTime(8);
        array1.add(task);
        array1.add(task2);
        array1.add(task3);
        array1.add(task4);
        array1.add(task5);
        array1.add(task6);
        array1.add(task7);
        array1.add(task8);
        array1.add(task9);
        array1.add(task10);
        aux=array1.incoming(3,10);
        array2.add(task);
        array2.add(task2);
        array2.add(task3);
        array2.add(task8);
        array2.add(task9);
        array2.add(task10);
        //array2.add(task6);
        //array2.add(task3);
        //array2.add(task5);
        assertEquals(array2.getTask(6),aux.getTask(6));
        //assertTrue(task2.isRepeated());

    }



    @Test
    public void inttest(){
        Task task10 = new TaskImpl();
        Task arr[]= new Task[1];
        ArrayTaskList array1 = new ArrayTaskListImpl();
        ArrayTaskList array2 = new ArrayTaskListImpl();
        ArrayTaskList aux = new ArrayTaskListImpl();
        task10.setTitle("Tarea 10");
        task10.setTime(1,4,2);//qué pasa si empieza antes?
        array1.add(task10);
        array2.add(task10);
        aux=array1.incoming(2,5);
        //arr[0]=
        assertEquals(array2.getTask(0),aux.getTask(0));
       // assertFalse(task10.isRepeated());

    }

}
