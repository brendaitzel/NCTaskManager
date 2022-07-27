package mx.tc.j2se.tasks;

import java.time.LocalDateTime;

public interface Task {
    String getTitle();
    void setTitle(String title);
    boolean isActive();
    void setActive(boolean active);
    public LocalDateTime getTime();
    void setTime(LocalDateTime time);
    void setTime(int year, int month, int day, int hour, int minutes, int seconds);

    LocalDateTime getStartTime();
    LocalDateTime getEndTime();
    long getRepeatInterval();

    void setTime(int startYear, int startMonth, int startDay, int startHour, int startMinutes, int startSeconds, int endYear, int endMonth, int endDay, int endHour, int endMinutes, int endSeconds, long interval);

    public boolean isRepeated();

    void taskImpl();


    //Constructor for a non-repetitive task
    public void taskImpl(String title, int year, int month, int day, int hour, int minutes, int seconds);

    void taskImpl(String title, int startYear, int startMonth, int startDay, int startHour, int startMinutes, int startSeconds, int endYear, int endMonth, int endDay, int endHour, int endMinutes, int endSeconds, long interval);

    LocalDateTime nextTimeAfter(LocalDateTime current);
    public LocalDateTime nextTimeAfter (int year, int month, int day, int hour, int minutes, int seconds);
    boolean equals (Object o);
    int hashCode();
    String toString();

}
