2.	//C18302166
3.	//miller rabin Algorithm 
4.	// 15/11/2021
5.	
6.	import java.util.Scanner;
7.	import java.util.concurrent.ThreadLocalRandom;
8.	
9.	public class millerRabin {
10.	
11.	    public static void main(String[] args) {
12.	        String prime = "";
13.	        long n;
14.	        boolean isPrime;
15.	        Scanner scan = new Scanner(System.in);
16.	        System.out.println("Enter a number to check if it is prime: ");
17.	        n = scan.nextLong();
18.	        scan.close();
19.	        isPrime = checkIfPrime(n);
20.	
21.	        if(isPrime){
22.	            prime = "Composite";
23.	        }else{
24.	            prime = "Inconclusive";
25.	        }
26.	        System.out.println("The number: " + n + " is: " + prime);
27.	
28.	    }
29.	
30.	    private static boolean checkIfPrime(long n){
31.	        // Return false if n is 0 or 1 as its not prime
32.	        if(n == 0 || n == 1){
33.	            return false;
34.	        }
35.	        // Return true if n is 2, as it is prime
36.	        if(n == 2){
37.	            return true;
38.	        }
39.	        // If its an even number other than 2 then return false.
40.	        if(n % 2 == 0){
41.	            return false;
42.	        }
43.	
44.	        long q = n-1;
45.	        int k = 0;
46.	        while(q % 2 == 0){ 
47.	            q = q/2; 
48.	            k++;     
49.	        }
50.	        // Select random integer a where 1 < a < n-1
51.	        long a = ThreadLocalRandom.current().nextLong(1, (n-1));
52.	
53.	        // If a^q mod n == 1 then return "inconclusive"
54.	        if(((a^q) % n) == 1){
55.	            return false;
56.	        }
57.	
58.	        for(int j =0; j < k-1; j++){
59.	           
60.	            long power = 2^j * q;
61.	            long res = a^power;
62.	
63.	            if(res % n == n-1) {
64.	                return false;
65.	            }
66.	        }
67.	        return true;
68.	    }
69.	}
70.	


