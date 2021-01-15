package com.lyao.concurrent.pool;

import org.apache.commons.lang.time.StopWatch;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author lyao
 * @date 2019/10/5 9:58
 * @description
 */
public class CountTask extends RecursiveTask {

    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public CountTask(long start, long end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Object compute() {
        long sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (long i = start; i <= end; i++) {
                sum += i;
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return sum;
        }
        long step = (start + end)/100;
        ArrayList<CountTask> subTasks = new ArrayList<>();
        long pos = start;
        for (int i = 0; i < 100; i++) {
            long lastOne = pos + step;
            if (lastOne > end) {
                lastOne = end;
            }
            CountTask countTask = new CountTask(pos, lastOne);
            pos += step + 1;
            subTasks.add(countTask);
            countTask.fork();
        }
        for (CountTask t : subTasks) {
            sum += (long)t.join();
        }
        return sum;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        /*CountTask countTask1 = new CountTask(0, 200000L);
        long a = (long)countTask1.compute();
        stopWatch.split();
        System.out.println(stopWatch.toSplitString());
        System.out.println(a);*/

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(0, 200000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(countTask);
        try {
            long res = result.get();
            stopWatch.split();
            System.out.println(stopWatch.toSplitString());
            System.out.println("sum=" + res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
