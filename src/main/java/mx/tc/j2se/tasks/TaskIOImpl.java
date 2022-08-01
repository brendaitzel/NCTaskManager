package mx.tc.j2se.tasks;

import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Iterator;

public class TaskIOImpl implements TaskIO{
    @Override
    public void writeBinary(AbstractTaskList tasks, OutputStream out) throws IOException {
        Iterator<Task> it = tasks.iterator();
        int activeInt;
        while ((it.hasNext())){
            Task task = it.next();
            long interval= task.getRepeatInterval();
            if (task.isActive()){
                activeInt=1;
            } else
                activeInt=0;
            try {
                if (interval == 0) {
                    out.write(tasks.size());
                    out.write(task.getTitle().length());
                    out.write(task.getTitle().getBytes());
                    out.write(activeInt);
                    out.write((int) interval);
                    out.write(task.getTime().getYear());
                    out.write(task.getTime().getMonthValue());
                    out.write(task.getTime().getDayOfMonth());
                    out.write(task.getTime().getHour());
                    out.write(task.getTime().getMinute());
                    out.write(task.getTime().getSecond());
                } else if (interval != 0) {

                    out.write(tasks.size());
                    out.write(task.getTitle().length());
                    out.write(task.getTitle().getBytes());
                    out.write(activeInt);
                    out.write((int) interval);
                    out.write(task.getStartTime().getYear());
                    out.write(task.getStartTime().getMonthValue());
                    out.write(task.getStartTime().getDayOfMonth());
                    out.write(task.getStartTime().getHour());
                    out.write(task.getStartTime().getMinute());
                    out.write(task.getStartTime().getSecond());
                    out.write(task.getEndTime().getYear());
                    out.write(task.getEndTime().getMonthValue());
                    out.write(task.getEndTime().getDayOfMonth());
                    out.write(task.getEndTime().getHour());
                    out.write(task.getEndTime().getMinute());
                    out.write(task.getEndTime().getSecond());
                }
            }finally {
                out.close();
            }
        }
        out.close();
    }

    @Override
    public void readBinary(AbstractTaskList tasks, InputStream in) throws IOException{
        int size, lengthTitle,active,intervalint=0, yearT, monthT, dayT,hourT,minutesT,secondsT,yearS,monthS, dayS,hourS,minutesS,secondsS,yearE,monthE, dayE,hourE,minutesE,secondsE;
        String title;
        LocalDateTime time, start, end;
        long interval=0;
        Task task=null;
         while(in.available()!=0){
             try {
                 size = in.read();
                 lengthTitle = in.read();
                 title = (String.valueOf(in.read()));
                 task.setTitle(title);
                 active = in.read();
                 if (active == 1) {
                     task.isActive();
                 }
                 intervalint = in.read();
                 interval = intervalint;
                 if (interval == 0) {
                     yearT = in.read();
                     monthT = in.read();
                     dayT = in.read();
                     hourT = in.read();
                     minutesT = in.read();
                     secondsT = in.read();
                     task.setTime(yearT, monthT, dayT, hourT, minutesT, secondsT);
                     time = LocalDateTime.of(yearT, monthT, dayT, hourT, minutesT, secondsT);
                 } else if (interval != 0) {
                     yearS = in.read();
                     monthS = in.read();
                     dayS = in.read();
                     hourS = in.read();
                     minutesS = in.read();
                     secondsS = in.read();
                     yearE = in.read();
                     monthE = in.read();
                     dayE = in.read();
                     hourE = in.read();
                     minutesE = in.read();
                     secondsE = in.read();
                     start = LocalDateTime.of(yearS, monthS, dayS, hourS, minutesS, secondsS);
                     end = LocalDateTime.of(yearE, monthE, dayE, hourE, minutesE, secondsE);
                     task.setTime(yearS, monthS, dayS, hourS, minutesS, secondsS, yearE, monthE, dayE, hourE, minutesE, secondsE, interval);
                 }
                 tasks.add(task);
             } finally {
                 in.close();
             }
         }
         in.close();

    }

    @Override
    public void write(AbstractTaskList tasks, File file) throws IOException {
        Iterator<Task> it = tasks.iterator();
        Task task;
        FileOutputStream filetasks = new FileOutputStream(file);
        ObjectOutputStream objtasks = new ObjectOutputStream(filetasks);
        try {
            while (it.hasNext()) {
                task = it.next();
                objtasks.writeObject(task);
            }
        } finally{
            objtasks.close();
        }
        filetasks.close();
    }

    @Override
    public void read(AbstractTaskList tasks, File file) throws IOException, ClassNotFoundException {
        FileInputStream fileinputTask = new FileInputStream(file);
        ObjectInput objinputTask = new ObjectInputStream(fileinputTask);
        try {
            while (fileinputTask.available() != 0) {
                Task task = (Task) objinputTask.readObject();
                tasks.add(task);
            }
        } finally {
            objinputTask.close();
        }
    }

    @Override
    public void write(AbstractTaskList tasks, Writer out) {
        Iterator<Task> it = tasks.iterator();
        final Gson gson = new Gson();
        while (it.hasNext()) {
            Task task = it.next();
            final String representacionJSON = gson.toJson(task);
            try {
                out.write(representacionJSON);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void read(AbstractTaskList tasks, Reader in) {
        Gson gson = new Gson();

    }

    @Override
    public void writeText(AbstractTaskList tasks, File file) {

    }

    @Override
    public void readText(AbstractTaskList tasks, File file) {

    }

}
