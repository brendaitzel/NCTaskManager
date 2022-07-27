package mx.tc.j2se.tasks;
import java.time.LocalDateTime;
import java.util.*;

public class Tasks {


    public Tasks() {

    }

    static Iterator<Task> incoming(Iterator<Task> tasks, LocalDateTime start, LocalDateTime end) {
        Iterator<Task> it = null;
        long interval;
        Task task, taskComp;
        LocalDateTime time, starttask, endtask, comp;
        LinkedTaskListImpl array = new LinkedTaskListImpl();
        while (tasks.hasNext()) {
            task = tasks.next();
            interval = task.getRepeatInterval();
            if (interval == 0) {
                time = task.getTime();
                if (time.isAfter(start) & time.isBefore(end)) {
                    array.add(task);
                }
            } else if (interval != 0) {
                starttask = task.getStartTime();
                endtask = task.getEndTime();
                interval = task.getRepeatInterval();
                for (comp = starttask; comp.isBefore(endtask) | comp.isEqual(endtask); comp = comp.plusHours(interval)) {
                    if (comp.isAfter(start) & comp.isBefore(end)) {
                        array.add(task);
                        break;
                    }
                }

            }
        }
        return it = array.iterator();
    }


    static SortedMap<LocalDateTime, Set<Task>> calendar(Iterator<Task> tasks, LocalDateTime start, LocalDateTime end) {
        SortedMap<LocalDateTime, Set<Task>> tasksmap=null;
        Set<Task> setTask=null;
        Task task,taskComp;
        long interval,intervalComp;
        LocalDateTime comp, time, startTaskCopm, endTaskComp,timeComp,startTask,endTask,comp1;
        while(tasks.hasNext()){
            task=tasks.next();
            Iterator<Task> itComp=tasks;
            interval = task.getRepeatInterval();
            if (interval==0){
                time=task.getTime();
                if (time.isAfter(start)& time.isBefore(end)){
                    while (itComp.hasNext()){
                        taskComp=itComp.next();
                        intervalComp= taskComp.getRepeatInterval();
                        if(intervalComp==0){
                            timeComp=taskComp.getTime();
                            if(time==timeComp){
                                setTask.add(taskComp);
                            }
                        } else if (intervalComp!=0){
                            startTaskCopm=taskComp.getStartTime();
                            endTaskComp=taskComp.getEndTime();
                            for (comp = startTaskCopm; comp.isBefore(endTaskComp) | comp.isEqual(endTaskComp); comp = comp.plusHours(intervalComp)){
                                if(comp==time){
                                    setTask.add(taskComp);
                                    break;
                                }
                            }
                        }
                    } tasksmap.put(time,setTask);
                    setTask=null;
                }
            } else if (interval!=0) {
                startTask=task.getStartTime();
                endTask=task.getEndTime();
                for (comp1 = startTask; comp1.isBefore(endTask) | comp1.isEqual(endTask); comp1 = comp1.plusHours(interval)){
                    if(comp1.isAfter(start)& comp1.isBefore(end)){
                        while (itComp.hasNext()){
                            taskComp=itComp.next();
                            intervalComp= taskComp.getRepeatInterval();
                            timeComp=taskComp.getTime();
                            if(intervalComp==0){
                                if(comp1==timeComp){
                                    setTask.add(taskComp);
                                }
                            } else if (intervalComp!=0){
                                startTaskCopm=taskComp.getStartTime();
                                endTaskComp=taskComp.getEndTime();
                                for (comp = startTaskCopm; comp.isBefore(endTaskComp) | comp.isEqual(endTaskComp); comp = comp.plusHours(intervalComp)){
                                    if(comp==comp1){
                                        setTask.add(taskComp);
                                        break;
                                    }
                                }
                            }
                        } tasksmap.put(comp1,setTask);
                    }
                    setTask=null; }
            }
        }
        return tasksmap;
    }
}