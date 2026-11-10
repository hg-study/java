package Ch10Thread;

// =======================================
// 작업 A
// TASK01 을 5번 출력하는 Runnable
// =======================================

// Runnable 을 구현하고 run() 에 스레드가 할 작업을 작성함
public class C02WorkerA implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<5; i++){
			System.out.println("TASK01...");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
