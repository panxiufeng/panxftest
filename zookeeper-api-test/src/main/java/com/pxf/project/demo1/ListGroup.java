package com.pxf.project.demo1;

import org.apache.zookeeper.KeeperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ListGroup extends ConnectionWatcher {
    
    private static Logger logger = LoggerFactory.getLogger(ListGroup.class);
    
    public void list(String groupName) throws Exception{
        String path = "/" + groupName;
        try {
            List<String> children= zk.getChildren(path, false);

            if(children.isEmpty()){
                logger.info( path + " is empty");
                System.exit(1);
            }else {
                for (String child : children){
                    logger.info(child);
                }
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        ListGroup listGroup = new ListGroup();
        listGroup.connect(IP+":"+PORT);
        listGroup.list("zoo");
        listGroup.close();
    }
}
