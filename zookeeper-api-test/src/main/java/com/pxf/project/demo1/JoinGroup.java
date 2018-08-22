package com.pxf.project.demo1;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class JoinGroup  extends ConnectionWatcher {

    private static Logger logger = LoggerFactory.getLogger(JoinGroup.class);

    public void join(String groupName, String menberName) throws Exception{
        String path = "/" + groupName + "/" + menberName;
        String createdPath = zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        logger.info("-------------> created " + createdPath );
    }


    public static void main(String[] args) throws Exception {
        JoinGroup joinGroup = new JoinGroup();
        joinGroup.connect(IP+":"+PORT);
        joinGroup.join("zoo", "cow");
        TimeUnit.MICROSECONDS.sleep(Long.MAX_VALUE);
    }

}
