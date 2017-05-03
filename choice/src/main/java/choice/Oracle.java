package choice;

public class Oracle extends StoppableThread {
	
	private static int COUNTDOWN_DAY = 7;
	
	private int countdownDay = COUNTDOWN_DAY;
	
	private StoppableThread[] threads = new StoppableThread[2];
	
	private boolean choosed = false;
	
	private String choice;
	
	private int priority = this.getPriority();
	
	public Oracle(StoppableThread k2, StoppableThread xx) {
		super("choice");
		threads[0] = k2;
		threads[1] = xx;
	}

	//called 'every day' once
	@Override
	public void doOnce() {
		if (!choosed) {
			if (--countdownDay > 0) {
				// priority from 1(MIN) to 10(MAX)
				if (this.getPriority() == Thread.MAX_PRIORITY - 1) {
					threads[1].stop();//other thread
					this.choice = threads[0].getName();
					this.choosed = true;
					System.out.println("something will be changed");
				} else {
					if (priority != this.getPriority()) {
						System.out.println("but nothing maybe happened");
						priority = this.getPriority();
					}
				}
				System.out.println(countdownDay + (countdownDay <= 1 ? " day " : " days ") + "left");
			} else if (countdownDay <= 0) {
				threads[0].stop(); //k2 thread
				this.choice = threads[1].getName();
				this.choosed = true;
			}
		} else {
			System.out.println("do what my choice " + choice);
		}
	}

	public boolean isChoosed() {
		return choosed;
	}

	public String getChoice() {
		return choice;
	}
	
}
