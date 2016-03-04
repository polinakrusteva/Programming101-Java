package monday;

public class LucasSeries {
	
	public static int nthLucas(int n){
		if(n == 0){
			return 2;
		} else if(n == 1){
			return 1;
		}
		return nthLucas(n - 1) + nthLucas(n-2);
	}
	
	public static void main(String[] args) {
		System.out.println(nthLucas(5));
		System.out.println(nthLucas(9));
	}
}
