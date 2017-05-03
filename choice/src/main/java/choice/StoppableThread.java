package choice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class StoppableThread implements Runnable {

	private static Logger logger = LoggerFactory.getLogger(StoppableThread.class);

	private Thread thread;

	private String name;
	private Status status = Status.READY;
	private long interval = 3000;

	public enum Status {
		READY("READY"), RUNNING("RUNNING"), STOPPING("STOPPING"), STOPPED("STOPPED");

		Status(String name) {
			value = name;
		}

		String value;
	}

	public StoppableThread(String name) {
		super();
		this.name = name;
		thread = new Thread(this, name);
	}

	public final void start() {
		thread.start();
	}

	@Override
	public void run() {
		this.status = Status.RUNNING;
		while (true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				logger.error(e.getMessage(), e);
				break;
			}
			if (status == Status.STOPPING) {
				break;
			}
			doOnce();
			if (status == Status.STOPPING) {
				break;
			}
		}
		this.status = Status.STOPPED;
	}

	public abstract void doOnce();

	public final void stop() {
		status = Status.STOPPING;
		System.out.println(name + " thread will be stopped");
	}

	public int getPriority() {
		return thread.getPriority();
	}

	public void setPriority(int newPriority) {
		thread.setPriority(newPriority);
	}

	public Status getStatus() {
		return status;
	}

	public long getInterval() {
		return interval;
	}

	public String getName() {
		return name;
	}

}
