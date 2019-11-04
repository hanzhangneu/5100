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
        
        //�����鸳ֵ
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*10);
        }
        
        //ѭ�������������̣߳����Ұ��̶߳�����뼯����
        for (int i = 0; i < threadNum; i++) {
            MyThread m = new MyThread(a, i * avg, (i + 1) * avg);
            m.start();
            list.add(m);
            //���������ѭ����join�����ɴ��С�
        }
        
        /**
         * ������4�����̶߳���ӵ����߳�ǰ����ɡ�
         * ȷ��ֻҪ���߳������������ѭ����4�����̵߳ļ�������Ͷ������ˣ�
         * ������������һ������ȷ����ֵ��������©�κ�һ���̵߳ļ�������
         * 
         * ���������һ�������߳����е������������ʱ��
         * �����е��̻߳�û����ɼ��㣬��������Ľ��������©��
         */
        for (int i = 0; i < list.size(); i++) {
            list.get(i).join();
        }
        
        //��ȡ�����̶߳���ļ����������
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getSum();
        }
        System.out.println("�������ĺ�Ϊ��" + sum);
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