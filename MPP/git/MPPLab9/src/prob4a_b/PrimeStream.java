package prob4a_b;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimeStream {
	
	Stream<Integer> primes = Stream.iterate(2, x-> nextPrime(x)); 
	
	void printFirstNPrimes(long n){
		System.out.println(primes.limit(n).collect(Collectors.toList()));
	}
	
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
