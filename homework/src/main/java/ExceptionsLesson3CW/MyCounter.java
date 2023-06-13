package ExceptionsLesson3CW;

import java.io.IOException;

public class MyCounter implements AutoCloseable{
    private int count;
    private boolean isClosed;

    public MyCounter(int count){
        this.count = count;
        this.isClosed = false;
    }

    public void add() throws IOException{
        if (isClosed) throw new IOException();
        this.count++;
    }

    @Override
    public void close() throws Exception {
        this.isClosed = true;
    }

    @Override
    public String toString(){
        return Integer.toString(this.count);

    }
}
