package zhihu.lianbiao;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name main.java.zhihu
 * @date 2022-02-26-14:34
 * @Desc:
 */
public class Singlepattern5 {

    public Singlepattern5() {
    }

    //    使用一个静态类来创建Singleton，其他静态方法只要没有调用Nested.singletonImp6就不会创建Singleton
    private static class Newted {
        private static Singlepattern5 singlepattern5;

        static {
            singlepattern5 = new Singlepattern5();
        }
    }

    public static Singlepattern5 getInstance() {
        return Newted.singlepattern5;
    }

    public static void begin() {

    }

    public static void main(String[] args) {
        System.out.println(Singlepattern5.getInstance());
    }
}
