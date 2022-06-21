package mx.tc.j2se.tasks;

public class TaskImpl implements Task {
   String title;
   int time;
   boolean active;
   int start;
   int end;
   int interval;
   int current;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;

    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int getTime() {
        if (this.interval==0)
                return time;
        else
                return start;
    }

    @Override
    public void setTime(int time) {
        interval=0; //The task become non-repetitive
        this.time=time;

    }

    @Override
    public int getStartTime() {
        if (this.interval==0) //The task is non-repetitive
                return time;
        else
                return start; //The task is repetitive
    }

    @Override
    public int getEndTime() {
        if (this.interval==0) //The task is non-repetitive
                return time;
        else
                return end; //The task is repetitive
    }

    @Override
    public int getRepeatInterval() {
        if (this.interval==0) //The task is non-repetitive
                return 0;
        else
                return interval; //The task is repetitive;
    }

    @Override
    public void setTime(int start, int end, int interval) {
        this.start=start;
        this.end=end;
        this.interval=interval;
    }

    @Override
    public boolean isRepeated() {
        return interval != 0;

    }
    //Constructor
    @Override
    public void taskImpl() {

    }
    //Constructor for a non-repetitive task
    @Override
    public void taskImpl(String title, int time) {
        interval=0;
        setTitle(title);
        setTime(time);
        getTitle();

    }
    //Constructor for a repetitive task.
    @Override
    public void taskImpl(String title, int start, int end, int interval) {
        setTitle(title);
        setTime(start,end,interval);
        getTitle();

    }

    @Override
    public int nextTimeAfter(int current) {
    int  i;
    i=start;
    if (active==true)

            if (this.interval==0)
                    if(current < time)
                            return time;
                    else
                         return -1;
            else
                for (int start; i < end; i=i+interval){
                        if (current < i)
                                return i;
                }

                return -1;

    }

}
