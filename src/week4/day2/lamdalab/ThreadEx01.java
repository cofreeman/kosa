package week4.day2.lamdalab;

class ThreadEx01 {
	public static void main(String args[]) {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()); // 조상인 Thread의 getName()을 호출
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				// Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
				System.out.println(Thread.currentThread().getName());
			}
		}); // 생성자 Thread(Runnable target)

		t1.start();
		t2.start();
	}
}


