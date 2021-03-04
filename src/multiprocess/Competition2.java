package multiprocess;

/**
 * @author Eightn0
 * @create 2021-03-04 11:30
 */
public class Competition2 {
    public static void main(String[] args) {
        Turtle2 turtle2 = new Turtle2();
        Rabbit2 rabbit2 = new Rabbit2();

        Thread t1 = new Thread(turtle2);
        Thread t2 = new Thread(rabbit2);

        t1.setName("turtle2");
        t2.setName("rabbit2");

        t1.start();
        t2.start();

    }
}

//乌龟跑步
class Turtle2 implements Runnable{
    @Override
    public void run() {
        for (int i = 100; i >= 0; i--) {
            if (i % 10 == 0){
                System.out.println(Thread.currentThread().getName()+"还剩"+i+"米到终点");}
        }
    }
}

//兔子跑步
class Rabbit2 implements Runnable{
    @Override
    public void run() {
        for (int i = 100; i >= 0; i--) {
            if (i % 10 == 0){
                System.out.println(Thread.currentThread().getName()+"还剩"+i+"米到终点");}
        }
    }
}
