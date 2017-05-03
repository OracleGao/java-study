package choice;

//we are a team
public class Team extends StoppableThread {

	protected Oracle oracle;
	
	public Team(String name) {
		super(name);
	}

	@Override
	public void doOnce() {
		if (oracle.isChoosed()) {
			if (getName().equals(oracle.getChoice())) {
				System.out.println("For Glory of " + oracle.getChoice());
			}
		}
	}

	public Oracle getOracle() {
		return oracle;
	}

	public void setOracle(Oracle oracle) {
		this.oracle = oracle;
	}

}
