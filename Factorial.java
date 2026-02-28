package Jenkins_repo;
public class Factorial {
    public static long findFactorial(int n) {
        if(n < 0) return -1;
        long fact = 1;
        for(int i = 1; i <= n; i++){
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        int num = 5;
        long result = findFactorial(num);
        System.out.println("Factorial of " + num + " is " + result);
    }
}