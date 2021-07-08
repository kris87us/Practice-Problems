package learn.recursion;

public class NumberOfSubsetsOfASet {
    public static void main(String[] args) {
        System.out.print(numberOfSubsets(1));
    }

    private static int numberOfSubsets(int n) {
        if (n == 0) return 1;
        return 2* numberOfSubsets(n-1);
    }
}
