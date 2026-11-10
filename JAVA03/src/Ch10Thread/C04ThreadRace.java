package Ch10Thread;

// =======================================
// 스레드 경쟁 상태 문제
// 동기화 없이 공유 변수를 증가시키면 결과가 틀리는 문제
// =======================================

// 문제 : 스레드 4개가 공유 변수 counter 를 각각 100000번 증가시키면 최종값은 400000 이어야 함
// 경쟁 상태(Race Condition) : 여러 스레드가 동기화 없이 같은 변수를 동시에 바꿔 값이 덮어써지는 현상. 최종값이 400000 보다 작게 나옴
class RaceIncrementThread implements Runnable {
	private static int counter = 0;

	public int getCounter() {
		return counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			counter++; // 공유변수값증가
			System.out.println(Thread.currentThread().getName() + "s counter : " + counter);
		}
	}

}

public class C04ThreadRace {

	public static void main(String[] args) throws InterruptedException {

		
		RaceIncrementThread incrementThread1 = new RaceIncrementThread();
		RaceIncrementThread incrementThread2 = new RaceIncrementThread();
		RaceIncrementThread incrementThread3 = new RaceIncrementThread();
		RaceIncrementThread incrementThread4 = new RaceIncrementThread();

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
		
		//메인 스레드가 thread1,thread2의 작업이 모두 완료될 때까지 대기하도록 설정
		// join() : 해당 스레드의 작업이 끝날 때까지 메인 스레드가 기다림. 모두 끝난 뒤에 최종값을 출력함
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();

		System.out.println("Final value: " + incrementThread1.getCounter());

	}
}
