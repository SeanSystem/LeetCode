package stack;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试Synchronized
 *
 * @author by Sean
 * @date 2020/5/13 23:15
 */
public class SyncDemo {

    public synchronized void test() {
        System.out.println("123");
    }

    public void test2() {
        synchronized (SyncDemo.class) {
            System.out.println("123");
        }
    }
}
