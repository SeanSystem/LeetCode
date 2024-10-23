public class Main {

    private static final Object lock = new Object();

    private static final int count = 10;
    private static int curCount = 1;

    public static void main(String[] args) {
        new Thread(() -> {
            while (curCount <= count) {
                synchronized (lock) {
                  while (curCount % 2 == 0) {
                      try {
                          lock.wait();
                      } catch (InterruptedException e) {
                          throw new RuntimeException(e);
                      }
                  }
                  if (curCount > count) break;
                  curCount++;
                  System.out.println("A");
                  lock.notifyAll();
                }
            }
        }).start();

        new Thread(() -> {
            while (curCount <= count) {
                synchronized (lock) {
                    while (curCount % 2 == 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (curCount > count) break;
                    curCount++;
                    System.out.println("B");
                    lock.notifyAll();
                }
            }
        }).start();
    }
}
