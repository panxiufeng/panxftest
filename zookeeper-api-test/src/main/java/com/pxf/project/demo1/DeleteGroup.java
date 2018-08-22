package com.pxf.project.demo1;

import org.apache.zookeeper.KeeperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DeleteGroup extends ConnectionWatcher {

    private static Logger logger = LoggerFactory.getLogger(DeleteGroup.class);
    
    public void delete(String groupName) throws Exception{

        String path = "/" + groupName;
        try {
            List<String> children= zk.getChildren(path, false);
            for (String child : children){
                zk.delete(path + "/" + child, -1);
            }
            zk.delete(path, -1);
        } catch (KeeperException.NoNodeException e) {
            e.printStackTrace();
            logger.info(groupName + " is not existed");
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        DeleteGroup deleteGroup = new DeleteGroup();
        deleteGroup.connect(IP+":"+PORT);
        deleteGroup.delete("zoo");
        deleteGroup.close();
    }
}
