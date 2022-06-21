package mx.tc.j2se.tasks;

public interface Task {
    String getTitle();
    void setTitle(String title);
    boolean isActive();
    void setActive(boolean active);
    int getTime();
    void setTime(int time);
    int getStartTime();
    int getEndTime();
    int getRepeatInterval();
    void setTime(int start, int end, int interval);
    boolean isRepeated();
    public void taskImpl();
    public void taskImpl(String title, int time);
    public void taskImpl(String title, int start, int end, int interval);

    int nextTimeAfter(int current);
}
