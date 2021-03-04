package multiprocess;

/**
 * @author Eightn0
 * @create 2021-03-03 16:35
 * 功能：模拟一个人生产50个玩具，每200毫秒生产一个，
 *      当生产到第20个时加入每秒吃1个馒头，共吃完3个后在接着生产的多线程。
 */

public class WorkerWork {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Produce produce = new Produce(manager);
        Eat eat = new Eat(manager);

        produce.start();
        eat.start();
    }
}

//主管控制生产和消费
class Manager {
    boolean isflag = true;

    //玩具的生产方法
    public synchronized void produceToll() {
        for (int i = 1; i <= 50; i++) {
            if (i == 21) {
                isflag = false;
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产了一个玩具，目前个数为：" + i);
        }
        }
    }

        //馒头的发放方法
        public synchronized void eatCookie() {
            if (!isflag) {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("吃了第" + i + "个馒头");
                }
                this.notify();
            }
        }
}

//生产玩具线程
class Produce extends Thread{
    private Manager manager;

    public Produce(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"你工人爷爷开始生产玩具");
        manager.produceToll();
    }
}

//吃馒头线程
class Eat extends Thread{
    private Manager manager;

    public Eat(Manager manager) {
        this.manager = manager;
    }
    @Override
    public void run() {
        manager.eatCookie();
    }
}

