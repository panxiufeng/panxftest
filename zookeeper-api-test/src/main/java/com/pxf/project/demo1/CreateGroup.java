package com.pxf.project.demo1;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateGroup  extends  ConnectionWatcher{

    private static Logger logger = LoggerFactory.getLogger(ConnectionWatcher.class);

    /**
     * 创建一个新的 Zookeeper 的 znode,
     * @param groupName
     * @throws Exception
     */
    public void create(String groupName,byte[] data) throws Exception{
        String path = "/" + groupName;
        String createdPath = zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("created " + createdPath);
    }



    // main
    public static void main(String[] args) throws Exception {
        CreateGroup createGroup = new CreateGroup();
        createGroup.connect(IP+":"+PORT);
        createGroup.create("zoo","zoo data".getBytes());
        createGroup.close();
    }

}
