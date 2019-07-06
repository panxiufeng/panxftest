package com.pxf.project.demo2;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ZooKeeperOperator extends AbstractZooKeeper  {

    private static Logger logger = LoggerFactory.getLogger(ZooKeeperOperator.class);

    /**
     *
     *<b>function:</b>创建持久态的znode,比支持多层创建.比如在创建/parent/child的情况下,无/parent.无法通过 
     *@createDate 2013-01-16 15:08:38
     *@param path
     *@param data
     *@throws KeeperException
     *@throws InterruptedException
     */
    public void create(String path,byte[] data)throws KeeperException, InterruptedException{
        /**
         * 此处采用的是CreateMode是PERSISTENT  表示The znode will not be automatically deleted upon client's disconnect. 
         * EPHEMERAL 表示The znode will be deleted upon the client's disconnect. 
         */
        this.zooKeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    /**
     *  设置节点值
     * @param path
     * @param data
     * @param version
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void setData(String path,byte[] data,int version)throws KeeperException, InterruptedException{
        this.zooKeeper.setData(path, data, version);
    }


    /**
     * 是否存在节点
     * @param path
     * @param watch
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public Stat exists(String path, boolean watch)throws KeeperException, InterruptedException{
        Stat stat = this.zooKeeper.exists(path,watch);
        return stat;
    }


    /**
     *
     *<b>function:</b>获取节点信息 
     *@createDate 2013-01-16 15:17:22
     *@param path
     *@throws KeeperException
     *@throws InterruptedException
     */
    public void getChild(String path) throws KeeperException, InterruptedException{
        try{
            List<String> list=this.zooKeeper.getChildren(path, false);
            if(list.isEmpty()){
                System.out.println(path+"中没有节点");
            }else{
                System.out.println(path+"中存在节点");
                for(String child:list){
                    System.out.println("节点为："+child);
                }
            }
        }catch (KeeperException.NoNodeException e) {
            throw e;
        }
    }

    public byte[] getData(String path) throws KeeperException, InterruptedException {
        return  this.zooKeeper.getData(path, false,null);
    }

    public static void main(String[] args) {
        try {
            ZooKeeperOperator zkoperator             = new ZooKeeperOperator();
            zkoperator.connect("10.53.153.129:2181");

            byte[] data = new byte[]{'a','b','c','d'};

//            zkoperator.create("/zz","root data".getBytes());
//            System.out.println(Arrays.toString(zkoperator.getData("/zz")));

//            zkoperator.create("/zz/child1",data);
//            System.out.println(Arrays.toString(zkoperator.getData("/zz/child1")));

//            zkoperator.create("/zz/child2",data);
//            System.out.println(Arrays.toString(zkoperator.getData("/zz/child2")));

//            String zktest="ZooKeeper的Java API测试";
//            zkoperator.create("/zz/child3", zktest.getBytes());
//            System.out.println("获取设置的信息："+new String(zkoperator.getData("/zz/child3")));

//            //修改子目录节点数据  version 为 -1 可以匹配任何版本
//            zkoperator.setData("/zz/child1","hahahahahafhfdsgdfdg".getBytes(),-1);
//            byte[] datas = zkoperator.getData("/zz/child1");
//            String str = new String(datas,"utf-8");
//            System.out.println("setData --->"+str);

//            System.out.println("节点孩子信息:");
//            zkoperator.getChild("/zz");

            Stat stat = zkoperator.exists("/zz/aa", true);
            System.out.println("----->"+stat);




            zkoperator.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
