package test;

import com.sun.javafx.binding.StringFormatter;

/**
 * Created by wanghm on 2014/12/8.
 */
public class TestVolatile {
    public volatile static  int count = 0;
    public static void  inc(){
        try{
            Thread.sleep(1);
        }catch (Exception e){}
        if(count > 952){
            System.out.println(count);
        }
        count++;
    }
    public static void main(String[] args) throws Exception{
        for(int i =0;i<1000;i++){
            Thread thread =  new Thread(new Runnable() {
                @Override
                public void run() {
                    TestVolatile.inc();
                }
            });
            if(i > 952){
                System.out.println("i="+i);
            }
            thread.start();
            //thread.join();
        }
        System.out.println(String.format("------>count=%d",new Object[]{count}));
    }

}
