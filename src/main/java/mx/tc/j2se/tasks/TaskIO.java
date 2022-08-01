package mx.tc.j2se.tasks;

import java.io.*;

public interface TaskIO {
    void writeBinary(AbstractTaskList tasks, OutputStream out) throws IOException;
    void readBinary(AbstractTaskList tasks, InputStream in) throws IOException, ClassNotFoundException;
    void write(AbstractTaskList tasks, File file) throws IOException;
    void read(AbstractTaskList tasks, File file) throws IOException, ClassNotFoundException;
    void write(AbstractTaskList tasks, Writer out);
    void read(AbstractTaskList tasks, Reader in);
    void writeText(AbstractTaskList tasks, File file);
    void readText(AbstractTaskList tasks, File file);

}
