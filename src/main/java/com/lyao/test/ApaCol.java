package com.lyao.test;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lyao
 * @date 2018/2/6 10:08
 */
public class ApaCol {
    public String d = "";

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        ApaCol a = new ApaCol();
        a.testM("");
        a.testDo();
        System.out.println(Thread.currentThread().getName());
    }

    public void testDo(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,3,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new ThreadFactory()
                {
                    AtomicInteger atomic = new AtomicInteger();
                    public Thread newThread(Runnable runnable)
                    {
                        return new Thread(runnable, "BCardSale-PictureCache-Thread-" + this.atomic.getAndIncrement());
                    }
                });

        Runnable testRunnable = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " run");
                    testM(d);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        executor.execute(testRunnable);
        System.out.println("继续执行其它事务");
    }

    public void testM(String d){
        System.out.println("dfadfad");
        System.out.println(Thread.currentThread().getName());
    }
}
