package com.yxt.cloud.util;

import com.alibaba.nacos.common.executor.ExecutorFactory;
import com.alibaba.nacos.common.executor.NameThreadFactory;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerStats;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
//        test();

        ScheduledExecutorService s = ExecutorFactory.newSingleScheduledExecutorService(
                new NameThreadFactory("upgrading.checker"));
        s.scheduleAtFixedRate(() -> {
            extracted();
        }, 100L, 200L, TimeUnit.MILLISECONDS);

    }

    private static void extracted() {
        System.out.println("111")
        ;
    }

    private static void test() {
        ServerStats ss = new ServerStats();
        ss.setBufferSize(1000);
        ss.setPublishInterval(1000);
        ss.initialize(new Server("stonse", 80));

        Random r = new Random(1459834);
        for (int i=0; i < 99; i++){
            double rl = r.nextDouble() * 25.2;
            ss.noteResponseTime(rl);
            ss.incrementNumRequests();
            try {
                Thread.sleep(100);
                System.out.println("ServerStats:avg:" + ss.getResponseTimeAvg());
                System.out.println("ServerStats:90 percentile:" + ss.getResponseTime90thPercentile());
                System.out.println("ServerStats:90 percentile:" + ss.getResponseTimePercentileNumValues());

            } catch (InterruptedException e) {

            }

        }
        System.out.println("done ---");
        //        ss.publisher.stop();

        System.out.println("ServerStats:" + ss);
    }
}
