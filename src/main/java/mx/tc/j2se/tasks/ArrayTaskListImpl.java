package mx.tc.j2se.tasks;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class ArrayTaskListImpl extends AbstractTaskList {


    public int i = 0, count = 1, t, s, e, inter;

    public boolean rep;
    Task[] arrayTask1 = new Task[1];
    Task[] arrayTask2 = new Task[2];
    Task[] arrayTask3 = new Task[3];
    Task[] arrayTask4 = new Task[4];
    Task[] arrayTask5 = new Task[5];
    Task[] arrayTask6 = new Task[6];
    Task[] arrayTask7 = new Task[7];
    Task[] arrayTask8 = new Task[8];
    Task[] arrayTask9 = new Task[9];
    Task[] arrayTask10 = new Task[10];




    @Override
    public void add(Task task) {
        if (count < 2) {
            arrayTask1[i] = task;
        } else if (count < 3) {
            System.arraycopy(arrayTask1, 0, arrayTask2, 0, arrayTask1.length);
            arrayTask2[i] = task;

        } else if (count < 4) {
            System.arraycopy(arrayTask2, 0, arrayTask3, 0, arrayTask2.length);
            arrayTask3[i] = task;
        } else if (count < 5) {
            System.arraycopy(arrayTask3, 0, arrayTask4, 0, arrayTask3.length);
            arrayTask4[i] = task;
        } else if (count < 6) {
            System.arraycopy(arrayTask4, 0, arrayTask5, 0, arrayTask4.length);
            arrayTask5[i] = task;
        } else if (count < 7) {
            System.arraycopy(arrayTask5, 0, arrayTask6, 0, arrayTask5.length);
            arrayTask6[i] = task;
        } else if (count < 8) {
            System.arraycopy(arrayTask6, 0, arrayTask7, 0, arrayTask6.length);
            arrayTask7[i] = task;
        } else if (count < 9) {
            System.arraycopy(arrayTask7, 0, arrayTask8, 0, arrayTask7.length);
            arrayTask8[i] = task;
        } else if (count < 10) {
            System.arraycopy(arrayTask8, 0, arrayTask9, 0, arrayTask8.length);
            arrayTask9[i] = task;
        } else if (count < 11) {
            System.arraycopy(arrayTask9, 0, arrayTask10, 0, arrayTask9.length);
            arrayTask10[i] = task;
        }
        i++;

        count++;
    }

    @Override
    public boolean remove(Task task) {
        boolean rem = false;
        if (count < 2) {
            if (task == arrayTask1[0]) {
                arrayTask1 = null;
                rem = true;
            }
            return rem;

        } else if (count < 3) {
            for (int j = 0; j < arrayTask2.length; j++) {
                if (task == arrayTask2[j]) {
                    for (int k = j; k < arrayTask2.length - 1; k++) {
                        arrayTask2[k] = arrayTask2[k + 1];

                    }
                    System.arraycopy(arrayTask2, 0, arrayTask1, 0, arrayTask1.length);
                    count = count - 1;
                    rem = true;
                }
            }

        } else if (count < 4) {
            for (int j = 0; j < arrayTask3.length; j++) {
                if (task == arrayTask3[j]) {
                    for (int k = j; k < arrayTask3.length - 1; k++) {
                        arrayTask3[k] = arrayTask3[k + 1];

                    }
                    System.arraycopy(arrayTask3, 0, arrayTask2, 0, arrayTask2.length);
                    count = count - 1;
                    rem = true;
                }
            }

        } else if (count < 5) {
            for (int j = 0; j < arrayTask4.length; j++) {
                if (task == arrayTask4[j]) {
                    for (int k = j; k < arrayTask4.length - 1; k++) {
                        arrayTask4[k] = arrayTask4[k + 1];
                    }
                    System.arraycopy(arrayTask4, 0, arrayTask3, 0, arrayTask4.length);
                    count = count - 1;
                    rem = true;
                }
            }
        } else if (count < 6) {
            for (int j = 0; j < arrayTask5.length; j++) {
                if (task == arrayTask5[j]) {
                    for (int k = j; k < arrayTask5.length - 1; k++) {
                        arrayTask5[k] = arrayTask5[k + 1];
                    }
                    System.arraycopy(arrayTask5, 0, arrayTask4, 0, arrayTask5.length);
                    count = count - 1;
                    rem = true;
                }
            }
        } else if (count < 7) {
            for (int j = 0; j < arrayTask6.length; j++) {
                if (task == arrayTask6[j]) {
                    for (int k = j; k < arrayTask6.length - 1; k++) {
                        arrayTask6[k] = arrayTask6[k + 1];
                    }
                    System.arraycopy(arrayTask6, 0, arrayTask5, 0, arrayTask6.length);
                    count = count - 1;
                    rem = true;
                }
            }
        } else if (count < 8) {
            for (int j = 0; j < arrayTask7.length; j++) {
                if (task == arrayTask7[j]) {
                    for (int k = j; k < arrayTask7.length - 1; k++) {
                        arrayTask7[k] = arrayTask7[k + 1];
                    }
                    System.arraycopy(arrayTask7, 0, arrayTask6, 0, arrayTask7.length);
                    count = count - 1;
                    rem = true;
                }
            }
        } else if (count < 9) {
            for (int j = 0; j < arrayTask8.length; j++) {
                if (task == arrayTask8[j]) {
                    for (int k = j; k < arrayTask8.length - 1; k++) {
                        arrayTask8[k] = arrayTask8[k + 1];
                    }
                    System.arraycopy(arrayTask8, 0, arrayTask7, 0, arrayTask8.length);
                    count = count - 1;
                    rem = true;
                }
            }

        } else if (count < 10) {
            for (int j = 0; j < arrayTask9.length; j++) {
                if (task == arrayTask9[j]) {
                    for (int k = j; k < arrayTask9.length - 1; k++) {
                        arrayTask9[k] = arrayTask9[k + 1];
                    }
                    System.arraycopy(arrayTask9, 0, arrayTask8, 0, arrayTask9.length);
                    count = count - 1;
                    rem = true;
                }
            }
        } else if (count < 11) {
            for (int j = 0; j < arrayTask10.length; j++) {
                if (task == arrayTask10[j]) {
                    for (int k = j; k < arrayTask10.length - 1; k++) {
                        arrayTask10[k] = arrayTask10[k + 1];
                    }
                    System.arraycopy(arrayTask10, 0, arrayTask9, 0, arrayTask10.length);
                    count = count - 1;
                    rem = true;
                }
            }
        }

        return rem;
    }


    @Override
    public int size() {
        return count - 1;
    }

    @Override
    public Task getTask(int index) {
        if (index > count - 2) {
            throw new IndexOutOfBoundsException("This index is not available");
        }
        if (count-1 < 2) {
            return arrayTask1[index];
        } else if (count-1 < 3) {
            return arrayTask2[index];
        } else if (count-1 < 4) {
            return arrayTask3[index];
        } else if (count-1 < 5) {
            return arrayTask4[index];
        } else if (count-1 < 6) {
            return arrayTask5[index];
        } else if (count-1 < 7) {
            return arrayTask6[index];
        } else if (count-1< 8) {
            return arrayTask7[index];
        } else if (count-1 < 9) {
            return arrayTask8[index];
        } else if (count-1 < 10) {
            return arrayTask9[index];
        } else if (count-1 < 11) {
            return arrayTask10[index];
        } else

            return arrayTask1[0];
    }

    //@Override
    /*public ArrayTaskList incoming(int from, int to) {
        ArrayTaskList array1 = new ArrayTaskListImpl();
        if (count < 2){
            next:
            for (int m = 0; m < count - 1; m++) {
                rep = arrayTask1[m].isRepeated();
                if (rep == false) {
                    t = arrayTask1[m].getTime();
                    if (t >= from & t <= to) {
                        array1.add(arrayTask1[m]);
                        continue next;
                    } else continue next;
                } else
                    s = arrayTask1[m].getStartTime();
                e= arrayTask1[m].getEndTime();
                inter=arrayTask1[m].getRepeatInterval();
                for (int c=s;c<=e;c=c+inter) {
                    if (c >= from & c <= to) {
                        array1.add(arrayTask1[m]);
                        continue next;

                    }
                }
            }
        } else if (count < 3) {
            next2:
            for (int m = 0; m < count - 1; m++) {
                rep = arrayTask2[m].isRepeated();
                if (rep == false) {
                    t = arrayTask2[m].getTime();
                    if (t >= from & t <= to) {
                        array1.add(arrayTask2[m]);
                        continue next2;
                    } else continue next2;
                } else
                    s = arrayTask2[m].getStartTime();
                e= arrayTask2[m].getEndTime();
                inter=arrayTask2[m].getRepeatInterval();
                for (int c=s;c<=e;c=c+inter) {
                    if (c >= from & c <= to) {
                        array1.add(arrayTask2[m]);
                        continue next2;

                    }
                }
            }
        }
        return array1;

    }*/

    public ArrayTaskListImpl() {

    }
    ArrayTaskListImpl arrayTask;
    public ArrayTaskListImpl(ArrayTaskListImpl arrayTasks) {
        this.arrayTask = arrayTasks;

    }




    @Override
    public Iterator<Task> iterator() {
        Iterator<Task> it = new ArrayTaskIterator();
        return it;
    }

    @Override
    public boolean equals(Object o) {
        int c=0;
        if (o==null){
            return false;
        } else if(o instanceof AbstractTaskList){
            ArrayTaskListImpl arraycomp = (ArrayTaskListImpl) o;
            if(this.size()==arraycomp.size()){
                for(int a=0; a<arraycomp.size();a++){
                    if(this.getTask(a)==arraycomp.getTask(a)){
                    c=c+1;
                    }
                }
                if (c==arraycomp.size()){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int code=0;
        if (count-1<2){
                code=arrayTask1[0].hashCode();
        } else if (count-1<3){
            for(int m=0; m<2;m++){
                code += arrayTask2[m].hashCode()*(m+1);
            }
        } else if (count-1<4){
            for (int m=0; m<3;m++){
                code += arrayTask3[m].hashCode()*(m+1);
            }
        }else if (count-1<5){
            for(int m=0; m<4;m++){
                code += arrayTask4[m].hashCode()*(m+1);
            }
        }else if (count-1<6){
            for(int m=0;m<5;m++){
                code += arrayTask5[m].hashCode()*(m+1);
            }
        } else if (count-1<7){
            for(int m=0;m<6;m++){
                code += arrayTask6[m].hashCode()*(m+1);
            }
        } else if (count-1<8){
            for (int m=0; m<7;m++){
                code += arrayTask7[m].hashCode()*(m+1);
            }
        } else if (count-1<9){
            for (int m=0; m<8; m++){
                code += arrayTask8[m].hashCode()*(m+1);
            }
        } else if (count-1<10){
            for (int m=0; m<9;m++){
                code += arrayTask9[m].hashCode()*(m+1);
            }
        } else if (count-1<11){
            for (int m=0; m<10;m++){
                code += arrayTask10[m].hashCode()*(m+1);
            }
        }
        return code;
    }

    @Override
    public LinkedTaskListImpl cloneLinked() { //I won't use this method here!
        return null;
    }

    @Override
    public ArrayTaskListImpl cloneArray() {
        ArrayTaskListImpl clon = new ArrayTaskListImpl();
        if (count-1<2){
            clon.add(arrayTask1[0]);
        } else if (count-1<3){
            for(int m=0; m<2;m++){
                clon.add(arrayTask2[m]);
            }
        } else if (count-1<4){
            for (int m=0; m<3;m++){
                clon.add(arrayTask3[m]);
            }
        }else if (count-1<5){
            for(int m=0; m<4;m++){
                clon.add(arrayTask4[m]);
            }
        }else if (count-1<6){
            for(int m=0;m<5;m++){
                clon.add(arrayTask5[m]);
            }
        } else if (count-1<7){
            for(int m=0;m<6;m++){
                clon.add(arrayTask6[m]);
            }
        } else if (count-1<8){
            for (int m=0; m<7;m++){
                clon.add(arrayTask7[m]);
            }
        } else if (count-1<9){
            for (int m=0; m<8; m++){
                clon.add(arrayTask8[m]);
            }
        } else if (count-1<10){
            for (int m=0; m<9;m++){
                clon.add(arrayTask9[m]);
            }
        } else if (count-1<11){
            for (int m=0; m<10;m++){
                clon.add(arrayTask10[m]);
            }
        }

        return clon;
    }

    @Override
    public Stream<Task> getStream() {
        Iterator<Task> iterArray = new ArrayTaskIterator();
        if (iterArray.hasNext()==false){
            throw new NullPointerException("You don't have any task");
        }
        Iterable<Task> streamiterArray = () -> iterArray;

        return StreamSupport.stream(streamiterArray.spliterator(), false);
    }


    protected  class ArrayTaskIterator implements Iterator<Task> {


        int position=-1;

       @Override
       public boolean hasNext() {
           if(arrayTask1[0]==null){
               throw new NullPointerException("You don't have any task");

           }
           else if(position+1<(count-1)){

                return true;
           }
           return false;
       }

       @Override
       public Task next() {
           position++;
           if (arrayTask1[0]==null){
               throw new NullPointerException("You don't have any task");
           }
           else if (count-1 < 2) {
               return arrayTask1[position];
           } else if (count-1 < 3) {
               return arrayTask2[position];
           } else if (count-1 < 4) {
               return arrayTask3[position];
           } else if (count-1 < 5) {
               return arrayTask4[position];
           } else if (count-1 < 6) {
               return arrayTask5[position];
           } else if (count-1 < 7) {
               return arrayTask6[position];
           } else if (count-1 < 8) {
               return arrayTask7[position];
           } else if (count-1 < 9) {
               return arrayTask8[position];
           } else if (count-1 < 10) {
               return arrayTask9[position];
           } else if (count-1 < 11) {
               return arrayTask10[position];
           } else

               return arrayTask1[0];
       }
   }


}



