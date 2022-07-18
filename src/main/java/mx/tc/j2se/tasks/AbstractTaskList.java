package mx.tc.j2se.tasks;

import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract class AbstractTaskList implements Iterable<Task> {
    //LinkedTaskList linkedList = new LinkedTaskListImpl();
    abstract void add(Task task);
    abstract boolean remove(Task task);
    abstract int size();
    abstract Task getTask(int index);
    public abstract Iterator<Task> iterator();
    public abstract boolean equals(Object o);
    public abstract int hashCode();
    public abstract LinkedTaskListImpl cloneLinked();
    public abstract ArrayTaskListImpl cloneArray();
    public abstract Stream<Task> getStream();
    void incoming(int from, int to) { // Incoming method description
        ArrayTaskListImpl inc = new ArrayTaskListImpl(); //We have a collection type ArrayTaskListImpl
        inc.getStream().filter(t->t.getTime()>from && t.getTime()<to).collect(Collectors.toList());//We will get the stream of ArrayTaskList
        //We will use the filter function to condition the creation of a new list with elements that are only within the time determined in the incoming method

    }
}
