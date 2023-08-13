package zhihu.lianbiao;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name main.java.zhihu
 * @date 2022-02-26-14:26
 * @Desc:
 */
public class Singlepattern3 {
    private static Singlepattern3 singlepattern3;

    private Singlepattern3() {
    }

    public static Singlepattern3 getInstance() {
//         第一次创建时才加锁
        if (singlepattern3 == null) {
            synchronized (Singlepattern3.class) {
                if (singlepattern3 == null) {
                    singlepattern3 = new Singlepattern3();
                }
            }
        }
        return singlepattern3;
    }
}
