package zhihu.lianbiao;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name main.java.zhihu
 * @date 2022-02-26-14:22
 * @Desc:
 */

public class Singlepattern2 {
    private static Singlepattern2 singlepattern2;

    private Singlepattern2() {
    }

    public static Singlepattern2 getInstance() {
//            同步锁
        synchronized (Singlepattern2.class) {
            if (singlepattern2 == null) {
                singlepattern2 = new Singlepattern2();
            }
            return singlepattern2;
        }
    }
}
