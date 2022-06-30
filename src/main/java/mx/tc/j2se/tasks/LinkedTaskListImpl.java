package mx.tc.j2se.tasks;

public class LinkedTaskListImpl implements LinkedTaskList {
    int count;
    private Nodo nstart, end;

    Nodo nnew = new Nodo();
    Task task;

    public void LinkedTaskListImpl() {
        nstart = null;
        count = 0;
    }

    public class Nodo {
        Task task;
        private Nodo npast;
        private Nodo nnext;


        public Task getTask() {

            return task;
        }

        public void setTask(Task task) {
            this.task = task;
        }

        public Nodo getNext() {
            return nnext;
        }

        public void setNext(Nodo nnext) {
            this.nnext = nnext;
        }

    }

    @Override
    public void add(Task task) {
        count++;
        this.task = task;
        Nodo nnew = new Nodo();
        nnew.setTask(task);
        if (nstart == null) {
            nstart = nnew;
        } else { //We have to check if each node is empty
            Nodo aux = nstart;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(nnew);
        }

    }

    @Override
    public boolean remove(Task task) {
        Nodo aux = nstart;
        boolean found = false;
        if (count != 0) {
            if (nstart.getTask() == task) {
                nstart = nstart.getNext();
                count--;
                found = true;
            } else {
                Nodo aux2 = nstart;
                while (aux2.getNext().getTask() != task && aux2 == null) {
                    aux2 = aux2.getNext();
                    if (aux2.getTask() == null) {
                        found = false;
                        throw new IndexOutOfBoundsException("This index is not available");

                    }
                }
                Nodo nnext = aux2.getNext().getNext();
                aux2.setNext(nnext);
                found = true;
                count--;
            }
        }
        return found;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Task getTask(int index) {
        if(index>count-1){
            throw new IndexOutOfBoundsException("This index is not available");}
        if (index == 0) {
            return nstart.getTask();
        } else {
            Nodo aux = nstart;
            for (int i = 0; i < index; i++) {
                aux = aux.getNext();
            }
            return aux.getTask();
        }
    }

    @Override
    public LinkedTaskList incoming(int from, int to) {
        if (from <0 | to<0 | from==to){
            throw new IllegalArgumentException("The number is negative");
        }
        Nodo c = nstart,bf;
        int e, s, inter, t;
        LinkedTaskList linkedList = new LinkedTaskListImpl();
        next:
        while (c != null) {
            if (c.getTask().isRepeated() == false) {
                if (c.getTask().getTime() >= from & c.getTask().getTime() <= to) {
                    linkedList.add(c.getTask());
                    bf=c;
                    c=c.getNext();
                    continue next;
                } else c=c.getNext(); continue next;
            } else {
                e = c.getTask().getEndTime();
                s = c.getTask().getStartTime();
                inter = c.getTask().getRepeatInterval();
                for (int i = s; i <= e; i = i + inter) {
                    if (i >= from & i <= to) {
                        linkedList.add(c.getTask());
                        bf=c;
                        c=c.getNext();
                        continue next;
                    }
                }
                c = c.getNext();
                continue next;


            }
        }
        return linkedList;
    }
    public LinkedTaskListImpl(){};
}
