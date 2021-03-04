package multiprocess;

/**
 * @author Eightn0
 * @create 2021-03-03 15:57
 * 功能：定义两个线程（一个用继承Thread类，一个用实现Runnable接口），
 *      定义一个测试类包括一个主函数调用两个子线程（具体实现自定）
 */

public class MyThread{
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        Mythread2 t2 = new Mythread2();
        Thread tt2 = new Thread(t2);

        t1.setName("线程一");
        tt2.setName("线程二");

        t1.start();
        tt2.start();
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("I'm thread one. From: "+Thread.currentThread().getName());

    }
}
class Mythread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("I'm thread two. From: "+Thread.currentThread().getName());
    }
}
