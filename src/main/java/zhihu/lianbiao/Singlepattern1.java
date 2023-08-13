package zhihu.lianbiao;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name main.java.zhihu
 * @date 2022-02-26-14:08
 * @Desc:
 */


public class Singlepattern1 {
    //2-通过new在代码内部创建一个（唯一）的static实例对象
    private static Singlepattern1 singlepattern1 = new Singlepattern1();

    //    1-构造函数私有化（private）
    private Singlepattern1() {
    }

    //    定义一个public static的公有静态方法，返回上一步中创建的实例对象
    public static Singlepattern1 getInstance() {
        return singlepattern1;
    }
    public static void main(String[] args) {
        System.out.println(Singlepattern1.getInstance());
    }


}












