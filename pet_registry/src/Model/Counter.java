package Model;

public class Counter implements AutoCloseable{
    private static int count = 0;

    public void add(){
        count++;
    }

    public static int getCount(){return count;}

    @Override
    public void close() throws Exception {
    }
}
