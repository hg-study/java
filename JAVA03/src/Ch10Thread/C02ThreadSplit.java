package Ch10Thread;

// =======================================
// 스레드 나누기
// Runnable 구현과 Thread 상속으로 작업을 동시에 실행
// =======================================

public class C02ThreadSplit {
    public static void main(String[] args) {
        
        // Runnable 을 구현한 클래스로 스레드 나누기 ------

        // 1) 작업을 담은 Runnable 객체 만들기
        // Runnable : 스레드가 실행할 작업(run 메서드)을 담는 인터페이스
        // start() : 새 스레드를 만들어 run() 을 실행함. run() 을 직접 호출하면 새 스레드가 아니라 메인 스레드에서 실행됨
        C02WorkerA w1 = new C02WorkerA();
        C02WorkerB w2 = new C02WorkerB();

        // 2) Runnable 객체를 Thread 에 전달해 스레드 만들기
        Thread th1 = new Thread(w1);
        Thread th2 = new Thread(w2);
        
        // 3) start() 로 스레드 실행
        th1.start();
        th2.start();
        
        // Thread 클래스를 직접 상속(익명 클래스)해서 스레드 나누기 ------

        // 익명 클래스 : 이름 없는 클래스를 그 자리에서 정의해 Thread 의 run() 을 재정의하고 바로 start() 함
        new Thread() {

			@Override
			public void run() {
				
				for(int i=0; i<5; i++){
					System.out.println("TASK03...");
					try {
						Thread.sleep(500);
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}	
			}
        	
        }.start();

    }
}
