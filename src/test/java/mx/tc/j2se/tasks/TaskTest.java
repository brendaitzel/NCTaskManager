package mx.tc.j2se.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
   @Test
    public void titleTest(){
       Task task = new TaskImpl();
       task.setTitle("Hola");
       assertEquals("Hola", task.getTitle());
   }
   // A non-repetitive task
    @Test
   public void timeTest(){
       Task task = new TaskImpl();
       task.setTime(4);
       assertEquals(4, task.getTime());
       assertEquals(4, task.getStartTime());
       assertEquals(4, task.getEndTime());


   }
   @Test
   public void timeTest2(){
       Task task = new TaskImpl();
       task.setTime(4,10,2);
       assertEquals(4,task.getStartTime());
       assertEquals(10, task.getEndTime());
       assertEquals(2, task.getRepeatInterval());

   }
  @Test
    public void nextTimeAfterTest(){
       Task task = new TaskImpl();
       task.setTime(10);
       //task.nextTimeAfter(6)
       assertEquals(-1, task.nextTimeAfter(11));


  }

  @Test
    public void nextTimeAfterTest2(){
       Task task = new TaskImpl();
       task.setActive(false);
       task.setTime(5,20, 4);
       assertEquals(-1, task.nextTimeAfter(6));
  }
}
