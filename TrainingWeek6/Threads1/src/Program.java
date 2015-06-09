

public class Program {
    static int cStatic = 0;
    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(new ThreadA(c));
//        Thread t2 = new Thread(new ThreadB(c));
//        t1.start();
//        t2.start();
        
        //System.out.println(c.returnCounter());
        BlockingQueue<Integer> queue = new BlockingQueue<>();
        Thread t1 = new ThreadAQueue(queue);
        Thread t2 = new ThreadBQueue(queue);
        t1.start();
        t2.start();
//        long start = System.currentTimeMillis();
//        PointsUtlity.generatePoints();
//        long end = System.currentTimeMillis();
//        System.out.println(end-start);
//        System.out.println(PointsUtlity.outMap.size());
    }
}   
