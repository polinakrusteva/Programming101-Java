package monday;

public class Operations<T extends Number, V extends Number> {
	private T first;
	private V second;
	
	public Operations(T first, V second){
		this.first = first;
		this.second = second;
	}
	
	public void isZero(){
		try{
			if (second.doubleValue() == 0) {
				throw new ArithmeticException();
			}
		}
		catch(ArithmeticException ex){
			System.out.println("Cannot divide by zero");
		}
	}
	
	public T getFirst() {
		return first;
	}
	
	public V getSecond() {
		return second;
	}
	
	public void setFirst(T first) {
		this.first = first;
	}
	
	public void setSecond(V second) {
		this.second = second;
	}
	
	public double sum(){
		return first.doubleValue() + second.doubleValue();
	}
	
	public double subtract(){
		return first.doubleValue() - second.doubleValue();
	}
	
	public double multiply(){
		return first.doubleValue() * second.doubleValue();
	}
	
	public double divide(){
		isZero();
		return first.doubleValue() / second.doubleValue();
	}
	
	public double power(){
		return Math.pow(first.doubleValue(), second.doubleValue());
	}
	
	public static <T extends Number> double factorial(T number){
		double result = 1;
		for(double i = 1; i <= number.doubleValue(); i++){
			result *= i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Operations<Integer, Double> p = new Operations<>(3, 3.5);
		System.out.println(p.sum());
		System.out.println(factorial(new Integer(5)));
	}
}
