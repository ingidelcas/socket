import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Test w1,w2,w3;

        long seed = new Random().nextLong();
        w1 = new Test(1, seed);
        w2 = new Test(2, seed);
        w3 = new Test(3, seed);

        w1.start();
        w2.start();
        w3.start();
    }
}
class Test extends Thread {
    private final int number;
    private final Random rnd;

    public Test(int number, long seed) {
        this.number = number;
        this.rnd = new Random(seed);
    }

    @Override
    public void run() {
        int pom = rnd.nextInt(101);
        System.out.println("Random number: "+pom+", number of thread: "+number);
    }
}
