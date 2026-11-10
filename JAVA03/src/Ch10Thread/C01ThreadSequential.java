package Ch10Thread;

// =======================================
// 스레드 없이 순차 실행
// 하나의 흐름(메인 스레드)에서는 작업이 차례로만 실행됨
// =======================================

public class C01ThreadSequential {

	public static void main(String[] args) throws InterruptedException {
		
		// 스레드(Thread) : 프로그램 안에서 실행되는 하나의 흐름. main 메서드는 메인 스레드에서 실행됨
		// TASK01 이 모두 끝나야 TASK02 가 시작되는 순차 실행. 두 작업을 동시에 하려면 스레드를 나눠야 함
		// Thread.sleep(ms) : 지정한 시간 동안 현재 스레드를 멈춤. 도중에 interrupt 되면 InterruptedException 이 발생함
		for(int i=0; i<5; i++){
			System.out.println("TASK01...");
			Thread.sleep(500);
		}

		for(int i=0; i<5; i++){
			System.out.println("TASK02...");
			Thread.sleep(500);			
		}

	}
}
