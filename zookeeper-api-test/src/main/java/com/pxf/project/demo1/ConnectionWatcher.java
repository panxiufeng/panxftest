package com.pxf.project.demo1;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * @auther: panxiufeng
 * @date: 2018/8/22 16:59
 * @Description: 在 Zookeeper 中新建组 : /zoo
 */
public class ConnectionWatcher implements Watcher {

    private static Logger logger = LoggerFactory.getLogger(ConnectionWatcher.class);
    private static final int SESSION_TIMEOUT = 5000;

    protected ZooKeeper zk;
    private CountDownLatch connectedSignal = new CountDownLatch(1);

    protected static final String IP = "127.0.0.1";
    protected static final int PORT = 2181;


    public void connect(String hosts) throws Exception{
        //传入: 主机地址; 会话超时参数; Watcher对象,用于接收来自zookeeper的回调,获得各种事件的通知.
        //内部会创建一个线程连接到服务器;
        zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
        //等待连接成功的响应.
        connectedSignal.await();
    }

    // 当客户端与服务端建立成功之后, watcher 的 process()方法会被调用. 参数是一个用于表示该连接的事件.
    public void process(WatchedEvent event) {
        //返回响应, 表示连接已经成功
        if(event.getState() == Event.KeeperState.SyncConnected){
            connectedSignal.countDown();
        }
    }

    public void close() throws Exception{
        zk.close();
    }

}
