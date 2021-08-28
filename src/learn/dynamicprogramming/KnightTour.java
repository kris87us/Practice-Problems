package learn.dynamicprogramming;

public class KnightTour {
    public static void main(String[] args) {
        System.out.println(numPhoneNumbers(6, 30));
    }

    // Bottom-up tabulation
    // Time: O(length)
    // Space: O(length)
    private static long numPhoneNumbers(int startdigit, int phonenumberlength) {
        long[][] table = new long[phonenumberlength][10];

        // Base case
        // # of phone numbers of length 1 will be 1
        table[0][startdigit] = 1;

        // DP case
        for (int i = 1; i < phonenumberlength; i++) {
            table[i][0] = table[i-1][4] + table[i-1][6];
            table[i][1] = table[i-1][6] + table[i-1][8];
            table[i][2] = table[i-1][7] + table[i-1][9];
            table[i][3] = table[i-1][4] + table[i-1][8];
            table[i][4] = table[i-1][3] + table[i-1][9] + table[i-1][0];
            table[i][5] = 0L;
            table[i][6] = table[i-1][0] + table[i-1][1] + table[i-1][7];
            table[i][7] = table[i-1][2] + table[i-1][6];
            table[i][8] = table[i-1][1] + table[i-1][3];
            table[i][9] = table[i-1][2] + table[i-1][4];
        }
        
        long ans = 0;
        // Sum all possible ending of length phonenumberlength
        for(int num = 0; num < 10; num++){
            ans += table[phonenumberlength-1][num];
        }
        
        return ans;
    }
}
