package prob4a_b;

import java.util.stream.Stream;

public class InfinitePrimes {
	
	final Stream<Integer> primes = Stream.iterate(2, n-> nextPrime(n)); 
	
//	public static Integer factorial(Integer n) {
//		Integer  fact = 1; 		
//		for(Integer i =1; i<=n; i++) {
//			fact= fact * i; 
//		}
//		
//		return fact; 
//	}

	
	boolean isPrime(int n) {
		if (n<=3) return true; 
		if(n%2 == 0 || n%3 == 0) return false; 
		for(int i = 5; i * i<=n; i=i+6) 
			if (n%i == 0 || n%(i+2) == 0)
				return false;
		
		return true; 
		
	}
	
	int nextPrime(int n) {
		int prime = n; 
		boolean found = false; 
		
		while(!found) {
			prime++; 
			if(isPrime(prime))
				found = true; 
		}
		
		return prime; 
	}

}
