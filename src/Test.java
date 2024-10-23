import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final int count = 20;
    private static int curCount = 1;

    public static void main(String[] args) {
        new Thread(() -> {

            while (curCount <= count) {
                lock.lock();
                try {
                    while (curCount % 2 == 0) {
                        try {
                            conditionA.await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (curCount > count) break;
                    System.out.println("A");
                    curCount++;
                    conditionB.signal();
                } finally {
                    lock.unlock();
                }
            }

        }).start();

        new Thread(() -> {

            while (curCount <= count) {
                lock.lock();
                try {
                    while (curCount % 2 == 1) {
                        try {
                            conditionB.await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (curCount > count) break;
                    System.out.println("B");
                    curCount++;
                    conditionA.signal();
                } finally {
                    lock.unlock();
                }
            }

        }).start();
    }
}
