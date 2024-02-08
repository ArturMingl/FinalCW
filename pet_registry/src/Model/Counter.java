package Model;

public class Counter implements AutoCloseable {
    private static int count;

    public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Ресурс закрыт");
    }
}
