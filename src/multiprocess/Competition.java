package multiprocess;

/**
 * @author Eightn0
 * @create 2021-03-04 11:04
 * 功能：编写龟兔赛跑多线程程序，设赛跑长度为100米，每跑完10米输出一次结果。
 */
public class Competition {
    public static void main(String[] args) {
        Turtle turtle = new Turtle();
        Rabbit rabbit = new Rabbit();

        Thread t1 = new Thread(turtle);
        Thread t2 = new Thread(rabbit);

        t1.setName("turtle");
        t2.setName("rabbit");

        t1.start();
        t2.start();

    }
}

//乌龟跑步
class Turtle implements Runnable{
    @Override
    public void run() {
        for (int i = 100; i >= 0; i--) {
            if (i % 10 == 0){
            System.out.println(Thread.currentThread().getName()+"还剩"+i+"米到终点");}
        }
    }
}

//兔子跑步
class Rabbit implements Runnable{
    @Override
    public void run() {
        for (int i = 100; i >= 0; i--) {
            if (i % 10 == 0){
            System.out.println(Thread.currentThread().getName()+"还剩"+i+"米到终点");}
        }
    }
}
