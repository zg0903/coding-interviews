package zhihu.lianbiao;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name main.java.zhihu
 * @date 2022-02-26-14:29
 * @Desc:
 */
public class Singlepattern4 {
    private static Singlepattern4 singlepattern4;

    public Singlepattern4() {
    }
//静态代码块只在类加载的时候调用一次（静态方法调用等第一次用到该类的时候）
    static {
        singlepattern4 = new Singlepattern4();
    }
    public static Singlepattern4 getInstance(){
        return singlepattern4;
    }
    public static void begin(){

    }

    public static void main(String[] args) {
//        缺点  用任意静态方法，都会创建实例，导致过早创建
        Singlepattern4.begin();
        System.out.printf(String.valueOf(Singlepattern4.singlepattern4));
    }
}
