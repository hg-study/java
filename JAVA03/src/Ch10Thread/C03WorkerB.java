package Ch10Thread;

// =======================================
// 작업 B (Swing)
// 0.5초마다 번호를 올리며 화면의 영역 2 에 출력
// =======================================

// 화면(C03GUI) 객체를 받아 그 안의 텍스트 영역에 직접 출력하는 작업. interrupt 되면 InterruptedException 으로 반복을 끝냄
public class C03WorkerB implements Runnable{

	C03GUI gui;
	
	public C03WorkerB(C03GUI c03gui) {
		this.gui = c03gui;
	}

	@Override
	public void run() {

		
		try {
			
		for(int i=0;; i++){
			System.out.println("TASK02..."+i);
			gui.area2.append("Task02..." + i + "\n");
			Thread.sleep(500);			
		}
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("[EXCEPTION] WORKER02 THREAD INTERRUPTED..");
		}
	}
	
}
