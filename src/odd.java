class oddprint extends Thread
{
    public void run()
    {
        for(int i=1;i<20;i++)
            if(i%2!=0)
                System.out.println("odd"+i);
    }
}
class evenprint extends Thread
{
    public void run()
    {
        for(int i=1;i<20;i++)
            if(i%2==0)
                System.out.println("even"+i);
    }
}



public class odd extends Thread {

    public static void main(String[] args) {
        oddprint op=new oddprint();
       evenprint ep=new evenprint();
        Thread thread=new Thread(op);
        Thread thread1=new Thread(ep);
        thread1.start();
        thread.start();

    }



}
