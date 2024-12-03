import java.lang.Object;

public class ThreadingEvenOdd{
    private static final int MAX_NUMBER = 20;
    private static Object lock = new Object();
    private static boolean isEven = true;
    public static void main(String[] args){
        Thread evenThread = new Thread(() -> {
            for(int i=2; i<=MAX_NUMBER; i+=2){
                synchronized(lock){
                    try{
                        while(!isEven){
                            lock.wait();
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("Even number: " + i);
                    isEven = false;
                    lock.notify();
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            for(int i=1; i<=MAX_NUMBER; i+=2){
                synchronized(lock){
                    try{
                        while(isEven){
                            lock.wait();
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("Odd number: " + i);
                    isEven = true;
                    lock.notify();
                }
            }
        });
        evenThread.start();
        oddThread.start();
    }
}