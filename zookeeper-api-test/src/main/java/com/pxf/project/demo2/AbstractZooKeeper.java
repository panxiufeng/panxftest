package com.pxf.project.demo2;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class AbstractZooKeeper implements Watcher {

    private static Logger logger = LoggerFactory.getLogger(AbstractZooKeeper.class);

    //缓存时间
    private static final int SESSION_TIME   = 200000;
    protected ZooKeeper zooKeeper;
    protected CountDownLatch countDownLatch=new CountDownLatch(1);

    public void connect(String hosts) throws IOException, InterruptedException{
        zooKeeper = new ZooKeeper(hosts,SESSION_TIME,this);
        countDownLatch.await();
    }

    public void process(WatchedEvent event) {
        if(event.getState()==Event.KeeperState.SyncConnected){
            countDownLatch.countDown();
        }
    }

    public void close() throws InterruptedException{
        zooKeeper.close();
    }
}
