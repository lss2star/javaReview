package helloworld;

public class CalcMain {

	public static void main(String[] args) {
		Calculator calc1 = new Calc();
		Calculator calc2 = new Calc();
		
		int r1 = calc1.add(3, 5);
		int r2 = calc2.add(6, 3);
		
//		System.out.println(calc1.getMemory());
//		System.out.println(calc2.getMemory());
		
		System.out.println(r1);
		System.out.println(r2);
		
		double r3 = Calc.getCircleLength(3);
		System.out.println(r3);

	}

}
