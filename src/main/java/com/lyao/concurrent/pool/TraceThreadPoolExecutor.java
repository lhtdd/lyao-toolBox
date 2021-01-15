package com.lyao.concurrent.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lyao
 * @date 2019/10/4 15:02
 * @description
 * 扩展了线程池，可以将线程中的异常堆栈进行打印，方便排查问题
 */
public class TraceThreadPoolExecutor extends ThreadPoolExecutor{

    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
                                   long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue){
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable command) {
        super.execute(command);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task, clientTrace(), Thread.currentThread().getName()));
    }

    private Exception clientTrace(){
        return new Exception("Client stack trace");
    }

    private Runnable wrap(final Runnable task, final Exception clientStack, String clientThreadName){
        return () -> {
            try {
                task.run();
            }catch (Exception e){
                clientStack.printStackTrace();
                throw e;
            }
        };
    }
}
