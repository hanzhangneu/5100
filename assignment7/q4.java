import java.util.ArrayList;
import java.util.List;

public class q4 {
    public static void main(String[] args) throws InterruptedException {
        int arrayLength = 4000000;
        int[] a = new int[arrayLength];
        int threadNum = 4;
        int avg = arrayLength / threadNum;
        int sum = 0;
        List<MyThread> list = new ArrayList<MyThread>();
        
        //给数组赋值
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*10);
        }
        
        //循环创建并开启线程，并且把线程对象放入集合中
        for (int i = 0; i < threadNum; i++) {
            MyThread m = new MyThread(a, i * avg, (i + 1) * avg);
            m.start();
            list.add(m);
            //不能在这个循环中join，会变成串行。
        }
        
        /**
         * 将所有4个子线程都插队到主线程前面完成。
         * 确保只要主线程运行完了这个循环，4个子线程的计算任务就都做完了，
         * 这样最后输出的一定是正确的数值，不会遗漏任何一个线程的计算结果。
         * 
         * 如果不做这一步，主线程运行到最后输出结果的时候，
         * 可能有的线程还没有完成计算，这样输出的结果就有遗漏。
         */
        for (int i = 0; i < list.size(); i++) {
            list.get(i).join();
        }
        
        //获取各个线程对象的计算结果并相加
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getSum();
        }
        System.out.println("所有数的和为：" + sum);
    }
}

class MyThread extends Thread {
    public int sum = 0;
    private int[] a;
    private int start;
    private int end;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public MyThread(int[] a, int start, int end) {
        this.a = a;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        while (start < end) {
            sum += a[start];
            start++;
        }
    }

}