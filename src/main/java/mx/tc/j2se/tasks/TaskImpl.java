package mx.tc.j2se.tasks;

import java.time.LocalDateTime;

public class TaskImpl implements Task {
    String title;
    int year, month, day, hour, minutes, seconds;

    boolean active;
    LocalDateTime start;
    LocalDateTime current;
    LocalDateTime end;
    LocalDateTime time;
    LocalDateTime min = LocalDateTime.of(-999999999, 01, 01, 00, 00, 00);
    long interval;

    // Iterator<Task> T;


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
    public LocalDateTime getTime() {
        if (this.interval == 0) {
            return time;
        } else
            return start;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;

    }

    @Override
    public void setTime(int year, int month, int day, int hour, int minutes, int seconds) {
        if(year<0|month<0|day<=0|hour<0|minutes<0|seconds<0){
            throw new IllegalArgumentException("You can't set negative numbers");
        }
        time = LocalDateTime.of(year, month, day, hour, minutes, seconds);
        setTime(time);
        setTime(time);
        active=true;

    }

    public void setTime(LocalDateTime start, LocalDateTime end, long interval) {
        this.start = start;
        this.end = end;
        this.interval = interval;
        isRepeated();
    }

    @Override
    public LocalDateTime getStartTime() {
        if (this.interval == 0) //The task is non-repetitive
            return time;
        else
            return start; //The task is repetitive
    }

    @Override
    public LocalDateTime getEndTime() {
        if (this.interval == 0) //The task is non-repetitive
            return time;
        else
            return end;//The task is repetitive
    }

    @Override
    public long getRepeatInterval() {
        if (this.interval == 0) //The task is non-repetitive
            return 0;
        else
            return interval; //The task is repetitive;
    }

    @Override
    public void setTime(int startYear, int startMonth, int startDay, int startHour, int startMinutes, int startSeconds, int endYear, int endMonth, int endDay, int endHour, int endMinutes, int endSeconds, long interval) {
        if (startYear<0|startMonth<=0|startDay<=0|startHour<0|startMinutes<0|startSeconds<0|endYear<0|endMonth<=0|endDay<=0|endHour<0|endMinutes<0|endSeconds<0|interval<=0){
            throw new IllegalArgumentException("You can't set negative numbers");
        }

        start = LocalDateTime.of(startYear, startMonth, startDay, startHour, startMinutes, startSeconds);
        end = LocalDateTime.of(endYear, endMonth, endDay, endHour, endMinutes, endSeconds);
        this.interval = interval;
        setTime(start, end, interval);
        active=true;
        isRepeated();
    }

    @Override
    public boolean isRepeated() {

        return this.interval != 0;

    }

    //Constructor
    @Override
    public void taskImpl() {
    }

    //Constructor for a non-repetitive task
    @Override
    public void taskImpl(String title, int year, int month, int day, int hour, int minutes, int seconds) {
        interval = 0;
        setTitle(title);
        setTime(year, month, day, hour, minutes, seconds);
    }

    //Constructor for a repetitive task.
    @Override
    public void taskImpl(String title, int startYear, int startMonth, int startDay, int startHour, int startMinutes, int startSeconds, int endYear, int endMonth, int endDay, int endHour, int endMinutes, int endSeconds, long interval) {
        this.title = title;
        setTitle(title);
        setTime(startYear, startMonth, startDay, startHour, startMinutes, startSeconds, endYear, endMonth, endDay, endHour, endMinutes, endSeconds, interval);
    }

    public LocalDateTime nextTimeAfter(int afYear, int afMonth, int afDay, int afHour, int afMinutes, int afSeconds) {

        LocalDateTime current;
        current = LocalDateTime.of(afYear, afMonth, afDay, afHour, afMinutes, afSeconds);
        this.current = current;
        return nextTimeAfter(current);
    }


    @Override
    public LocalDateTime nextTimeAfter(LocalDateTime current) {
        LocalDateTime  comp;
        comp=start;
        if (active==true)

            if (this.interval==0) {
                if (current .isBefore(time)) {
                    active = true;
                    return time;
                } else
                    active = false;
                return min;
            }else
                for (comp=start; comp.isBefore(end)| comp.isEqual(end); comp=comp.plusHours(interval)){
                    if (comp.isAfter(current))
                        return comp;
                }

        return min;

    }




    @Override
    public boolean equals(Object o){
        if (o==null){
            return false;
        } else if (o instanceof Task) {
            Task taskcomp = (Task) o;
            if (this.isRepeated()==taskcomp.isRepeated()){
                if(this.getTitle()==taskcomp.getTitle()&&this.getStartTime().equals(taskcomp.getStartTime())&&this.getEndTime().equals(taskcomp.getEndTime())&&this.getRepeatInterval()== taskcomp.getRepeatInterval()){
                return true;}
                return false;
            } else
                return false;
        } else
            return true;

    }
    @Override
     public int hashCode(){
        final int ran=8;
        int result=1;
        if(interval==0){
            result=ran*result+((title==null )?0: title.hashCode()+time.hashCode());}
        else
            result=result=ran*result+((title==null )?0: title.hashCode()+ start.hashCode()+ end.hashCode());
        return result;
    }

    @Override

    public String toString(){
        if (isRepeated())
        return "Title: "+title+" " + "Start: " +start+" "+ "End: " +end+ " "+"Interval: "+ interval;
    else return "Title: "+title+" " + "Time: " +time;
    }

}

