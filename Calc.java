package helloworld;

public class Calc implements Calculator{
	public static final double PI = 3.14;
	
	private int memory;
	
	public int add(int a, int b) {
		int sum = a + b;
		this.memory = sum;
		return sum;
	}
	
	public static double getCircleLength(double r) {
		return 2 * PI * r; // calc.PI 생략되어있음
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}
	
	
}
