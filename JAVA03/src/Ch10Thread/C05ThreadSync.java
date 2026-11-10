package Ch10Thread;

// =======================================
// 스레드 동기화
// synchronized 로 공유 변수 보호하기
// =======================================

// 동기화(synchronized) : 한 번에 하나의 스레드만 임계 영역(공유 자원을 쓰는 코드)에 들어가게 하는 것. 락(Lock) 객체를 기준으로 잠금
// wait(ms) : 락을 놓고 지정 시간 동안 대기, notifyAll() : 대기 중인 다른 스레드를 깨움
class IncrementThread implements Runnable {
	private static int counter = 0;

	private static final Object Lock = new Object(); 	// 자물쇠
	
	
	public int getCounter() {
		return counter;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 100000; i++) {
			
			synchronized(Lock) {
				counter++; // 공유변수값증가
				System.out.println(Thread.currentThread().getName() + "s counter : " + counter);	
				
				Lock.notifyAll(); 	// 대기상태인 다른 스레드에게 알림
				
				try {
					Lock.wait(5);   // 해당 스레드 대기
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}		
			}
		}
	}

	
}

public class C05ThreadSync {

	public static void main(String[] args) throws InterruptedException {

		
		IncrementThread incrementThread1 = new IncrementThread();
		IncrementThread incrementThread2 = new IncrementThread();
		IncrementThread incrementThread3 = new IncrementThread();
		IncrementThread incrementThread4 = new IncrementThread();

		Thread thread1 = new Thread(incrementThread1);
		Thread thread2 = new Thread(incrementThread2);
		Thread thread3 = new Thread(incrementThread3);
		Thread thread4 = new Thread(incrementThread4);

		thread1.setName("TH1");
		thread2.setName("TH2");
		thread3.setName("TH3");
		thread4.setName("TH4");

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		// join() : 네 스레드의 작업이 모두 끝날 때까지 메인 스레드가 기다림
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();

		System.out.println("Final value: " + incrementThread1.getCounter());

	}
}
