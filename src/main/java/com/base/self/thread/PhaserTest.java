package com.base.self.thread;

/**
 * java多线程技术提供了Phaser工具类，
 * Phaser表示“阶段器”，用来解决控制多个线程分阶段共同完成任务的情景问题。
 * 其作用相比CountDownLatch和CyclicBarrier更加灵活，
 * 例如有这样的一个题目：5个学生一起参加考试，一共有三道题，
 * 要求所有学生到齐才能开始考试，全部同学都做完第一题，学生才能继续做第二题，
 * 全部学生做完了第二题，才能做第三题，所有学生都做完的第三题，考试才结束。
 * 分析这个题目：这是一个多线程（5个学生）分阶段问题（考试考试、第一题做完、第二题做完、第三题做完），
 * 所以很适合用Phaser解决这个问题。
 * https://blog.csdn.net/u010739551/article/details/51083004
 * @author libo
 * @package com.base.self.thread
 * @company initcat
 * @date 2019/4/9
 */
public class PhaserTest {

    // https://blog.csdn.net/u010739551/article/details/51083004


}
