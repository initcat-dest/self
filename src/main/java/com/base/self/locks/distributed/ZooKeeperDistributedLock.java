package com.base.self.locks.distributed;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * zookeeper 分布式锁
 * 如果有一把锁，被多个人给竞争，此时多个人会排队，第一个拿到锁的人会执行，然后释放锁，后面的每个人都会去监听排在自己前面的那个人创建的node上，
 * 一旦某个人释放了锁，排在自己后面的人就会被zookeeper给通知，一旦被通知了之后，就ok了，自己就获取到了锁，就可以执行代码了
 *
 * @author libo
 * @package com.base.self.locks.distributed
 * @company initcat
 * @date 2020/6/4
 */
public class ZooKeeperDistributedLock implements Watcher {

    private ZooKeeper zk;
    private String locksRoot = "/locks";
    private String productId;
    private String waitNode;
    private String lockNode;
    private CountDownLatch deleteEventCountDownLatch;
    private CountDownLatch connectedLatch = new CountDownLatch(1);
    private int sessionTimeout = 30000;

    public ZooKeeperDistributedLock(String productId) {
        this.productId = productId;
        try {
            String address = "127.0.0.1:2181";
            zk = new ZooKeeper(address, sessionTimeout, this);
            connectedLatch.await();
        } catch (Exception e) {
            throw new LockException(e);
        }
    }

    @Override
    public void process(WatchedEvent event) {
        if (Objects.nonNull(this.deleteEventCountDownLatch) && Event.EventType.NodeDeleted.equals(event.getType())) {
            System.out.println(">>>>>>>>>>>>.监听到节点删除事件，开始获取锁");
            this.deleteEventCountDownLatch.countDown();
            return;
        }

        if (Event.KeeperState.SyncConnected.equals(event.getState()) && connectedLatch.getCount() > 0) {
            System.out.println(">>>>>>>>>>>>.zk链接成功");
            connectedLatch.countDown();
        }
    }

    public void acquireDistributedLock() {
        try {
            if (this.tryLock()) {
                System.out.println(">>>>>>>>>>>>>>.获取成功");
            } else {
                System.out.println(">>>>>>>>>>>>>>.等待通知");
                waitForLock(waitNode, sessionTimeout);
            }
        } catch (Exception e) {
            throw new LockException(e);
        }
    }

    private boolean tryLock() {
        try {
            lockNode = zk.create(locksRoot + "/" + productId, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

            // 看看刚创建的节点是不是最小的节点
            List<String> locks = zk.getChildren(locksRoot, false);
            Collections.sort(locks);
            if (lockNode.equals(locksRoot + "/" + locks.get(0))) {
                // 如果是最小的节点,则表示取得锁
                return true;
            }

            // 如果不是最小的节点，找到比自己小1的节点
            int previousLockIndex = -1;
            for (int i = 0; i < locks.size(); i++) {
                if (lockNode.equals(locksRoot + "/" + locks.get(i))) {
                    previousLockIndex = i - 1;
                    break;
                }
            }
            // 监听节点
            this.waitNode = locks.get(previousLockIndex);
            System.out.println(">>>>>>监听节点：" + this.waitNode);
        } catch (Exception e) {
            throw new LockException(e);
        }
        return false;
    }

    private boolean waitForLock(String waitNode, long waitTime) throws InterruptedException, KeeperException {
        // 检查监听节点是否存在
        Stat stat = zk.exists(locksRoot + "/" + waitNode, true);
        // 如果存在则等待监听节点的删除事件
        if (stat != null) {
            this.deleteEventCountDownLatch = new CountDownLatch(1);
            this.deleteEventCountDownLatch.await(waitTime, TimeUnit.MILLISECONDS);
            // 监听节点推送了删除事件，就认为获得了锁
            this.deleteEventCountDownLatch = null;
            // 不需要再去调用tryLock 再调用一次，就会在创建一个新的节点
        }
        return true;
    }

    public void unlock() {
        try {
            System.out.println(">>>>>>.删除节点unlock " + lockNode);
            zk.delete(lockNode, -1);
            lockNode = null;
            zk.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class LockException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        LockException(Exception e) {
            super(e);
        }
    }

}



