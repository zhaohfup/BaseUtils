package demo3.demo2.thread;

public class ThreadA extends Thread {
	private Count count;
	public ThreadA(Count count) {
		this.count=count;
	}
	public void run() {
		count.add();
	}
}
