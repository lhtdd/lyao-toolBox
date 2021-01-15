package com.lyao.concurrent.pool;


import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author lyao
 * @date 2019/10/5 11:02
 * @description
 */
public class BusiTask extends RecursiveTask {

    public static ArrayList<String> dataList;
    // 界限
    private static final int THRESHOLD = 100;
    private static final int FORKS = 10;
    private int start;
    private int end;

    public BusiTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Object compute() {
        int result = 1;
        int length = end - start;
        boolean justDoIt = length <= THRESHOLD;
        if (justDoIt) {
            for (int i = start; i <= end; i++) {
                System.out.println(i);
            }
        } else {
            int step = (start + end) / FORKS;
            int batch = ((start + end) % FORKS != 0) ? (FORKS + 1) : FORKS;
            ArrayList<BusiTask> subTasks = new ArrayList<>();
            int pos = start;
            for (int i = 0; i < batch; i++) {
                int lastOne = pos + step - 1;
                if (lastOne > end) {
                    lastOne = end;
                }
                BusiTask busiTask = new BusiTask(pos, lastOne);
                subTasks.add(busiTask);
                busiTask.fork();
                pos += step;
            }
            for (BusiTask t : subTasks) {
                result += (Integer)t.join();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 组织数据
        ArrayList<String> dataList = new ArrayList<>();

        for (int i = 0; i < 102; i++) {
            dataList.add(String.valueOf(i));
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        BusiTask.dataList = dataList;
        BusiTask busiTask = new BusiTask(0, dataList.size()-1);
        ForkJoinTask<Integer> result = forkJoinPool.submit(busiTask);
        try {
            int res = result.get();
            System.out.println("result =" + res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
