package com.localcc.timelapseplugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.Semaphore;

public class LogFile {
    public static LogFile file = new LogFile();
    private File local_file;
    private FileWriter local_file_writer;
    private boolean running = false;
    private Semaphore mutex;
    public LogFile() {
        mutex = new Semaphore(1);
    }

    void start_write() throws IOException {
        if(running) return;
        try {
            mutex.acquire();
            Timestamp timestamp = new Timestamp(new Date().getTime());
            local_file = new File("./timelapse_recording_" + Statics.sdf.format(timestamp) +".dat");
            local_file_writer = new FileWriter(local_file);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            mutex.release();
        }
        running = true;
    }

    void end_write() throws IOException {
        if(!running) return;
        try {
            mutex.acquire();
            local_file_writer.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            mutex.release();
        }
        running = false;
    }

    boolean isRunning() {
        return running;
    }

    void write_data(String data) throws IOException {
        try {
            mutex.acquire();
            local_file_writer.write(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            mutex.release();
        }
    }
}
