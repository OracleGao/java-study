package choice;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("try to send priority value with http PUT request, using 'http://localhost:9495?priority=${PRIORITY_VALUE}'");
		System.out.println("priority value must between 1(min) and 10(max)");
		System.out.println("you can kill current process for rerunning");
		System.out.println("have fun and take it easy");
		K2 k2 = new K2();
		Other other = new Other();
		
		Oracle oracle = new Oracle(k2, other);
		
		k2.setOracle(oracle);
		other.setOracle(oracle);
				
		k2.start();
		other.start();
		oracle.start();
	}

}
