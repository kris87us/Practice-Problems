package learn.other;

public class ScoresAverage {
    public int scoresAverage(int[] scores) {
        int firstHalf = average(scores, 0, (scores.length/2) - 1);
        int secondHalf = average(scores, scores.length/2, scores.length - 1);

        return Math.max(firstHalf, secondHalf);
    }

    public static int average(int[] scores, int start, int end) {
        int sum = 0;
        for (int i = start; i<=end; i++) {
            sum += scores[i];
        }
        return sum / (scores.length/2);
    }

    public static void main(String[] args) {
        System.out.println(average(new int[]{4,4,4,2,2,2}, 0, 2));
    }
}
