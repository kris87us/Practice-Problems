package learn.recursion;

public class HowManyBinaryTreesFrom_N_nodes {
    
    public static void main(String[] args) {
        System.out.println(numberOfBinaryTrees(4));
    }
    private static int numberOfBinaryTrees(int n) {
        if (n <= 1) return 1;

        int sum = 0;
        // Loop through the nodes and arrange them left/right
        for (int i = 1; i <= n; i++) {
            int left = numberOfBinaryTrees(i - 1);
            int right = numberOfBinaryTrees(n - i);

            sum += left * right;
        }
        return sum;
    }
}

