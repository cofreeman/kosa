package week4.day2.practice;

public class ThreadLab2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (char c = 'A'; c <= 'L'; c++) {
                System.out.println(c);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (char c = 'a'; c <= 'h'; c++) {
                System.out.println(c);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 1; i <= 30; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("JAVA");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("MAIN 수행 종료");
    }
}

