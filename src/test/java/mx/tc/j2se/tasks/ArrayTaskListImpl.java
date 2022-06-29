package mx.tc.j2se.tasks;

public class ArrayTaskListImpl implements ArrayTaskList {
    public int index, arr = 1, i = 0, count = 1, t, s, e, inter;

    public boolean rep;
    Task[] arrayTask1 = new Task[20];
    Task[] arrayTask2 = new Task[40];
    Task[] arrayTask3 = new Task[60];
    Task[] arrayTask4 = new Task[80];
    Task[] arrayTask5 = new Task[100];
    Task[] arrayTask6 = new Task[120];
    Task[] arrayTask7 = new Task[140];
    Task[] arrayTask8 = new Task[160];
    Task[] arrayTask9 = new Task[180];
    Task[] arrayTask10 = new Task[200];
    Task[] arrayTask = new Task[50];

    //Task task = new TaskImpl();
    //Task task2 = new TaskImpl();

    @Override
    public void add(Task task) {
        if (count < 21) {
            arrayTask1[i] = task;
        } else if (count < 41) {
            System.arraycopy(arrayTask1, 0, arrayTask2, 0, arrayTask1.length);
            arrayTask2[i] = task;

        } else if (count < 61) {
            System.arraycopy(arrayTask2, 0, arrayTask3, 0, arrayTask2.length);
            arrayTask3[i] = task;
        } else if (count < 81) {
            System.arraycopy(arrayTask3, 0, arrayTask4, 0, arrayTask3.length);
            arrayTask4[i] = task;
        } else if (count < 101) {
            System.arraycopy(arrayTask4, 0, arrayTask5, 0, arrayTask4.length);
            arrayTask5[i] = task;
        } else if (count < 121) {
            System.arraycopy(arrayTask5, 0, arrayTask6, 0, arrayTask5.length);
            arrayTask6[i] = task;
        } else if (count < 141) {
            System.arraycopy(arrayTask6, 0, arrayTask7, 0, arrayTask6.length);
            arrayTask7[i] = task;
        } else if (count < 161) {
            System.arraycopy(arrayTask7, 0, arrayTask8, 0, arrayTask7.length);
            arrayTask8[i] = task;
        } else if (count < 181) {
            System.arraycopy(arrayTask8, 0, arrayTask9, 0, arrayTask8.length);
            arrayTask9[i] = task;
        } else if (count < 201) {
            System.arraycopy(arrayTask9, 0, arrayTask10, 0, arrayTask9.length);
            arrayTask10[i] = task;
        }
        i++;
        count++;
    }

    @Override
    public boolean remove(Task task) {
        count = count - 1;
        boolean rem=false;
        if (count < 21) {
            for (int j = 0; j < arrayTask1.length; j++) {
                if (task == arrayTask1[j]) {
                    for (int k = j; k < count; k++) {
                        arrayTask1[k] = arrayTask1[k + 1];
                    }
                    rem = true;
                }
            }
        } else if (count < 41) {
            for (int j = 0; j < arrayTask2.length; j++) {
                if (task == arrayTask2[j]) {
                    for (int k = j; k < arrayTask2.length - 1; k++) {
                        arrayTask2[k] = arrayTask2[k + 1];
                    }

                    rem = true;
                }
            }

        } else if (count < 61) {
            for (int j = 0; j < arrayTask3.length; j++) {
                if (task == arrayTask3[j]) {
                    for (int k = j; k < arrayTask3.length - 1; k++) {
                        arrayTask3[k] = arrayTask3[k + 1];
                    }

                    rem = true;
                }
            }

        } else if (count < 81) {
            for (int j = 0; j < arrayTask4.length; j++) {
                if (task == arrayTask4[j]) {
                    for (int k = j; k < arrayTask4.length - 1; k++) {
                        arrayTask4[k] = arrayTask4[k + 1];
                    }

                    rem = true;
                }
            }
        } else if (count < 101) {
            for (int j = 0; j < arrayTask5.length; j++) {
                if (task == arrayTask5[j]) {
                    for (int k = j; k < arrayTask5.length - 1; k++) {
                        arrayTask5[k] = arrayTask5[k + 1];
                    }

                    rem = true;
                }
            }
        } else if (count < 121) {
            for (int j = 0; j < arrayTask6.length; j++) {
                if (task == arrayTask6[j]) {
                    for (int k = j; k < arrayTask6.length - 1; k++) {
                        arrayTask6[k] = arrayTask6[k + 1];
                    }

                    rem = true;
                }
            }
        } else if (count < 141) {
            for (int j = 0; j < arrayTask7.length; j++) {
                if (task == arrayTask7[j]) {
                    for (int k = j; k < arrayTask7.length - 1; k++) {
                        arrayTask7[k] = arrayTask7[k + 1];
                    }

                    rem = true;
                }
            }
        } else if (count < 161) {
            for (int j = 0; j < arrayTask8.length; j++) {
                if (task == arrayTask8[j]) {
                    for (int k = j; k < arrayTask8.length - 1; k++) {
                        arrayTask8[k] = arrayTask8[k + 1];
                    }
                    rem = true;
                }
            }

        } else if (count < 181) {
            for (int j = 0; j < arrayTask9.length; j++) {
                if (task == arrayTask9[j]) {
                    for (int k = j; k < arrayTask9.length - 1; k++) {
                        arrayTask9[k] = arrayTask9[k + 1];
                    }

                    rem = true;
                }
            }


        } else if (count < 201) {
            for (int j = 0; j < arrayTask10.length; j++) {
                if (task == arrayTask10[j]) {
                    for (int k = j; k < arrayTask10.length - 1; k++) {
                        arrayTask10[k] = arrayTask10[k + 1];
                    }

                    rem = true;

                }
            }

        }

        return rem;
    }

    @Override
    public int size() {
        //int length = arrayAux.length;
        return count - 1;
    }

    @Override
    public Task getTask(int index) {

        if (index < 21) {
            return arrayTask1[index];
        } else if (index < 41) {
            return arrayTask2[index];
        } else if (index < 61) {
            return arrayTask3[index];
        } else if (index < 81) {
            return arrayTask4[index];
        } else if (index < 101) {
            return arrayTask5[index];
        } else if (index < 121) {
            return arrayTask6[index];
        } else if (index < 141) {
            return arrayTask7[index];
        } else if (index < 161) {
            return arrayTask8[index];
        } else if (index < 181) {
            return arrayTask9[index];
        } else if (index < 201) {
            return arrayTask10[index];
        } else

            return arrayTask1[0];
    }

    @Override
    public ArrayTaskList incoming(int from, int to) {
        ArrayTaskList array1 = new ArrayTaskListImpl();
        if (count < 21){
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
        } else if (count < 41) {
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

    }
    public ArrayTaskListImpl() {

    };

}

