package daemon;

import lombok.SneakyThrows;

public class Test {
    @org.junit.jupiter.api.Test
    public void test(){
        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while(true){
                    System.out.println("1");
                    Thread.sleep(100);
                }
            }
        });
        thread.setDaemon(false);
        thread.start();
        System.out.println("main end");
    }

    public static void main(String[] args) {
        new Test().test();
    }
}
